package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

/**
 * Activity for User Registration.
 *
 */
public class RegisterUserActivity extends AppCompatActivity {

    private EditText email, password, password1;
    private Button register;
    private FirebaseFirestore db;
    private int tmp = -1;
    private CollectionReference ref;
    private FirebaseAuth auth;
    private TextView goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        email = findViewById(R.id.resEmail);
        password = findViewById(R.id.resPass);
        password1 = findViewById(R.id.resConfirmPass);
        register = findViewById(R.id.resbutton);
        goBack = findViewById(R.id.go_back);
        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(v -> {
            String txt_email = email.getText().toString();
            String txt_password = password.getText().toString();
            String txt_password1 = password1.getText().toString();

            if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_password1)) {
                Toast.makeText(RegisterUserActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
            } else if (!txt_password.equals(txt_password1)) {
                Toast.makeText(RegisterUserActivity.this, "Password not matched!", Toast.LENGTH_SHORT).show();
            } else if (txt_password.length() < 6) {
                Toast.makeText(RegisterUserActivity.this, "Password is too short!", Toast.LENGTH_SHORT).show();
            }else if(emailValidation(txt_email)){
                Toast.makeText(RegisterUserActivity.this, "Please use your edu mail", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("debug", "calling");
                register(txt_email, txt_password);
            }
        });

        goBack.setOnClickListener(v -> {
            startActivity(new Intent(RegisterUserActivity.this, AuthenticationActivity.class));
            finish();
        });

    }

    /**
     * set the database path
     */
    private void setDb() {
        if (tmp == 1) ref = db.collection("teachers");
        else if (tmp == 2) ref = db.collection("officials");
        else {
            ref = db.collection("students").document("all-Students").collection("by_id");
        }
    }


    /**
     * register a User.
     *
     * @param UEmail: email
     * @param UPassword: password
     * @param Uname: name
     * @param UPhone: phone number
     * @param Uid: id
     */
    private void registerUser(final String UEmail, final String UPassword, final String Uname, final String UPhone, final String Uid) {
        if(UEmail.matches(".*25[\\d][\\d]@student.nstu.edu.bd")){ //for edu mail
            register(UEmail,UPassword);
        }else{         // for normal mail that we have in our database
            ref.whereEqualTo("email", UEmail)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                boolean ok = true;
                                if (!Uname.toLowerCase().equals(document.get("name").toString().toLowerCase()))
                                    ok = false;
                                if (!UPhone.toLowerCase().equals(document.get("phone").toString().toLowerCase()))
                                    ok = false;
                                if (tmp == 3) {
                                    if (!Uid.toLowerCase().equals(document.get("id").toString().toLowerCase()))
                                        ok = false;
                                }

                                if (ok) {
                                    register(UEmail, UPassword);
                                } else {
                                    Toast.makeText(RegisterUserActivity.this, "Invalid information", Toast.LENGTH_SHORT).show();
                                }

                                Log.e("debug", String.valueOf(ok));
                                Log.e("debug", document.getId() + " => " + document.getData());
                                startActivity(new Intent(RegisterUserActivity.this, AuthenticationActivity.class));
                                finish();
                            }
                        } else {
                            startActivity(new Intent(RegisterUserActivity.this, AuthenticationActivity.class));
                            finish();
                            Log.d("debug", "Error getting documents: ", task.getException());
                        }
                    });
        }
    }


    /**
     * register by email and password.
     *
     * @param email: email
     * @param password: password
     */
    private void register(String email, String password) {
        Log.e("debug", "registering");
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterUserActivity.this, task -> {

            //Log.e("debug",task.getResult().toString());

            if (task.isSuccessful()) {

                auth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(RegisterUserActivity.this, "A verification email is sent to your edu mail", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterUserActivity.this, AuthenticationActivity.class));
                        finish();
                    }
                });

            } else {
                if(task.getException() instanceof FirebaseAuthUserCollisionException){
                    Toast.makeText(RegisterUserActivity.this, "This email is already registered", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterUserActivity.this, "registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean emailValidation(String email) {
        if(email.endsWith("nstu.edu.bd")){
            return false;
        }else {
            return true;
        }
    }
}

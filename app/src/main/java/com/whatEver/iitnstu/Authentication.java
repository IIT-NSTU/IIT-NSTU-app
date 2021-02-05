package com.whatEver.iitnstu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Authentication extends AppCompatActivity {

    private EditText email,password;
    private Button login,guest;
    private TextView register;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.loginbutton);
        guest=findViewById(R.id.guestbutton);
        register=findViewById(R.id.register);
        auth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();

                auth.signInWithEmailAndPassword(txt_email,txt_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Authentication.this, "Login successful!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Authentication.this,HomeActivity.class));
                            finish();
                        }
                        else{
                            Toast.makeText(Authentication.this, "Wrong email & password!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signInAnonymously();
                Toast.makeText(Authentication.this, "as a guest some feature will not available.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Authentication.this,HomeActivity.class));
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Authentication.this,RegisterUser.class));
                finish();
            }
        });


    }

    /*@Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=auth.getCurrentUser().;
        if(user!=null)
            startActivity(new Intent(Authentication.this,HomeActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }*/
}

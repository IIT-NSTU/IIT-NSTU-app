package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Activity for Course Authentication.
 *
 */
public class AuthenticationActivity extends AppCompatActivity {

    private EditText email, password;
    private Button login;
    private TextView register, guest;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginbutton);
        guest = findViewById(R.id.guestbutton);
        register = findViewById(R.id.register);
        auth = FirebaseAuth.getInstance();


        login.setOnClickListener(v -> {
            String txt_email = email.getText().toString();
            String txt_password = password.getText().toString();

            if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                Toast.makeText(AuthenticationActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
            } else {
                auth.signInWithEmailAndPassword(txt_email, txt_password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(AuthenticationActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AuthenticationActivity.this, HomeActivity.class));
                        finish();
                    } else {
                        Toast.makeText(AuthenticationActivity.this, "Wrong email & password!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        guest.setOnClickListener(v -> {
            auth.signInAnonymously();
            Toast.makeText(AuthenticationActivity.this, "as a guest some feature will not available.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(AuthenticationActivity.this, HomeActivity.class));
            finish();
        });

        register.setOnClickListener(v -> {
            startActivity(new Intent(AuthenticationActivity.this, RegisterUserActivity.class));
            finish();
        });
    }
}

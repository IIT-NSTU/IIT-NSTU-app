package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class StudentInfoLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_login);
    }
    public void login(View view){
        TextView idText=findViewById(R.id.loginId);
        String id=idText.getText().toString();
       // if (Pattern.matches("[ashASHmuMUbkBKfF]{3}[1-2][890]250[0-4][0-9][mfMF]",id)){
            Intent intent=new Intent(StudentInfoLogin.this, StudentInfoMain.class);
            startActivity(intent);
       //     idText.setText("");
        //}
      //  else {
       //     Toast.makeText(this, "Sorry only student!!", Toast.LENGTH_SHORT).show();
       // }
    }
}

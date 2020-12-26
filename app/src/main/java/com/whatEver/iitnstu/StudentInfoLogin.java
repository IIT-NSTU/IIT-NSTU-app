package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class StudentInfoLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_login);


        //getView().setBackgroundDrawable();
        //getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
    }
    public void login(View view){
        TextView idText=findViewById(R.id.loginId);
        String id=idText.getText().toString();
        if (Pattern.matches("[ashASHmuMUbkBKfF]{3}[1-2][890]250[0-4][0-9][mfMF]",id)){
            Intent intent=new Intent(StudentInfoLogin.this, StudentInfoMain.class);
            startActivity(intent);
           idText.setText("");
        }
        else {
            Toast.makeText(this, "Sorry only student!!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}

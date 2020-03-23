package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void onClick(View view){
        Intent intent=new Intent(HomeActivity.this,IntroActivity.class);
        startActivity(intent);
    }

    public void Click_Function(View view){
        Intent intent1=new Intent(HomeActivity.this,SyllabusActivity.class);
        startActivity(intent1);
    }

    public void startCourseCoodinator(View view){
        Intent intent2=new Intent(HomeActivity.this,courseCoordinatorAcitivity.class);
        startActivity(intent2);
    }
    public void teachers(View view){
        Intent intent3=new Intent(HomeActivity.this,TeachersInfoActivity.class);
        startActivity(intent3);
    }
}

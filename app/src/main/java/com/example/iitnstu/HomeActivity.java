package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Intent intent=new Intent(HomeActivity.this,SyllabusActivity.class);
        startActivity(intent);
    }

    public void startCourseCoodinator(View view){
        Intent intent=new Intent(HomeActivity.this,courseCoordinatorAcitivity.class);
        startActivity(intent);
    }
    public void teachers(View view){
        Intent intent=new Intent(HomeActivity.this,TeachersInfoActivity.class);
        startActivity(intent);
    }
    public void startStudentInfo(View view){
        Intent intent=new Intent(HomeActivity.this, StudentInfoLogin.class);
        startActivity(intent);
    }

    public void startDirectorProfile(View view){
        Intent intent=new Intent(HomeActivity.this, DirectorProfile.class);
        startActivity(intent);
    }

    public void startAllCourse(View view){
        Intent intent=new Intent(HomeActivity.this, AllCourseMain.class);
        startActivity(intent);
    }


    public void startdeveloper(View view){
        Intent intent=new Intent(HomeActivity.this, developers.class);
        startActivity(intent);
    }
}

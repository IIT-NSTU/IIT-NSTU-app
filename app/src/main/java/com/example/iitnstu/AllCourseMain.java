package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AllCourseMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_course_main);
    }

    public void onClick(View view){
        Intent intent=new Intent(AllCourseMain.this, FirstSemester.class);
        startActivity(intent);
    }

    public void secondsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, SecondSemester.class);
        startActivity(intent);
    }

    public void thirdsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, ThirdSemester.class);
        startActivity(intent);
    }

    public void fourthsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, FourthSemester.class);
        startActivity(intent);
    }

    public void fifthsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, FifthSemester.class);
        startActivity(intent);
    }

    public void sixthsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, SixthSemester.class);
        startActivity(intent);
    }

    public void seventhsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, SeventhSemester.class);
        startActivity(intent);
    }

    public void eighthsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, EighthSemester.class);
        startActivity(intent);
    }


}

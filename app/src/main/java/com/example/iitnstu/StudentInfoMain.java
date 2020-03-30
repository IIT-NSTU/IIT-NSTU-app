package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentInfoMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_main);
    }

    public void onClick(View view){
        Intent intent=new Intent(this,SecondBatchInfo.class);
        startActivity(intent);
    }

    public void startThirdBatch(View view){
        Intent intent=new Intent(this,ThirdBatchInfo.class);
        startActivity(intent);
    }
}

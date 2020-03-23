package com.example.iitnstu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SyllabusActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
    }

    public void Click_Function(View view){
        Intent intent1=new Intent(SyllabusActivity.this,SyllabusActivity.class);
        startActivity(intent1);
    }
}

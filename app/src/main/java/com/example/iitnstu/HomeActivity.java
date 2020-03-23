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
}

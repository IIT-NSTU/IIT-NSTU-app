package com.example.iitnstu;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class SyllabusActivity extends AppCompatActivity {

    Button View_Syllabus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        View_Syllabus = (Button) findViewById(R.id.button);

        View_Syllabus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent (SyllabusActivity.this, Pdf_Syllabus_Activity.class);
                startActivity(i);

            }


        });
    }


}

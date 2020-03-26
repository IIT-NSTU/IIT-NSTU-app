package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class SecondSemester extends AppCompatActivity {

    PDFView secondsemester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_semester);

        secondsemester = (PDFView) findViewById(R.id.SecondSemesterPdf);
        secondsemester.fromAsset("2ndSemester.pdf").load();
    }
}

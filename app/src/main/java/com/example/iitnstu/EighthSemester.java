package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class EighthSemester extends AppCompatActivity {

    PDFView eighthsemester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eighth_semester);


        eighthsemester = (PDFView) findViewById(R.id.EighthSemesterPdf);
        eighthsemester.fromAsset("8thSemester.pdf").load();
    }
}

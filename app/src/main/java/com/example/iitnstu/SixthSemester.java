package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class SixthSemester extends AppCompatActivity {

    PDFView sixthsemester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth_semester);


        sixthsemester = (PDFView) findViewById(R.id.SixthSemesterPdf);
        sixthsemester.fromAsset("6thSemester.pdf").load();
    }
}

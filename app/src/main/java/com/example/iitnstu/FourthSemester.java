package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class FourthSemester extends AppCompatActivity {

    PDFView fourthsemester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_semester);

        fourthsemester = (PDFView) findViewById(R.id.FourthSemesterPdf);
        fourthsemester.fromAsset("4thSemester.pdf").load();
    }
}

package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class FirstSemester extends AppCompatActivity {

    PDFView firstsemester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_semester);

        firstsemester = (PDFView) findViewById(R.id.FirstSemesterPdf);
        firstsemester.fromAsset("1stSemester.pdf").load();
    }
}

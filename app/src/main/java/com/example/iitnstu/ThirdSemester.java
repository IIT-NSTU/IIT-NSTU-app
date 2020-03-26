package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ThirdSemester extends AppCompatActivity {

    PDFView thirdsemester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_semester);

        thirdsemester = (PDFView) findViewById(R.id.ThirdSemesterPdf);
        thirdsemester.fromAsset("3rdSemester.pdf").load();
    }
}

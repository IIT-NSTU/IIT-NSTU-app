package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class SeventhSemester extends AppCompatActivity {

    PDFView seventhsemester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh_semester);


        seventhsemester = (PDFView) findViewById(R.id.SeventhSemesterPdf);
        seventhsemester.fromAsset("7thSemester.pdf").load();
    }
}

package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class FifthSemester extends AppCompatActivity {

    PDFView fifthsemester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_semester);

        fifthsemester = (PDFView) findViewById(R.id.FifthSemesterPdf);
        fifthsemester.fromAsset("5thSemester.pdf").load();
    }
}

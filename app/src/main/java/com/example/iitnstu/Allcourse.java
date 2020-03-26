package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Allcourse extends AppCompatActivity {

    PDFView syllabus2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcourse);

        //syllabus2 = (PDFView) findViewById(R.id.Pdf);
        //syllabus2.fromAsset("Syllabus.pdf").load();
    }

}

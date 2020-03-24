package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Pdf_Syllabus_Activity extends AppCompatActivity {

    PDFView pdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf__syllabus_);

        pdf = (PDFView) findViewById(R.id.PdfSyllabus);
        pdf.fromAsset("BSSE-Syllabus.pdf").load();
    }
}

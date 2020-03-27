package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewer extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        String pdfName=getIntent().getExtras().getString("pdfName");

        pdfView = (PDFView) findViewById(R.id.Pdf);
        pdfView.fromAsset(pdfName).load();
    }
}

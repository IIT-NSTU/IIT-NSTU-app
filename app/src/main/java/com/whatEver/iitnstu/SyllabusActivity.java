package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.whatEver.iitnstu.tools.PdfViewer;


public class SyllabusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
    }

    public void firstSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "1stSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    public void secondSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "2ndSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    public void thirdSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "3rdSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    public void fourthSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "4thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    public void fifthSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "5thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    public void sixthSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "6thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    public void seventhSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "7thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    public void eighthSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "8thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }


}

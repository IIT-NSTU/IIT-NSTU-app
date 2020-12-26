package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SyllabusMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
    }

    public void firstSemesterStart(View view){
        Intent intent=new Intent(SyllabusMain.this, PdfViewer.class).putExtra("pdfName","1stSemester.pdf");
        startActivity(intent);
    }

    public void secondSemesterStart(View view){
        Intent intent=new Intent(SyllabusMain.this, PdfViewer.class).putExtra("pdfName","2ndSemester.pdf");
        startActivity(intent);
    }

    public void thirdSemesterStart(View view){
        Intent intent=new Intent(SyllabusMain.this, PdfViewer.class).putExtra("pdfName","3rdSemester.pdf");
        startActivity(intent);
    }

    public void fourthSemesterStart(View view){
        Intent intent=new Intent(SyllabusMain.this, PdfViewer.class).putExtra("pdfName","4thSemester.pdf");
        startActivity(intent);
    }

    public void fifthSemesterStart(View view){
        Intent intent=new Intent(SyllabusMain.this, PdfViewer.class).putExtra("pdfName","5thSemester.pdf");
        startActivity(intent);
    }

    public void sixthSemesterStart(View view){
        Intent intent=new Intent(SyllabusMain.this, PdfViewer.class).putExtra("pdfName","6thSemester.pdf");
        startActivity(intent);
    }

    public void seventhSemesterStart(View view){
        Intent intent=new Intent(SyllabusMain.this, PdfViewer.class).putExtra("pdfName","7thSemester.pdf");
        startActivity(intent);
    }

    public void eighthSemesterStart(View view){
        Intent intent=new Intent(SyllabusMain.this, PdfViewer.class).putExtra("pdfName","8thSemester.pdf");
        startActivity(intent);
    }


}

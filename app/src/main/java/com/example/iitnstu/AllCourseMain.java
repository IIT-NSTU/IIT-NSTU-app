package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AllCourseMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_course_main);
    }

    public void onClick(View view){
        Intent intent=new Intent(AllCourseMain.this, PdfViewer.class).putExtra("pdfName","1stSemester.pdf");
        startActivity(intent);
    }

    public void secondsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, PdfViewer.class).putExtra("pdfName","2ndSemester.pdf");
        startActivity(intent);
    }

    public void thirdsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, PdfViewer.class).putExtra("pdfName","3rdSemester.pdf");
        startActivity(intent);
    }

    public void fourthsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, PdfViewer.class).putExtra("pdfName","4thSemester.pdf");
        startActivity(intent);
    }

    public void fifthsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, PdfViewer.class).putExtra("pdfName","5thSemester.pdf");
        startActivity(intent);
    }

    public void sixthsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, PdfViewer.class).putExtra("pdfName","6thSemester.pdf");
        startActivity(intent);
    }

    public void seventhsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, PdfViewer.class).putExtra("pdfName","7thSemester.pdf");
        startActivity(intent);
    }

    public void eighthsemesterstart(View view){
        Intent intent=new Intent(AllCourseMain.this, PdfViewer.class).putExtra("pdfName","8thSemester.pdf");
        startActivity(intent);
    }


}

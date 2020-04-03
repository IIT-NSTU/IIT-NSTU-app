package com.example.iitnstu;
import android.os.Bundle;



import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class AllCourseDetails extends AppCompatActivity {

    PDFView syllabus1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        syllabus1 = (PDFView) findViewById(R.id.PdfSyllabus);
        syllabus1.fromAsset("BSSE-Syllabus.pdf").load();

    }


}

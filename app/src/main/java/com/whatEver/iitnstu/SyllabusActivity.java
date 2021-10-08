package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.whatEver.iitnstu.tools.PdfViewer;

/**
 * Activity for Syllabus.
 *
 */
public class SyllabusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
    }

    /**
     * Onclick function for first semester button.
     *
     * @param view: first semester button
     */
    public void firstSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "1stSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    /**
     * Onclick function for second semester button.
     *
     * @param view: second semester button
     */
    public void secondSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "2ndSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    /**
     * Onclick function for third semester button.
     *
     * @param view: third semester button
     */
    public void thirdSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "3rdSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    /**
     * Onclick function for fourth semester button.
     *
     * @param view: fourth semester button
     */
    public void fourthSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "4thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    /**
     * Onclick function for fifth semester button.
     *
     * @param view: fifth semester button
     */
    public void fifthSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "5thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    /**
     * Onclick function for sixth semester button.
     *
     * @param view: sixth semester button
     */
    public void sixthSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "6thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    /**
     * Onclick function for seven semester button.
     *
     * @param view: seven semester button
     */
    public void seventhSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "7thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }

    /**
     * Onclick function for eighth semester button.
     *
     * @param view: eighth semester button
     */
    public void eighthSemesterStart(View view) {
        Intent intent = new Intent(SyllabusActivity.this, PdfViewer.class)
                .putExtra("pdfName", "8thSemester.pdf")
                .putExtra("folder", "syllabus");
        startActivity(intent);
    }


}

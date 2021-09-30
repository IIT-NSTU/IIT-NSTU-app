package com.whatEver.iitnstu;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.storage.FirebaseStorage;

public class AllCourseDetails extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_course);

        pdfView = findViewById(R.id.PdfSyllabus);

        fetchingData();
    }


    private void fetchingData() {
        final LoadingDialog loadingDialog = new LoadingDialog(AllCourseDetails.this);
        loadingDialog.startLoadingDialog();

        FirebaseStorage.getInstance().getReference().child("course-details").child("course-details.pdf")
                .getBytes(1024 * 1024).addOnSuccessListener(bytes -> {
                    loadingDialog.dismissDialog();
                    Toast.makeText(getApplicationContext(), "Zoom out !!", Toast.LENGTH_LONG).show();
                    pdfView.fromBytes(bytes).load();
                }).addOnFailureListener(e ->
                Toast.makeText(getApplicationContext(), "download unsuccessful", Toast.LENGTH_LONG).show());
    }

}

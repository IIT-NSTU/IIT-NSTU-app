package com.whatEver.iitnstu;
import android.os.Bundle;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;

public class AllCourseDetails extends AppCompatActivity {

    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_course);

        final LoadingDialog loadingDialog=new LoadingDialog(AllCourseDetails.this);
        loadingDialog.startLoadingDialog();

        pdfView = (PDFView) findViewById(R.id.PdfSyllabus);

        FirebaseStorage.getInstance().getReference().child("course-details").child("course-details.pdf").getBytes(1024 * 1024).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                loadingDialog.dismissDialog();
                Toast.makeText(getApplicationContext(),"Zoom out !!",Toast.LENGTH_LONG).show();
                pdfView.fromBytes(bytes).load();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"download unsuccessful",Toast.LENGTH_LONG).show();
            }
        });

    }


}

package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.whatEver.iitnstu.cards.BatchCard;
import com.whatEver.iitnstu.models.Batch;
import com.whatEver.iitnstu.tools.LoadingDialog;

import java.util.HashMap;


public class StudentInfoActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private FirebaseFirestore db;
    private Context context;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_main);

        gridLayout = findViewById(R.id.batchCardBucket);
        db = FirebaseFirestore.getInstance();
        context = this;
        loadingDialog = new LoadingDialog(StudentInfoActivity.this);

        fetchingData();
    }


    private void fetchingData() {
        loadingDialog.startLoadingDialog();

        db.collection("batches").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                loadingDialog.dismissDialog();
                for (DocumentSnapshot data : task.getResult()) {
                    HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();

                    Batch newBatch = new Batch(tmp.get("name").toString(),
                            tmp.get("des").toString(), tmp.get("session").toString(), tmp.get("iconColor").toString());

                    BatchCard batchCard = new BatchCard(context, newBatch);
                    gridLayout.addView(batchCard);
                }
            } else {
                Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

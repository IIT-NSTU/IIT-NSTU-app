package com.example.iitnstu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;

public class StudentInfoMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_main);

        final GridLayout gridLayout=findViewById(R.id.batchCardBucket);
        FirebaseFirestore db= FirebaseFirestore.getInstance();
        final Context context=this;

        final LoadingDialog loadingDialog=new LoadingDialog(StudentInfoMain.this);
        loadingDialog.startLoadingDialog();


        db.collection("batches").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    loadingDialog.dismissDialog();
                    //Log.d("debug",task.getResult().toString());
                    for (DocumentSnapshot data: task.getResult()) {
                        HashMap<String,Object> tmp=(HashMap<String, Object>) data.getData();

                        BatchCard batchCard = new BatchCard(context, tmp.get("name").toString(),
                                tmp.get("des").toString(),tmp.get("session").toString(),tmp.get("iconColor").toString());
                        gridLayout.addView(batchCard);
                        //Log.d("debug",data.getData().toString());
                    }
                }
                else {
                    Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    /*public void onClick(View view){
        Intent intent=new Intent(this,SecondBatch.class);
        startActivity(intent);
    }

    public void startThirdBatch(View view){
        Intent intent=new Intent(this,SecondBatch.class);
        startActivity(intent);
    }*/
}

package com.example.iitnstu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class TeachersInfo extends AppCompatActivity {

    private FirebaseFirestore db;
    private GridLayout gridLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_info);

        gridLayout = findViewById(R.id.gridlayout_4);
        db=FirebaseFirestore.getInstance();
        final Context context=this;

        final LoadingDialog loadingDialog=new LoadingDialog(TeachersInfo.this);
        loadingDialog.startLoadingDialog();

        //if(Connection.check(context))
            db.collection("teachers").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (DocumentSnapshot data: task.getResult()) {
                        HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                        TeacherCard teacherCard = new TeacherCard(context, tmp.get("name").toString(),
                                tmp.get("designation").toString(), tmp.get("phone").toString(),
                                tmp.get("email").toString(), tmp.get("imageLink").toString());

                        gridLayout.addView(teacherCard);
                        //Log.d("debug",data.getData().toString());
                    }
                    loadingDialog.dismissDialog();
                }
                else {
                    Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //else Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();

    }
}

package com.example.iitnstu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class TeachersInfo extends AppCompatActivity {

    private FirebaseFirestore db;
    private GridLayout gridLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_info2);

        gridLayout = findViewById(R.id.gridlayout_4);
        db=FirebaseFirestore.getInstance();
        final Context context=this;

        db.collection("teachers").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot data: task.getResult()) {
                        HashMap<String,Object> tmp=(HashMap<String, Object>) data.getData();

                        Cards4 cards4 = new Cards4(context, tmp.get("name").toString(),
                                tmp.get("designation").toString(),tmp.get("phone").toString(),
                                tmp.get("email").toString(),tmp.get("imageLink").toString());

                        gridLayout.addView(cards4);
                        //Log.d("debug",data.getData().toString());
                    }
                }
                else {
                    Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

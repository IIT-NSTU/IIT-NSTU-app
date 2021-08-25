package com.whatEver.iitnstu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class StudentAdapter extends AppCompatActivity {
    private FirebaseFirestore db;
    private GridLayout gridLayout;
    private String batch_id;
    private String header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_batch_info);

        gridLayout = findViewById(R.id.gridlayout_2);
        db=FirebaseFirestore.getInstance();
        final Context context=this;
        batch_id=getIntent().getExtras().getString("batch_id");
        header=getIntent().getExtras().getString("des");

        TextView headText=findViewById(R.id.header);
        headText.setText(String.format("Students of %s", header));

        final LoadingDialog loadingDialog=new LoadingDialog(StudentAdapter.this);
        loadingDialog.startLoadingDialog();

        //if(Connection.check(context))
        db.collection("students").document("info").
                collection(batch_id).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (DocumentSnapshot data: task.getResult()) {
                        Log.d("debug",data.getData().toString());
                        HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                        StudentCard studentCard = new StudentCard(context, tmp.get("name").toString(),
                                tmp.get("id").toString(), tmp.get("phone").toString(),
                                tmp.get("email").toString(), tmp.get("imageLink").toString());

                        gridLayout.addView(studentCard);
                        Log.d("debug",data.getData().toString());
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

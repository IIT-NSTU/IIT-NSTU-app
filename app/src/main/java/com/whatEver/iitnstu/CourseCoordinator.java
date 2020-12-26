package com.whatEver.iitnstu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class CourseCoordinator extends AppCompatActivity {

    private FirebaseFirestore db;
    private GridLayout gridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_coordinator);

        final LoadingDialog loadingDialog=new LoadingDialog(CourseCoordinator.this);
        loadingDialog.startLoadingDialog();

        gridLayout=findViewById(R.id.gridlayout_3);
        db=FirebaseFirestore.getInstance();
        final Context context=this;

        db.collection("course-co-ordinates").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    loadingDialog.dismissDialog();
                        for (QueryDocumentSnapshot data: task.getResult()) {
                            HashMap<String,Object> tmp=(HashMap<String, Object>) data.getData();

                            CourseCoCard courseCoCard = new CourseCoCard(context, tmp.get("name").toString(),
                                    tmp.get("designation").toString(),tmp.get("phone").toString(),
                                    tmp.get("email").toString(),tmp.get("info").toString(),tmp.get("imageLink").toString());

                            gridLayout.addView(courseCoCard);
                            //Log.d("debug",data.getData().toString());
                        }
                }
                else {
                    Toast.makeText(getApplicationContext(), "network error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

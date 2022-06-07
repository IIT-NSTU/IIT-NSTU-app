package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.whatEver.iitnstu.cards.TeacherCard;
import com.whatEver.iitnstu.models.Teacher;
import com.whatEver.iitnstu.tools.LoadingDialog;

import java.util.HashMap;

/**
 * Activity for Teachers Info.
 *
 */
public class TeachersInfoActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private GridLayout gridLayout;
    private Context context;
    private LoadingDialog loadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_info);

        gridLayout = findViewById(R.id.gridlayout_4);
        db = FirebaseFirestore.getInstance();
        context = this;
        loadingDialog = new LoadingDialog(TeachersInfoActivity.this);


        fetchingData();
    }


    /**
     * Fetch data from server.
     */
    private void fetchingData() {
        loadingDialog.startLoadingDialog();

        db.collection("teachers").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot data : task.getResult()) {
                    final HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();

                    Teacher teacher = new Teacher(tmp.get("name").toString(),
                            tmp.get("designation").toString(), tmp.get("phone").toString(),
                            tmp.get("email").toString(), tmp.get("imageLink").toString());

                    TeacherCard teacherCard = new TeacherCard(context, teacher);

                    /*teacherCard.setOnClickListener(v -> {
                        startActivity(new Intent(TeachersInfoActivity.this, ProfileActivity.class).putExtra("info", tmp));
                    });*/

                    gridLayout.addView(teacherCard);
                }
                loadingDialog.dismissDialog();
            } else {
                Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

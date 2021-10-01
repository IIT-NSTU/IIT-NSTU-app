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
import java.util.HashMap;


public class TeachersInfo extends AppCompatActivity {

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
        loadingDialog = new LoadingDialog(TeachersInfo.this);


        fetchingData();
    }


    private void fetchingData() {
        loadingDialog.startLoadingDialog();

        db.collection("teachers").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot data : task.getResult()) {
                    final HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                    TeacherCard teacherCard = new TeacherCard(context, tmp.get("name").toString(),
                            tmp.get("designation").toString(), tmp.get("phone").toString(),
                            tmp.get("email").toString(), tmp.get("imageLink").toString());

                    teacherCard.setOnClickListener(v -> {
                        startActivity(new Intent(TeachersInfo.this, Profile.class).putExtra("info", tmp));
                    });

                    gridLayout.addView(teacherCard);
                }
                loadingDialog.dismissDialog();
            } else {
                Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

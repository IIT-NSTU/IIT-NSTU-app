package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import java.util.HashMap;


public class CourseCoordinator extends AppCompatActivity {

    private FirebaseFirestore db;
    private GridLayout gridLayout;
    private Context context;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_coordinator);

        gridLayout=findViewById(R.id.gridlayout_3);
        db=FirebaseFirestore.getInstance();
        context=this;
        loadingDialog=new LoadingDialog(CourseCoordinator.this);

        fetchingData();
    }

    private void fetchingData() {
        loadingDialog.startLoadingDialog();

        db.collection("course-co-ordinates").get().addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                loadingDialog.dismissDialog();
                for (QueryDocumentSnapshot data: task.getResult()) {
                    HashMap<String,Object> tmp=(HashMap<String, Object>) data.getData();

                    CourseCoCard courseCoCard = new CourseCoCard(context, tmp.get("name").toString(),
                            tmp.get("designation").toString(),tmp.get("phone").toString(),
                            tmp.get("email").toString(),tmp.get("info").toString(),tmp.get("imageLink").toString());

                    gridLayout.addView(courseCoCard);
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

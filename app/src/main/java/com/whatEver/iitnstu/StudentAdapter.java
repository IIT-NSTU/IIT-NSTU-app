package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;


public class StudentAdapter extends AppCompatActivity {
    private FirebaseFirestore db;
    private GridLayout gridLayout;
    private String batch_id;
    private String header;
    private Context context;
    private TextView headText;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_batch_info);

        gridLayout = findViewById(R.id.gridlayout_2);
        db=FirebaseFirestore.getInstance();
        context=this;
        batch_id=getIntent().getExtras().getString("batch_id");
        header=getIntent().getExtras().getString("des");
        headText=findViewById(R.id.header);
        loadingDialog=new LoadingDialog(StudentAdapter.this);


        headText.setText(String.format("Students of %s", header));

        fetchingData();
    }


    private void fetchingData() {
        loadingDialog.startLoadingDialog();

        db.collection("students").document("info").
                collection(batch_id).get().addOnCompleteListener(task -> {
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
        });
    }
}

package com.example.iitnstu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class DirectorProfile extends AppCompatActivity {

    private ImageView image;
    private TextView name,designation,email,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_profile);

        final LoadingDialog loadingDialog=new LoadingDialog(DirectorProfile.this);
        loadingDialog.startLoadingDialog();

        image=findViewById(R.id.directorImage);
        name=findViewById(R.id.directorName);
        designation=findViewById(R.id.directorDesignation);
        email=findViewById(R.id.directorEmail);
        message=findViewById(R.id.directorMsg);

        FirebaseFirestore.getInstance().collection("director").document("0").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    loadingDialog.dismissDialog();
                    HashMap<String,Object> tmp=(HashMap<String,Object>)task.getResult().getData();
                    //Log.d("debug",tmp.get("message").toString());
                    name.setText(tmp.get("name").toString());
                    designation.setText(tmp.get("designation").toString());
                    email.setText(tmp.get("email").toString());
                    message.setText(tmp.get("message").toString().replaceAll("_n", "\n"));
                    Picasso.get().load(tmp.get("imageLink").toString()).into(image);
                }
                else {
                    Toast.makeText(getApplicationContext(), "network error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


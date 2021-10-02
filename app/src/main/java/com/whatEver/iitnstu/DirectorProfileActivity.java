package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;
import com.whatEver.iitnstu.tools.LoadingDialog;

import java.util.HashMap;


public class DirectorProfileActivity extends AppCompatActivity {

    //declaration
    private ImageView image;
    private TextView name;
    private TextView designation;
    private TextView email;
    private TextView message;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_director_profile);

        //initialization
        image = findViewById(R.id.directorImage);
        name = findViewById(R.id.directorName);
        designation = findViewById(R.id.directorDesignation);
        email = findViewById(R.id.directorEmail);
        message = findViewById(R.id.directorMsg);
        loadingDialog = new LoadingDialog(DirectorProfileActivity.this);

        fetchingData();
    }


    private void fetchingData() {
        loadingDialog.startLoadingDialog();

        FirebaseFirestore.getInstance().collection("director").document("0").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                loadingDialog.dismissDialog();
                HashMap<String, Object> tmp = (HashMap<String, Object>) task.getResult().getData();
                name.setText(tmp.get("name").toString());
                designation.setText(tmp.get("designation").toString());
                email.setText(tmp.get("email").toString());
                message.setText(tmp.get("message").toString().replaceAll("_n", "\n"));
                Picasso.get().load(tmp.get("imageLink").toString()).into(image);
            } else {
                Toast.makeText(getApplicationContext(), "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


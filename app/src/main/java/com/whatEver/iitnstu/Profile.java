package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;


public class Profile extends AppCompatActivity {

    private HashMap<String, Object> tmp;
    private ImageView profileImage;
    private TextView profileName,profileWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tmp=(HashMap)getIntent().getSerializableExtra("info");

        profileImage=findViewById(R.id.profile_img);
        profileName=findViewById(R.id.profile_name);
        profileWork=findViewById(R.id.profile_work);

        Picasso.get().load(tmp.get("imageLink").toString()).into(profileImage);
        profileName.setText(tmp.get("name").toString());
        profileWork.setText(tmp.get("designation").toString());


    }
}

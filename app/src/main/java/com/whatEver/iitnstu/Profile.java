package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;


public class Profile extends AppCompatActivity {

    private HashMap<String, Object> tmp;
    private ImageView profileImage;
    private TextView profileName,profileWork,educationInfo,educationInfo2;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tmp=(HashMap)getIntent().getSerializableExtra("info");
        HashMap<String,String> educationInfo=(HashMap) tmp.get("educationInfo");

        Log.d("debug",educationInfo.toString());

        profileImage=findViewById(R.id.profile_img);
        profileName=findViewById(R.id.profile_name);
        profileWork=findViewById(R.id.profile_work);
        linearLayout=findViewById(R.id.profile_edu_card);
        //educationInfo=findViewById(R.id.education_info);
        //educationInfo2=findViewById(R.id.education_info2);

        Picasso.get().load(tmp.get("imageLink").toString()).into(profileImage);
        profileName.setText(tmp.get("name").toString());
        profileWork.setText(tmp.get("designation").toString());
        //educationInfo.setText(tmp.get("educationInfo").toString());
        //educationInfo2.setText(tmp.get("educationInfo2").toString());

        for (String s : educationInfo.keySet()) {
            TextView textView=new TextView(getApplicationContext());
            textView.setText("\n"+s+" : "+educationInfo.get(s));
            linearLayout.addView(textView);
        }



    }
}

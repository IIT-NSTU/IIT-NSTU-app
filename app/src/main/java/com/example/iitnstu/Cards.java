package com.example.iitnstu;

import androidx.annotation.NonNull;


import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("ViewConstructor")
public class Cards extends FrameLayout {


    public Cards(@NonNull Context context,String name,String id,String phnNo,String email) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_cards, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

        ImageView studentPic=findViewById(R.id.studentPic);
        Context context1 = studentPic.getContext();
        int picId = context.getResources().getIdentifier(id.toLowerCase(), "drawable", context1.getPackageName());
        studentPic.setImageResource(picId);


        TextView studentName=findViewById(R.id.studentName);
        studentName.setText(name);

        TextView studentID=findViewById(R.id.studentID);
        studentID.setText(id);

        TextView studentPhnNo=findViewById(R.id.studentPhnNo);
        studentPhnNo.setText(phnNo);

        TextView studentEmail=findViewById(R.id.studentEmail);
        studentEmail.setText(email);
    }
}

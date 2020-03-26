package com.example.iitnstu;

import androidx.annotation.NonNull;


import android.content.Context;

import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class Cards extends FrameLayout {


    public Cards(@NonNull Context context,String name,String id) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_cards, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

        ImageView studentPic=findViewById(R.id.studentPic);
        Context context1 = studentPic.getContext();
        int picId = context.getResources().getIdentifier(id, "drawable", context1.getPackageName());
        studentPic.setImageResource(picId);


        TextView studentName=findViewById(R.id.studentName);
        studentName.setText(name);

        TextView studentID=findViewById(R.id.studentID);
        studentID.setText(id);
    }
}

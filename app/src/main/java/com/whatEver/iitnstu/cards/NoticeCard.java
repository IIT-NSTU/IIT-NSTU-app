package com.whatEver.iitnstu.cards;

import androidx.annotation.NonNull;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.whatEver.iitnstu.R;


@SuppressLint("ViewConstructor")
public class NoticeCard extends FrameLayout {

    public NoticeCard(@NonNull final Context context, String date, String about,String des) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_notice_card, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);



        TextView teacherName=findViewById(R.id.notice_date);
        teacherName.setText(date);

        TextView teacherDesignation=findViewById(R.id.notice_about);
        teacherDesignation.setText(about);

        TextView teacherPhnNo=findViewById(R.id.notice_des);
        teacherPhnNo.setText(des);


    }


}

package com.whatEver.iitnstu;

import androidx.annotation.NonNull;


import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


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

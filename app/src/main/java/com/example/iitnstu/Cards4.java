package com.example.iitnstu;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;


import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;


@SuppressLint("ViewConstructor")
public class Cards4 extends FrameLayout {

    public Cards4(@NonNull final Context context, String name, String designation, final String phnNo, String email, String imageLink) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_cards4, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);


        ImageView imageView=findViewById(R.id.teacherPic);
        Picasso.get().load(imageLink).into(imageView);


        TextView teacherName=findViewById(R.id.teacherName);
        teacherName.setText(name);

        TextView teacherDesignation=findViewById(R.id.teacherDesignation);
        teacherDesignation.setText(designation);

        TextView teacherPhnNo=findViewById(R.id.teacherPhnNo);
        teacherPhnNo.setText(phnNo);
        LinearLayout phn=findViewById(R.id.phnNo);
        phn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+phnNo));
                v.getContext().startActivity(intent);
            }
        });

        TextView teacherEmail=findViewById(R.id.teacherEmail);
        teacherEmail.setText(Html.fromHtml("<a href=\"mailto:"+email+"\">"+email+"</a>" ));
        teacherEmail.setMovementMethod(LinkMovementMethod.getInstance());

    }


}

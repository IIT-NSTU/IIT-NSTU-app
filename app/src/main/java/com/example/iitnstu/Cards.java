package com.example.iitnstu;

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
import android.widget.Toast;

@SuppressLint("ViewConstructor")
public class Cards extends FrameLayout {
    String phnNo;


    public Cards(@NonNull final Context context, String name, String id, final String phnNo, String email) {
        super(context);
        this.phnNo=phnNo;
        LayoutInflater.from(context).inflate(R.layout.activity_cards, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

        ImageView studentPic=findViewById(R.id.studentPic);
        final Context context1 = studentPic.getContext();
        int picId = context.getResources().getIdentifier(id.toLowerCase(), "drawable", context1.getPackageName());
        studentPic.setImageResource(picId);


        TextView studentName=findViewById(R.id.studentName);
        studentName.setText(name);

        TextView studentID=findViewById(R.id.studentID);
        studentID.setText(id);

        TextView studentPhnNo=findViewById(R.id.studentPhnNo);
        studentPhnNo.setText(phnNo);
        LinearLayout phn=findViewById(R.id.phnNo);
        phn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+phnNo));
                v.getContext().startActivity(intent);
            }
        });

        TextView studentEmail=findViewById(R.id.studentEmail);
        studentEmail.setText(Html.fromHtml("<a href=\"mailto:"+email+"\">"+email+"</a>" ));
        studentEmail.setMovementMethod(LinkMovementMethod.getInstance());
    }


}

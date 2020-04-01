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

@SuppressLint("ViewConstructor")
public class Cards3 extends FrameLayout {

    public Cards3(@NonNull final Context context, String name, String designation,final String phnNo, String email,String info) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_cards3, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

        ImageView courseCoordinatorPic=findViewById(R.id.cc_image);
        final Context context1 = courseCoordinatorPic.getContext();
        int picId = context.getResources().getIdentifier(info.toLowerCase(), "drawable", context1.getPackageName());
        courseCoordinatorPic.setImageResource(picId);

        TextView courseCoordinatorName=findViewById(R.id.cc_name);
        courseCoordinatorName.setText(name);

        TextView courseCoordinatorDesignation=findViewById(R.id.cc_designation);
        courseCoordinatorDesignation.setText(designation);

        TextView courseCoordinatorPhnNo=findViewById(R.id.cc_phnNo);
        courseCoordinatorPhnNo.setText(phnNo);
        LinearLayout phn=findViewById(R.id.phnNo);
        phn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+phnNo));
                v.getContext().startActivity(intent);
            }
        });

        TextView courseCoordinatorEmail=findViewById(R.id.cc_email);
        courseCoordinatorEmail.setText(Html.fromHtml("<a href=\"mailto:"+email+"\">"+email+"</a>" ));
        courseCoordinatorEmail.setMovementMethod(LinkMovementMethod.getInstance());

        TextView courseCoordinatorInfo = findViewById(R.id.cc_info);
        courseCoordinatorInfo.setText(info);
    }
}

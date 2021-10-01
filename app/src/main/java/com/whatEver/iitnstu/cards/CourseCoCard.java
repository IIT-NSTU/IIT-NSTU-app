package com.whatEver.iitnstu.cards;

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
import com.whatEver.iitnstu.R;

@SuppressLint("ViewConstructor")
public class CourseCoCard extends FrameLayout {

    public CourseCoCard(@NonNull final Context context, String name, String designation, final String phnNo, String email, String info, String imageLink) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_course_co_card, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

        ImageView imageView=findViewById(R.id.cc_image);
        Picasso.get().load(imageLink).into(imageView);


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

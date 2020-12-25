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

import com.squareup.picasso.Picasso;

@SuppressLint("ViewConstructor")
public class OfficialsCard extends FrameLayout {

    public OfficialsCard(@NonNull final Context context, String name, String contactInfo, final String phnNo, String email, String imageLink) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.activity_officials_card, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

        ImageView imageView=findViewById(R.id.staffPic);
        Picasso.get().load(imageLink).into(imageView);


        TextView staffName=findViewById(R.id.staffName);
        staffName.setText(name);

        TextView staffContactAddress=findViewById(R.id.staffContactInfo);
        staffContactAddress.setText(contactInfo);

        TextView staffPhnNo=findViewById(R.id.staffPhnNo);
        staffPhnNo.setText(phnNo);
        LinearLayout phn=findViewById(R.id.phnNo);
        phn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: "+phnNo));
                v.getContext().startActivity(intent);
            }
        });

        TextView staffEmail=findViewById(R.id.staffEmail);
        staffEmail.setText(Html.fromHtml("<a href=\"mailto:"+email+"\">"+email+"</a>" ));
        staffEmail.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

package com.whatEver.iitnstu.cards;


import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.whatEver.iitnstu.R;
import com.whatEver.iitnstu.models.Student;


public class StudentCard extends Card {

    private Context context;
    private Student student;
    private ImageView imageView;
    private TextView studentName;
    private TextView studentID;
    private TextView studentPhnNo;
    private TextView studentEmail;
    private LinearLayout phn;


    public StudentCard(Context context) {
        super(context);
        this.context = context;
    }


    public StudentCard(Context context, Student student) {
        this(context);
        this.student = student;

        LayoutInflater.from(context).inflate(R.layout.activity_cards, this, true);

        Animation animation = AnimationUtils.loadAnimation(context, R.anim.fromdown);
        CardView cardView = findViewById(R.id.education_info);
        cardView.startAnimation(animation);

        imageView = findViewById(R.id.studentPic);
        studentName = findViewById(R.id.studentName);
        studentID = findViewById(R.id.studentID);
        studentPhnNo = findViewById(R.id.studentPhnNo);
        phn = findViewById(R.id.cc_layout);
        studentEmail = findViewById(R.id.studentEmail);

        setData();
    }


    @Override
    public void setData() {
        studentName.setText(student.getName());
        studentID.setText(student.getId());
        studentPhnNo.setText(student.getPhone());

        studentEmail.setText(Html.fromHtml("<a href=\"mailto:" + student.getEmail() + "\">" + student.getEmail() + "</a>"));
        studentEmail.setMovementMethod(LinkMovementMethod.getInstance());
        Picasso.get().load(student.getImageLink()).into(imageView);

        phn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel: " + student.getPhone()));
            v.getContext().startActivity(intent);
        });
    }
}

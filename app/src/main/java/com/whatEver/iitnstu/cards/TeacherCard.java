package com.whatEver.iitnstu.cards;


import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.whatEver.iitnstu.R;
import com.whatEver.iitnstu.models.Teacher;

/**
 * This TeacherCard class is used to display a Teacher object in a form of card.
 *
 * A child class of Card.
 */
public class TeacherCard extends Card {

    private Context context;
    private Teacher teacher;
    private ImageView imageView;
    private TextView teacherName;
    private TextView teacherDesignation;
    private TextView teacherPhnNo;
    private TextView teacherEmail;
    private LinearLayout phn;


    /**
     * Default constructor.
     *
     * @param context: from the activity the card is invoked.
     */
    public TeacherCard(Context context) {
        super(context);
        this.context = context;
    }


    /**
     * Another constructor which will take a specific Teacher object
     * to display it in a form of card.
     *
     * @param context: from the activity the card is invoked.
     * @param teacher: The Teacher object which it will display.
     */
    public TeacherCard(Context context, Teacher teacher) {
        this(context);
        this.teacher = teacher;

        LayoutInflater.from(context).inflate(R.layout.activity_techer_card, this, true);


        imageView = findViewById(R.id.teacherPic);
        teacherName = findViewById(R.id.teacherName);
        teacherDesignation = findViewById(R.id.teacherDesignation);
        teacherPhnNo = findViewById(R.id.teacherPhnNo);
        phn = findViewById(R.id.cc_layout);
        teacherEmail = findViewById(R.id.teacherEmail);

        setData();
    }

    @Override
    public void setData() {
        teacherName.setText(teacher.getName());
        teacherDesignation.setText(teacher.getDesignation());

        teacherPhnNo.setText(teacher.getPhnNo());
        teacherEmail.setText(Html.fromHtml("<a href=\"mailto:" + teacher.getEmail() + "\">" + teacher.getEmail() + "</a>"));
        teacherEmail.setMovementMethod(LinkMovementMethod.getInstance());
        Picasso.get().load(teacher.getImageLink()).into(imageView);

        phn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel: " + teacher.getPhnNo()));
            v.getContext().startActivity(intent);
        });
    }

}

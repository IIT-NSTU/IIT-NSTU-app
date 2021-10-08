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
import com.whatEver.iitnstu.models.CourseCo;


/**
 * This CourseCoCard class is used to display a CourseCo object in a form of card.
 *
 * A child class of Card.
 */
public class CourseCoCard extends Card {

    private CourseCo courseCo;
    private Context context;
    private ImageView imageView;
    private TextView courseCoordinatorName;
    private TextView courseCoordinatorDesignation;
    private TextView courseCoordinatorPhnNo;
    private TextView courseCoordinatorEmail;
    private TextView courseCoordinatorInfo;
    private LinearLayout layout;

    /**
     * Default constructor.
     *
     * @param context: from the activity the card is invoked.
     */
    public CourseCoCard(Context context) {
        super(context);
        this.context = context;
    }


    /**
     * Another constructor which will take a specific CourseCo object
     * to display it in a form of card.
     *
     * @param context: from the activity the card is invoked.
     * @param courseCo: The CourseCo object which it will display.
     */
    public CourseCoCard(Context context, CourseCo courseCo) {
        this(context);
        this.courseCo = courseCo;

        LayoutInflater.from(context).inflate(R.layout.activity_course_co_card, this, true);

        imageView = findViewById(R.id.cc_image);
        courseCoordinatorName = findViewById(R.id.cc_name);
        courseCoordinatorDesignation = findViewById(R.id.cc_designation);
        courseCoordinatorPhnNo = findViewById(R.id.cc_phnNo);
        layout = findViewById(R.id.cc_layout);
        courseCoordinatorEmail = findViewById(R.id.cc_email);
        courseCoordinatorInfo = findViewById(R.id.cc_info);

        setData();
    }

    @Override
    public void setData() {
        courseCoordinatorName.setText(courseCo.getName());
        courseCoordinatorDesignation.setText(courseCo.getDesignation());
        courseCoordinatorPhnNo.setText(courseCo.getPhnNo());

        courseCoordinatorEmail.setText(Html.fromHtml("<a href=\"mailto:" + courseCo.getEmail() + "\">" + courseCo.getEmail() + "</a>"));
        courseCoordinatorEmail.setMovementMethod(LinkMovementMethod.getInstance());
        courseCoordinatorInfo.setText(courseCo.getInfo());
        Picasso.get().load(courseCo.getImageLink()).into(imageView);

        layout.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel: " + courseCo.getPhnNo()));
            v.getContext().startActivity(intent);
        });
    }
}

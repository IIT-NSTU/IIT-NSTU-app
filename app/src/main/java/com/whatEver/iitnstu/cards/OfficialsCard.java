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
import com.whatEver.iitnstu.models.Officials;


public class OfficialsCard extends Card {

    private Context context;
    private Officials officials;
    private ImageView imageView;
    private TextView staffName;
    private TextView staffContactAddress;
    private TextView staffPhnNo;
    private TextView staffEmail;
    private LinearLayout layout;


    public OfficialsCard(Context context) {
        super(context);
        this.context = context;
    }


    public OfficialsCard(Context context, Officials officials) {
        this(context);
        this.officials = officials;

        LayoutInflater.from(context).inflate(R.layout.activity_officials_card, this, true);


        imageView = findViewById(R.id.staffPic);
        staffName = findViewById(R.id.staffName);
        staffContactAddress = findViewById(R.id.staffContactInfo);
        staffPhnNo = findViewById(R.id.staffPhnNo);
        staffEmail = findViewById(R.id.staffEmail);
        layout = findViewById(R.id.official_layout);

        setData();
    }

    @Override
    public void setData() {
        staffName.setText(officials.getName());
        staffContactAddress.setText(officials.getContactInfo());

        staffEmail.setText(Html.fromHtml("<a href=\"mailto:" + officials.getEmail() + "\">" + officials.getEmail() + "</a>"));
        staffEmail.setMovementMethod(LinkMovementMethod.getInstance());
        Picasso.get().load(officials.getImageLink()).into(imageView);

        staffPhnNo.setText(officials.getPhnNo());

        layout.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel: " + officials.getPhnNo()));
            v.getContext().startActivity(intent);
        });
    }
}

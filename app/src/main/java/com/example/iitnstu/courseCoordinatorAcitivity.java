package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;


public class courseCoordinatorAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_coordinator_acitivity);


        TextView email = (TextView) findViewById(R.id.TextViewEmailDipa);
        email.setText(Html.fromHtml("<a href=\"mailto:dipa.iit.nstu@gmail.com\">dipa.iit.nstu@gmail.com</a>" ));
        email.setMovementMethod(LinkMovementMethod.getInstance());

        TextView email2 = (TextView) findViewById(R.id.TextViewEmailSumon);
        email2.setText(Html.fromHtml("<a href=\"mailto:auhidsumon@gmail.com\">auhidsumon@gmail.com</a>" ));
        email2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView email3 = (TextView) findViewById(R.id.TextViewEmailFalguni);
        email3.setText(Html.fromHtml("<a href=\"mailto:falguni.iit@gmail.com\">falguni.iit@gmail.com</a>" ));
        email3.setMovementMethod(LinkMovementMethod.getInstance());

    }
}

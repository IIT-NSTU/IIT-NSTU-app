package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class developers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        TextView email = (TextView) findViewById(R.id.TextViewEmail);
        email.setText(Html.fromHtml("<a href=\"mailto:arnabdey665@gmail.com\">arnabdey665@gmail.com</a>" ));
        email.setMovementMethod(LinkMovementMethod.getInstance());

        TextView email2 = (TextView) findViewById(R.id.TextViewEmail2);
        email2.setText(Html.fromHtml("<a href=\"mailto:nirzon.naim@gmail.com\">nirzon.naim@gmail.com</a>" ));
        email2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView email3 = (TextView) findViewById(R.id.TextViewEmail3);
        email3.setText(Html.fromHtml("<a href=\"mailto:sunaansultaniit@gmail.com\">sunaansultaniit@gmail.com</a>" ));
        email3.setMovementMethod(LinkMovementMethod.getInstance());


    }

    public void startCallArnab(View view){
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: 01725017282"));
        startActivity(intent);
    }

    public void startCallNayeem(View view){
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: 01724595168"));
        startActivity(intent);
    }

    public void startCallSunaan(View view){
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: 01766554344"));
        startActivity(intent);
    }

    public void startFbArnab(View view){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.facebook.com/arnab.dey.5030"));
        startActivity(intent);
    }

    public void startFbNayeem(View view){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.facebook.com/nirzon.nayeem"));
        startActivity(intent);
    }

    public void startFbSunaan(View view){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.facebook.com/sunaan.sultan.3"));
        startActivity(intent);
    }
}

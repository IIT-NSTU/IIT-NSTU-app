package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Developers extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        textView = (TextView) findViewById(R.id.textView6);
        textView.setText(R.string.developers_say_2);
    }
}

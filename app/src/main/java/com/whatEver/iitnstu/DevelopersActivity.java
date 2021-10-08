package com.whatEver.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Activity for Developers.
 *
 */
public class DevelopersActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        textView = (TextView) findViewById(R.id.textView6);
        textView.setText(R.string.developers_say_2);

    }
}

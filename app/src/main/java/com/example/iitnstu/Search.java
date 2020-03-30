package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search extends AppCompatActivity {

    InputStream inputStreamName, inputStreamId, inputStreamPhnNo, inputStreamEmail;
    Scanner inName, inId, inPhnNo, inEmail;
    Context context = this;
    GridLayout gridLayout;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        gridLayout = findViewById(R.id.gridlayout1);
        TextView inputText = findViewById(R.id.input);

            inputText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    input = s.toString();
                    for (int i = 0; i <gridLayout.getChildCount() ; i++) {
                        Animation animation = AnimationUtils.loadAnimation(context, R.anim.goright);
                        gridLayout.getChildAt(i).startAnimation(animation);

                    }
                    gridLayout.removeAllViews();
                }

                @Override
                public void afterTextChanged(Editable s) {
                    Toast.makeText(context, input, Toast.LENGTH_SHORT).show();


                    try {
                        inputStreamId = getAssets().open("ID_database_second.txt");
                        inId = new Scanner(inputStreamId);

                        inputStreamName = getAssets().open("Name_database_second.txt");
                        inName = new Scanner(inputStreamName);

                        inputStreamPhnNo = getAssets().open("phn_no_second.txt");
                        inPhnNo = new Scanner(inputStreamPhnNo);

                        inputStreamEmail = getAssets().open("email_second.txt");
                        inEmail = new Scanner(inputStreamEmail);

                        String name = "", id = "", phnNo = "", email = "";
                        while (inId.hasNext()) {


                            name = inName.nextLine();


                            id = inId.next();
                            phnNo = inPhnNo.next();
                            email = inEmail.next();
                            input=input.toLowerCase();

                            Pattern pattern = Pattern.compile(input);
                            Matcher matcher = pattern.matcher(name.toLowerCase());



                                if (matcher.find() || input.equals(id.toLowerCase()) || input.equals(email) || input.equals(phnNo)) {

                                    Cards cards = new Cards(context, name, id, phnNo, email);
                                    gridLayout.addView(cards);


                            }




                        }
                    } catch (IOException e) {
                        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    } finally {
                        try {
                            inputStreamName.close();
                            inputStreamId.close();
                            inputStreamPhnNo.close();
                            inputStreamEmail.close();

                            inName.close();
                            inId.close();
                            inPhnNo.close();
                            inEmail.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (input.equals("")){
                        for (int i = 0; i <gridLayout.getChildCount() ; i++) {
                            Animation animation = AnimationUtils.loadAnimation(context, R.anim.goright);
                            gridLayout.getChildAt(i).startAnimation(animation);

                        }
                        gridLayout.removeAllViews();
                    }
                }
            });



    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
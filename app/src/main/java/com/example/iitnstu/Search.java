package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

    InputStream inputStream;
    Scanner in;
    Context context = this;
    GridLayout gridLayout;
    String input;
    TextView inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        gridLayout = findViewById(R.id.gridlayout1);
        inputText = findViewById(R.id.input);


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

            }
        });
        thread.start();
        inputText.setFocusableInTouchMode(true);
        inputText.requestFocus();


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


                    try {
                        inputStream = openFileInput("infoForSearch.txt");
                        in = new Scanner(inputStream);

                        //URL fileURL = new URL("https://drive.google.com/uc?export=download&id=1GnGleaKtLnOqK6y1TfF5H5BO2d7n0GVi");
                         //in = new Scanner(fileURL.openStream());

                        String name = "", id = "", phnNo = "", email = "";
                        String[] inputs;
                        if(input.length()!=1)
                            while (in.hasNextLine()) {

                                inputs= in.nextLine().split("[\\s]*[|][\\s]*");
                                id=inputs[0];
                                name=inputs[1];
                                phnNo=inputs[2];
                                email=inputs[3];

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
                            inputStream.close();



                            in.close();

                        } catch (Exception e) {
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
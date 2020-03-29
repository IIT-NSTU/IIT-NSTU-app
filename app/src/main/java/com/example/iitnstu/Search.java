package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

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
                }

                @Override
                public void afterTextChanged(Editable s) {

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
                            String[] names;
                            names=name.toLowerCase().split("\\s");

                            id = inId.next();
                            phnNo = inPhnNo.next();
                            email = inEmail.next();
                            input=input.toLowerCase();
                            if (names.length==1){
                                if (input.equals(names[0]) || input.equals(id) || input.equals(email) || input.equals(phnNo)) {

                                    Cards cards = new Cards(context, name, id, phnNo, email);
                                    gridLayout.addView(cards);

                                    break;

                                }else {
                                    Toast.makeText(context, input, Toast.LENGTH_SHORT).show();
                                    for (int i = 0; i < gridLayout.getChildCount(); i++) {
                                        gridLayout.removeViewAt(i);
                                    }

                                }
                            }

                            else if (names.length==2){

                                if (input.equals(names[0]) || input.equals(names[1]) ||input.equals(id) || input.equals(email) || input.equals(phnNo)) {

                                    Cards cards = new Cards(context, name, id, phnNo, email);
                                    gridLayout.addView(cards);
                                    break;

                                }else {
                                    Toast.makeText(context, input, Toast.LENGTH_SHORT).show();
                                    for (int i = 0; i < gridLayout.getChildCount(); i++) {
                                        gridLayout.removeViewAt(i);
                                    }

                                }
                            }

                            else if (names.length==3){

                                if (input.equals(names[0]) || input.equals(names[1]) || input.equals(names[2]) || input.equals(id) || input.equals(email) || input.equals(phnNo)) {

                                    Cards cards = new Cards(context, name, id, phnNo, email);
                                    gridLayout.addView(cards);
                                    break;

                                }else {
                                    Toast.makeText(context, input, Toast.LENGTH_SHORT).show();
                                    for (int i = 0; i < gridLayout.getChildCount(); i++) {
                                        gridLayout.removeViewAt(i);
                                    }

                                }
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
                }
            });



    }
}
package com.whatEver.iitnstu;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search extends AppCompatActivity {
    private FirebaseFirestore db;
    private Context context = this;
    private GridLayout gridLayout;
    private String input;
    private ArrayList<Student> students;
    protected TextView inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        students=new ArrayList<>();
        db=FirebaseFirestore.getInstance();
        gridLayout = findViewById(R.id.gridlayout1);
        inputText = findViewById(R.id.input);

        Thread thread = new Thread(new Runnable() {
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

        //fetching data
        db.collection("students").document("all-Students").
                collection("by_id").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot data : task.getResult()) {
                        Log.d("debug", data.getData().toString());
                        HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                        /*StudentCard studentCard = new StudentCard(context, tmp.get("name").toString(),
                                tmp.get("id").toString(), tmp.get("phone").toString(),
                                tmp.get("email").toString(), tmp.get("imageLink").toString());
                        gridLayout.addView(studentCard);*/
                        Student student = new Student(tmp.get("name").toString(),
                                tmp.get("id").toString(), tmp.get("phone").toString(),
                                tmp.get("email").toString(), tmp.get("imageLink").toString());

                        students.add(student);

                        Log.d("debug", data.getData().toString()+students.size());
                    }
                } else {
                    Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input = s.toString();
                for (int i = 0; i < gridLayout.getChildCount(); i++) {
                    Animation animation = AnimationUtils.loadAnimation(context, R.anim.goright);
                    gridLayout.getChildAt(i).startAnimation(animation);

                }
                gridLayout.removeAllViews();
            }

            @Override
            public void afterTextChanged(Editable s) {
                String name = "", id = "", phnNo = "", email = "";
                if (input.length() != 1)
                    for (Student student : students) {
                        id = student.getId();
                        name = student.getName();
                        phnNo = student.getPhone();
                        email = student.getEmail();

                        input = input.toLowerCase();
                        Pattern pattern = Pattern.compile(input);
                        Matcher matcher = pattern.matcher(name.toLowerCase());
                        if (matcher.find() || input.equals(id.toLowerCase()) || input.equals(email) || input.equals(phnNo)) {
                                /*Cards cards = new Cards(context, name, id, phnNo, email);
                                gridLayout.addView(cards);*/
                            StudentCard studentCard = new StudentCard(context, name,
                                    id, phnNo, email, student.getImageLink());
                            gridLayout.addView(studentCard);
                        }
                    }
                if (input.equals("")) {
                    for (int i = 0; i < gridLayout.getChildCount(); i++) {
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

class Student {
    private String name;
    private String id;
    private String phone;
    private String email;
    private String imageLink;

    public Student(String name, String id, String phone, String email, String imageLink) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getImageLink() {
        return imageLink;
    }
}
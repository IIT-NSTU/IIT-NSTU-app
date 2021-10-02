package com.whatEver.iitnstu;


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

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.whatEver.iitnstu.cards.StudentCard;
import com.whatEver.iitnstu.models.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SearchActivity extends AppCompatActivity {

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

        students = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        gridLayout = findViewById(R.id.gridlayout1);
        inputText = findViewById(R.id.input);


        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        });

        thread.start();
        inputText.setFocusableInTouchMode(true);
        inputText.requestFocus();

        //fetching data
        fetchingData();


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

                            StudentCard studentCard = new StudentCard(context, student);
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

    private void fetchingData() {
        db.collection("students").document("all-Students").
                collection("by_id").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot data : task.getResult()) {
                    Log.d("debug", data.getData().toString());
                    HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                    Student student = new Student(tmp.get("name").toString(),
                            tmp.get("id").toString(), tmp.get("phone").toString(),
                            tmp.get("email").toString(), tmp.get("imageLink").toString());

                    students.add(student);

                    Log.d("debug", data.getData().toString() + students.size());
                }
            } else {
                Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
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


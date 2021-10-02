package com.whatEver.iitnstu;


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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.whatEver.iitnstu.cards.OfficialsCard;
import com.whatEver.iitnstu.cards.StudentCard;
import com.whatEver.iitnstu.cards.TeacherCard;
import com.whatEver.iitnstu.models.Official;
import com.whatEver.iitnstu.models.Student;
import com.whatEver.iitnstu.models.Teacher;
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
    private ArrayList<Teacher> teachers;
    private ArrayList<Official> officials;
    protected TextView inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        students = new ArrayList<>();
        teachers=new ArrayList<>();
        officials=new ArrayList<>();
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
        fetchingStudentData();
        fetchingTeacherData();
        fetchingOfficialData();

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
                if (input.length() != 1) {
                    searchTeacher();
                    searchOfficial();
                    searchStudent();
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

    private void searchOfficial() {
        for (Official official : officials) {
            String name = official.getName();
            String phnNo = official.getPhnNo();
            String email = official.getEmail();

            input = input.toLowerCase();
            Pattern pattern = Pattern.compile(input);
            Matcher matcher = pattern.matcher(name.toLowerCase());
            if (matcher.find() || input.equals(email) || input.equals(phnNo)) {

                OfficialsCard officialsCard=new OfficialsCard(context,official);
                gridLayout.addView(officialsCard);
            }
        }
    }

    private void searchStudent() {
        for (Student student : students) {
            String id = student.getId();
            String name = student.getName();
            String phnNo = student.getPhone();
            String email = student.getEmail();

            input = input.toLowerCase();
            Pattern pattern = Pattern.compile(input);
            Matcher matcher = pattern.matcher(name.toLowerCase());
            if (matcher.find() || input.equals(id.toLowerCase()) || input.equals(email) || input.equals(phnNo)) {

                StudentCard studentCard = new StudentCard(context, student);
                gridLayout.addView(studentCard);
            }
        }
    }

    private void searchTeacher() {
        for (Teacher teacher : teachers) {
            String name = teacher.getName();
            String phnNo = teacher.getPhnNo();
            String email = teacher.getEmail();

            input = input.toLowerCase();
            Pattern pattern = Pattern.compile(input);
            Matcher matcher = pattern.matcher(name.toLowerCase());
            if (matcher.find() || input.equals(email) || input.equals(phnNo)) {

                TeacherCard teacherCard=new TeacherCard(context,teacher);
                gridLayout.addView(teacherCard);
            }
        }
    }

    private void fetchingStudentData() {
        db.collection("students").document("all-Students").
                collection("by_id").get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult()!=null) {
                for (DocumentSnapshot data : task.getResult()) {
                    HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                    Student student = new Student(tmp.get("name").toString(),
                            tmp.get("id").toString(), tmp.get("phone").toString(),
                            tmp.get("email").toString(), tmp.get("imageLink").toString());
                    students.add(student);
                }
            } else {
                Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchingTeacherData() {
        db.collection("teachers").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot data : task.getResult()) {
                    HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                    Teacher teacher = new Teacher(tmp.get("name").toString(),
                            tmp.get("designation").toString(), tmp.get("phone").toString(),
                            tmp.get("email").toString(), tmp.get("imageLink").toString());
                    teachers.add(teacher);
                }
            } else {
                Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchingOfficialData() {
        db.collection("officials").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot data : task.getResult()) {
                    HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                    Official official = new Official(tmp.get("name").toString(),
                            tmp.get("contactInfo").toString(), tmp.get("phone").toString(),
                            tmp.get("email").toString(), tmp.get("imageLink").toString());
                    officials.add(official);
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


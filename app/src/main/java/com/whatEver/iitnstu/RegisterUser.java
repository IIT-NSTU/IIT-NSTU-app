package com.whatEver.iitnstu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RegisterUser extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton teacher,official,student;
    private EditText email,password,password1,name,phone,Id;
    private Button register;
    private FirebaseFirestore db;
    private int tmp=-1;
    private CollectionReference ref;
    private FirebaseAuth auth;
    private TextView goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        radioGroup=findViewById(R.id.radiogrp);
        teacher=findViewById(R.id.radioTeacher);
        official=findViewById(R.id.radioOfficial);
        student=findViewById(R.id.radioStudent);
        email=findViewById(R.id.resEmail);
        password=findViewById(R.id.resPass);
        password1=findViewById(R.id.resConfirmPass);
        name=findViewById(R.id.resName);
        phone=findViewById(R.id.resPhone);
        Id=findViewById(R.id.resID);
        register=findViewById(R.id.resbutton);
        goBack=findViewById(R.id.go_back);
        db=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();

        student.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tmp=3;
                    Log.e("debug",String.valueOf(tmp));
                    Id.setVisibility(View.VISIBLE);
                }
            }
        });
        teacher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tmp=1;
                    Log.e("debug",String.valueOf(tmp));
                    Id.setVisibility(View.GONE);
                }
            }
        });
        official.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tmp=2;
                    Log.e("debug",String.valueOf(tmp));
                    Id.setVisibility(View.GONE);
                }
            }
        });

        Log.e("debug",String.valueOf(tmp));
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDb();
                String txt_email=email.getText().toString();
                String txt_password=password.getText().toString();
                String txt_password1=password1.getText().toString();
                String txt_name=name.getText().toString();
                String txt_phn=phone.getText().toString();
                String txt_id=Id.getText().toString();


                Log.e("debug",txt_email);
                Log.e("debug",txt_password);
                Log.e("debug",txt_name);
                Log.e("debug",txt_password1);
                Log.e("debug",txt_phn);
                Log.e("debug",txt_id);
                if(tmp==-1){
                    Toast.makeText(RegisterUser.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                }
                else if(tmp==3 && TextUtils.isEmpty(txt_id)){
                    Toast.makeText(RegisterUser.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_password1) || TextUtils.isEmpty(txt_name)
                        || TextUtils.isEmpty(txt_phn) /*|| (password!=password1)*/){
                    Toast.makeText(RegisterUser.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                }
                else if(!txt_password.equals(txt_password1)){
                    Toast.makeText(RegisterUser.this, "Password not matched!", Toast.LENGTH_SHORT).show();
                }
                else if(txt_password.length()<6){
                    Toast.makeText(RegisterUser.this, "Password is too short!", Toast.LENGTH_SHORT).show();
                }
                else{

                    registerUser(txt_email,txt_password,txt_name,txt_phn,txt_id);
                }
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterUser.this,Authentication.class));
                finish();
            }
        });

    }
    private void setDb(){
        if(tmp==1)ref=db.collection("teachers");
        else if(tmp==2)ref=db.collection("officials");
        else {
            ref=db.collection("students").document("all-Students").collection("by_id");
        }
    }

    private void registerUser(final String Uemail, final String Upassword, final String Uname, final String Uphone, final String Uid) {
        ref.whereEqualTo("email", Uemail)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                boolean ok=true;
                                if(!Uname.toLowerCase().equals(document.get("name").toString().toLowerCase()))ok=false;
                                if(!Uphone.toLowerCase().equals(document.get("phone").toString().toLowerCase()))ok=false;
                                if(tmp==3){
                                    if(!Uid.toLowerCase().equals(document.get("id").toString().toLowerCase()))ok=false;
                                }
                                if(ok)register(Uemail,Upassword);

                                Log.d("debug", String.valueOf(ok));
                                Log.d("debug", document.getId() + " => " + document.getData());
                                startActivity(new Intent(RegisterUser.this,Authentication.class));
                                finish();
                            }
                        } else {
                            startActivity(new Intent(RegisterUser.this,Authentication.class));
                            finish();
                            Log.d("debug", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }

    private void register(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterUser.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterUser.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterUser.this, "registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

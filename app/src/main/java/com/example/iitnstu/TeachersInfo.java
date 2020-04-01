package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TeachersInfo extends AppCompatActivity {

    InputStream inputStreamName,inputStreamDesignation,inputStreamPhnNo,inputStreamEmail,inputStreamDiscoverMore;
    Scanner inName,inDesignation,inPhnNo,inEmail,inDiscoverMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers_info2);

        GridLayout gridLayout = findViewById(R.id.gridlayout_4);

        try {
            inputStreamName=getAssets().open("teacher-name.txt");
            inName=new Scanner(inputStreamName);

            inputStreamDesignation=getAssets().open("teacher-designation.txt");
            inDesignation=new Scanner(inputStreamDesignation);

            inputStreamPhnNo=getAssets().open("teacher-number.txt");
            inPhnNo=new Scanner(inputStreamPhnNo);

            inputStreamEmail=getAssets().open("teacher-email.txt");
            inEmail=new Scanner(inputStreamEmail);

            inputStreamDiscoverMore=getAssets().open("discover-more.txt");
            inDiscoverMore=new Scanner(inputStreamDiscoverMore);

            String name="",designation="",phnNo="",email="",discoverMore="";
            while (inDesignation.hasNext()) {
                name = inName.nextLine();
                designation = inDesignation.next();
                phnNo=inPhnNo.next();
                email=inEmail.next();

                Cards4 cards4 = new Cards4(this, name,designation,phnNo,email,discoverMore);
                gridLayout.addView(cards4);

            }
        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }finally {
            try {
                inputStreamName.close();
                inputStreamDesignation.close();
                inputStreamPhnNo.close();
                inputStreamEmail.close();
                inputStreamDiscoverMore.close();

                inName.close();
                inDesignation.close();
                inPhnNo.close();
                inEmail.close();
                inDiscoverMore.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

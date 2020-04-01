package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class CourseCoordinator extends AppCompatActivity {

    InputStream inputStreamName,inputStreamDesignation,inputStreamPhnNo,inputStreamEmail,inputStreamInfo;
    Scanner inName,inDesignation,inPhnNo,inEmail,inInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_coordinator);

        GridLayout gridLayout=findViewById(R.id.gridlayout_3);

        try {

            inputStreamName=getAssets().open("name_course_coordinator.txt");
            inName=new Scanner(inputStreamName);

            inputStreamDesignation=getAssets().open("designation_course_coordinator.txt");
            inDesignation=new Scanner(inputStreamDesignation);

            inputStreamPhnNo=getAssets().open("course_coordinator_phnNo.txt");
            inPhnNo=new Scanner(inputStreamPhnNo);

            inputStreamEmail=getAssets().open("email_course_coordinator.txt");
            inEmail=new Scanner(inputStreamEmail);

            inputStreamInfo=getAssets().open("course_coordinator_info.txt");
            inInfo=new Scanner(inputStreamInfo);

            String name="",designation="",phnNo="",email="",info="";
            while (inName.hasNextLine()) {
                name = inName.nextLine();
                designation=inDesignation.nextLine();
                phnNo = inPhnNo.next();
                email=inEmail.next();
                info = inInfo.nextLine();

                Cards3 cards3 = new Cards3(this, name,designation,phnNo,email,info);
                gridLayout.addView(cards3);

            }
        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }finally {
            try {
                inputStreamName.close();
                inDesignation.close();
                inputStreamPhnNo.close();
                inputStreamEmail.close();
                inputStreamInfo.close();

                inName.close();
                inDesignation.close();
                inputStreamPhnNo.close();
                inEmail.close();
                inInfo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

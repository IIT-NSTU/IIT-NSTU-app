package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Officials extends AppCompatActivity {

    InputStream inputStreamName,inputStreamContactInfo,inputStreamPhnNo,inputStreamEmail;
    Scanner inName,inContactInfo,inPhnNo,inEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officials);

        GridLayout gridLayout=findViewById(R.id.gridlayout_2);

        try {
            inputStreamName=getAssets().open("Official_names.txt");
            inName=new Scanner(inputStreamName);

            inputStreamContactInfo=getAssets().open("Staff_contact_address.txt");
            inContactInfo=new Scanner(inputStreamContactInfo);

            inputStreamEmail=getAssets().open("Staff_email.txt");
            inEmail=new Scanner(inputStreamEmail);

            String name="",contactInfo="",phnNo="",email="";
            while (inEmail.hasNext()) {
                name = inName.nextLine();
                contactInfo = inContactInfo.nextLine();
                phnNo=inPhnNo.next();
                email=inEmail.next();

                Cards2 cards2 = new Cards2(this, name,contactInfo,phnNo,email);
                gridLayout.addView(cards2);

            }
        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }finally {
            try {
                inputStreamName.close();
                inputStreamContactInfo.close();
                inputStreamPhnNo.close();
                inputStreamEmail.close();

                inName.close();
                inContactInfo.close();
                inPhnNo.close();
                inEmail.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

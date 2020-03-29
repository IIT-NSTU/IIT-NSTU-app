package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class SecondBatchInfo extends AppCompatActivity {

    InputStream inputStreamName,inputStreamId,inputStreamPhnNo,inputStreamEmail;
    Scanner inName,inId,inPhnNo,inEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_batch_info);

        GridLayout gridLayout=findViewById(R.id.gridlayout);

        try {
            inputStreamId=getAssets().open("ID_database_second.txt");
            inId=new Scanner(inputStreamId);

            inputStreamName=getAssets().open("Name_database_second.txt");
            inName=new Scanner(inputStreamName);

            inputStreamPhnNo=getAssets().open("phn_no_second.txt");
            inPhnNo=new Scanner(inputStreamPhnNo);

            inputStreamEmail=getAssets().open("email_second.txt");
            inEmail=new Scanner(inputStreamEmail);

                String name="",id="",phnNo="",email="";
            while (inId.hasNext()) {
                name = inName.nextLine();
                id = inId.next();
                phnNo=inPhnNo.next();
                email=inEmail.next();

                Cards cards = new Cards(this, name,id,phnNo,email);
                gridLayout.addView(cards);

            }
        } catch (IOException e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }finally {
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

       // Cards cards=new Cards(this,"Arnab");
       // Cards cards1=new Cards(this,"Naim");
       // Cards cards2=new Cards(this,"Sunan");
       // gridLayout.addView(cards);
       // gridLayout.addView(cards1);
       // gridLayout.addView(cards2);


    }

}

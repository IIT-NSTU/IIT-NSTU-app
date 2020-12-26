package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ThirdBatchInfo extends AppCompatActivity {

    InputStream inputStreamName,inputStreamId,inputStreamPhnNo,inputStreamEmail;
    Scanner inName,inId,inPhnNo,inEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_batch_info);

        GridLayout gridLayout = findViewById(R.id.gridlayout_3);

        try {
            inputStreamId=getAssets().open("ID_database_third.txt");
            inId=new Scanner(inputStreamId);

            inputStreamName=getAssets().open("Name_database_third.txt");
            inName=new Scanner(inputStreamName);

            inputStreamPhnNo=getAssets().open("phn_no_third.txt");
            inPhnNo=new Scanner(inputStreamPhnNo);

            inputStreamEmail=getAssets().open("email_third.txt");
            inEmail=new Scanner(inputStreamEmail);

            String name="",id="",phnNo="",email="";
            int count=0;
            while (inId.hasNext()) {
                name = inName.nextLine();
                id = inId.next();
                phnNo=inPhnNo.next();
                email=inEmail.next();

                UploadCard card=new UploadCard(this,name,id,phnNo,email,String.valueOf(count++));
                gridLayout.addView(card);
                /*Cards cards = new Cards(this, name, id, phnNo, email);
                gridLayout.addView(cards);*/

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
    }
}

package com.whatEver.iitnstu;

import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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

        GridLayout gridLayout=findViewById(R.id.gridlayout_2);

        try {
            inputStreamId=getAssets().open("ID_database_second.txt");
            inId=new Scanner(inputStreamId);

            inputStreamName=getAssets().open("Name_database_second.txt");
            inName=new Scanner(inputStreamName);

            inputStreamPhnNo=getAssets().open("phn_no_second.txt");
            inPhnNo=new Scanner(inputStreamPhnNo);

            inputStreamEmail=getAssets().open("email_second.txt");
            inEmail=new Scanner(inputStreamEmail);

            String name,id,phnNo,email;
            int count=0;
            while (inId.hasNext()) {
                name = inName.nextLine();
                id = inId.next();
                phnNo =inPhnNo.next();
                email =inEmail.next();

                UploadCard card=new UploadCard(this,name,id,phnNo,email,String.valueOf(count++));
                gridLayout.addView(card);

                //StudentCard studentCard = new StudentCard(this, name,id,phnNo,email);
                //gridLayout.addView(studentCard);

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
    public static final Uri getUriToDrawable(@NonNull Context context,
                                             @AnyRes int drawableId) {
        Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + context.getResources().getResourcePackageName(drawableId)
                + '/' + context.getResources().getResourceTypeName(drawableId)
                + '/' + context.getResources().getResourceEntryName(drawableId) );
        return imageUri;
    }

}

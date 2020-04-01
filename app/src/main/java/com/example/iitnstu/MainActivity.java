package com.example.iitnstu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "infoForSearch.txt";
    boolean dataUpdate=false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!dataUpdate){
            saveRawToRoot();
        }

        //updateData();
        download();


        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
         //      WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().setStatusBarColor(this.getResources().getColor(R.color.white));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(homeIntent);
                finish();
                //updateData();
            }
        },1500);


    }


    public void saveRawToRoot(){

        FileOutputStream fileOutputStream = null;
        InputStream inputStream=null;

        try {
            fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            inputStream= getAssets().open("info.txt");
            BufferedOutputStream out=new BufferedOutputStream(fileOutputStream);
            BufferedInputStream in=new BufferedInputStream(inputStream);

            //fos.write(text.getBytes());
            int count;
            while((count = in.read()) != -1)
            {
                out.write((char)count);
                out.flush();
            }

            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME,Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                fileOutputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void updateData() {
        FileOutputStream fileOutputStream;
        try {

            fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
            BufferedOutputStream out=new BufferedOutputStream(fileOutputStream);
            BufferedInputStream in = new BufferedInputStream(new URL("https://drive.google.com/uc?export=download&id=1GnGleaKtLnOqK6y1TfF5H5BO2d7n0GVi").openStream());

            int count;
            while ((count = in.read()) != -1) {
                out.write((char) count);
                out.flush();
            }

            Toast.makeText(this, "DataUpdated ", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            e.printStackTrace();
            Log.i("DataUpdating","Failed");
            Toast.makeText(this, "DataUpdateFailed ", Toast.LENGTH_LONG).show();
        }
    }

    private void download() {
        StorageReference sr = FirebaseStorage.getInstance().getReference().child("info.txt");
        Log.d("keys tasksnapshot anf", sr.toString());


        try {
            File localFile =new  File(getFilesDir() + "/" + FILE_NAME);


            sr.getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Log.d("keys: tasksnapshot", taskSnapshot.toString());
                            dataUpdate=true;

                        }
                    });
            Toast.makeText(this, "DataDownloaded "+localFile.getPath(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //openFile();
    }
}

package com.whatEver.iitnstu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class NoticeBoard extends AppCompatActivity {

    private FirebaseFirestore db;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        gridLayout = findViewById(R.id.notice_layout);
        db=FirebaseFirestore.getInstance();
        final Context context=this;

        final LoadingDialog loadingDialog=new LoadingDialog(NoticeBoard.this);
        loadingDialog.startLoadingDialog();

        db.collection("notice").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot data : task.getResult()) {
                        final HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                        NoticeCard noticeCard = new NoticeCard(context, tmp.get("date").toString(),
                                tmp.get("about").toString(), tmp.get("description").toString());

                        //Log.d("debug",tmp.toString());

                        noticeCard.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent=new Intent(NoticeBoard.this, PdfViewer.class).putExtra("pdfName",tmp.get("pdfNo").toString()).putExtra("folder","notice");
                                startActivity(intent);
                            }
                        });
                        gridLayout.addView(noticeCard);
                        //Log.d("debug",data.getData().toString());
                    }
                    loadingDialog.dismissDialog();
                }
                else {
                    Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

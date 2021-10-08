package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.whatEver.iitnstu.cards.NoticeCard;
import com.whatEver.iitnstu.models.Notice;
import com.whatEver.iitnstu.tools.LoadingDialog;
import com.whatEver.iitnstu.tools.PdfViewer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

/**
 * Activity for Notice Board.
 *
 */
public class NoticeBoardActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private GridLayout gridLayout;
    private LoadingDialog loadingDialog;
    private Context context;
    private static final int noticeLimit = 10;
    private Vector<Notice> notices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        gridLayout = findViewById(R.id.notice_layout);
        notices=new Vector<>();
        db = FirebaseFirestore.getInstance();
        context = this;
        loadingDialog = new LoadingDialog(NoticeBoardActivity.this);


        fetchingData();
    }

    /**
     * Sort all notices by date wise
     */
    private void sortNoticesByDate(){
        Log.e("before sort", String.valueOf(notices));
        notices.sort((o1, o2) -> {
            String[] d1 = o1.getDate().split("/");
            String[] d2 = o2.getDate().split("/");
            LocalDate date1 = LocalDate.of(Integer.parseInt(d1[2]), Integer.parseInt(d1[1]), Integer.parseInt(d1[0]));
            LocalDate date2 = LocalDate.of(Integer.parseInt(d2[2]), Integer.parseInt(d2[1]), Integer.parseInt(d2[0]));
            return date2.compareTo(date1);
        });
        Log.e("after sort", String.valueOf(notices));
    }

    /**
     * Display all notices on the activity window
     */
    private void viewNotices() {
        Log.e("debug", "view");
        for (Notice notice : notices) {
            Log.e("debug", String.valueOf(notice));
            NoticeCard noticeCard = new NoticeCard(context, notice);

            noticeCard.setOnClickListener(v -> {
                if(notice.getPdf()!=null){
                    Intent intent = new Intent(NoticeBoardActivity.this, PdfViewer.class)
                            .putExtra("pdfName", notice.getPdf())
                            .putExtra("folder", "notice");
                    startActivity(intent);
                } else {
                    Toast.makeText(context, "No attached Pdf", Toast.LENGTH_SHORT).show();
                }
            });
            gridLayout.addView(noticeCard);
        }
    }


    /**
     * Fetch data from server.
     */
    private void fetchingData() {
        loadingDialog.startLoadingDialog();

        db.collection("notice").orderBy("#no", Query.Direction.DESCENDING)
                .limit(noticeLimit).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot data : task.getResult()) {
                    final HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                    String pdfName=null;
                    try{
                        pdfName=tmp.get("pdfNo").toString();
                    }catch (NullPointerException e){
                        Log.e("debug","No attached pdf");
                    }finally {
                        Notice newNotice = new Notice(tmp.get("date").toString(),
                                tmp.get("about").toString(), tmp.get("description").toString(),pdfName);
                        Log.e("debug", String.valueOf(newNotice));
                        notices.add(newNotice);
                        Log.e("debug", String.valueOf(notices));
                    }
                }
                sortNoticesByDate();
                viewNotices();

                loadingDialog.dismissDialog();
            } else {
                Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import java.util.HashMap;


public class NoticeBoard extends AppCompatActivity {

    private FirebaseFirestore db;
    private GridLayout gridLayout;
    private LoadingDialog loadingDialog;
    private Context context;
    private static final int noticeLimit = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);

        gridLayout = findViewById(R.id.notice_layout);
        db = FirebaseFirestore.getInstance();
        context = this;
        loadingDialog = new LoadingDialog(NoticeBoard.this);


        fetchingData();
    }


    private void fetchingData() {
        loadingDialog.startLoadingDialog();

        db.collection("notice").orderBy("#no", Query.Direction.DESCENDING)
                .limit(noticeLimit).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (DocumentSnapshot data : task.getResult()) {
                    final HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();
                    NoticeCard noticeCard = new NoticeCard(context, tmp.get("date").toString(),
                            tmp.get("about").toString(), tmp.get("description").toString());

                    noticeCard.setOnClickListener(v -> {
                        Intent intent = new Intent(NoticeBoard.this, PdfViewer.class)
                                .putExtra("pdfName", tmp.get("pdfNo").toString())
                                .putExtra("folder", "notice");
                        startActivity(intent);
                    });
                    gridLayout.addView(noticeCard);
                }

                loadingDialog.dismissDialog();
            } else {
                Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

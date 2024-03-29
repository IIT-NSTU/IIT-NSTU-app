package com.whatEver.iitnstu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.whatEver.iitnstu.cards.OfficialsCard;
import com.whatEver.iitnstu.models.Official;
import com.whatEver.iitnstu.tools.LoadingDialog;

import java.util.HashMap;

/**
 * Activity for Officials.
 *
 */
public class OfficialsActivity extends AppCompatActivity {

    private FirebaseFirestore db;
    private GridLayout gridLayout;
    private Context context;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officials);

        loadingDialog = new LoadingDialog(OfficialsActivity.this);
        gridLayout = findViewById(R.id.gridlayout_2);
        db = FirebaseFirestore.getInstance();
        context = this;

        fetchingData();
    }

    /**
     * Fetch data from server.
     */
    private void fetchingData() {
        loadingDialog.startLoadingDialog();

        db.collection("officials").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                loadingDialog.dismissDialog();
                for (QueryDocumentSnapshot data : task.getResult()) {
                    HashMap<String, Object> tmp = (HashMap<String, Object>) data.getData();

                    Official official = new Official(tmp.get("name").toString(),
                            tmp.get("contactInfo").toString(), tmp.get("phone").toString(),
                            tmp.get("email").toString(), tmp.get("imageLink").toString());

                    OfficialsCard officialsCard = new OfficialsCard(context, official);

                    gridLayout.addView(officialsCard);
                }
            } else {
                Toast.makeText(context, "network error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

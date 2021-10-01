package com.whatEver.iitnstu;

import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


@SuppressLint("ViewConstructor")
public class BatchCard extends FrameLayout {


    public BatchCard(@NonNull final Context context, final String name, final String des, String session,String icon) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.batch_card, this, true);
        LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

        LinearLayout linearLayout=findViewById(R.id.linearLayout);
        linearLayout.setOnClickListener(v -> {
            Intent intent=new Intent(context, StudentAdapter.class).putExtra("batch_id",name).putExtra("des",des);
            context.startActivity(intent);
        });

        ImageView imageView=findViewById(R.id.icon_batch);
        int picId = context.getResources().getIdentifier(icon, "drawable", context.getPackageName());
        imageView.setImageResource(picId);
        TextView batchName=findViewById(R.id.batchName);
        batchName.setText(String.format("%s\n%s", des, session));

    }

}

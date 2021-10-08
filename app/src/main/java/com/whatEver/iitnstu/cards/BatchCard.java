package com.whatEver.iitnstu.cards;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whatEver.iitnstu.R;
import com.whatEver.iitnstu.StudentAdapterActivity;
import com.whatEver.iitnstu.models.Batch;

/**
 * This BatchCard class is used to display a batch in a form of card.
 *
 * A child class of Card.
 */
public class BatchCard extends Card {

    private Context context;
    private Batch batch;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private TextView batchName;


    /**
     * Default constructor.
     *
     * @param context: from the activity the card is invoked.
     */
    public BatchCard(Context context) {
        super(context);
        this.context = context;
    }


    /**
     * Another constructor which will take a specific Batch object
     * to display it in a form of card.
     *
     * @param context: from the activity the card is invoked.
     * @param batch: The Batch object which it will display.
     */
    public BatchCard(Context context, Batch batch) {
        this(context);
        this.batch = batch;

        LayoutInflater.from(context).inflate(R.layout.batch_card, this, true);

        linearLayout = findViewById(R.id.linearLayout);
        imageView = findViewById(R.id.icon_batch);
        batchName = findViewById(R.id.batchName);

        setData();

    }

    @Override
    public void setData() {
        batchName.setText(String.format("%s\n%s", batch.getDescription(), batch.getSession()));

        linearLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, StudentAdapterActivity.class).putExtra("batch_id", batch.getName()).putExtra("des", batch.getDescription());
            context.startActivity(intent);
        });

        int picId = context.getResources().getIdentifier(batch.getIcon(), "drawable", context.getPackageName());
        imageView.setImageResource(picId);
    }
}

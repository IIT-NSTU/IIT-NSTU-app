package com.whatEver.iitnstu.cards;


import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.whatEver.iitnstu.R;
import com.whatEver.iitnstu.models.Notice;

/**
 * This NoticeCard class is used to display a Notice object in a form of card.
 *
 * A child class of Card.
 */
public class NoticeCard extends Card {

    private Context context;
    private Notice notice;
    private TextView noticeDateText;
    private TextView noticeAboutText;
    private TextView noticeDescriptionText;


    /**
     * Default constructor.
     *
     * @param context: from the activity the card is invoked.
     */
    public NoticeCard(Context context) {
        super(context);
        this.context = context;
    }


    /**
     * Another constructor which will take a specific Notice object
     * to display it in a form of card.
     *
     * @param context: from the activity the card is invoked.
     * @param notice: The Notice object which it will display.
     */
    public NoticeCard(Context context, Notice notice) {
        this(context);
        this.notice = notice;

        LayoutInflater.from(context).inflate(R.layout.activity_notice_card, this, true);

        noticeDateText = findViewById(R.id.notice_date);
        noticeAboutText = findViewById(R.id.notice_about);
        noticeDescriptionText = findViewById(R.id.notice_des);

        setData();

    }

    @Override
    public void setData() {
        noticeDateText.setText(notice.getDate());
        noticeAboutText.setText(notice.getAbout());
        noticeDescriptionText.setText(notice.getDescription());
    }

}

package com.whatEver.iitnstu.cards;


import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.whatEver.iitnstu.R;
import com.whatEver.iitnstu.models.Notice;


public class NoticeCard extends Card {

    private Context context;
    private Notice notice;
    private TextView noticeDateText;
    private TextView noticeAboutText;
    private TextView noticeDescriptionText;

    public NoticeCard(Context context) {
        super(context);
        this.context = context;
    }

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

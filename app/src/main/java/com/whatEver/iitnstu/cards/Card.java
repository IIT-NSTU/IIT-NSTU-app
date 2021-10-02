package com.whatEver.iitnstu.cards;


import android.content.Context;
import android.widget.FrameLayout;


public abstract class Card extends FrameLayout {

    public Card(Context context) {
        super(context);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

    }

    public abstract void setData();
}

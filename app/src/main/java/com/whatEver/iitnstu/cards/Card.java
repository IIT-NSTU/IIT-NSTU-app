package com.whatEver.iitnstu.cards;


import android.content.Context;
import android.widget.FrameLayout;

/**
 * This is an abstract card implementation.
 *
 * All other type of card class should extends this class
 * and should implement the setData method.
 */
public abstract class Card extends FrameLayout {

    /**
     * Default constructor.
     *
     * @param context: from the activity the card is invoked.
     */
    public Card(Context context) {
        super(context);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);

    }

    /**
     * This method set all the data in all views inside this card.
     */
    public abstract void setData();
}

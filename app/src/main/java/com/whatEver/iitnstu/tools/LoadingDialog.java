package com.whatEver.iitnstu.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.whatEver.iitnstu.R;

/**
 * A custom loading dialog for displaying loading state.
 *
 */
public class LoadingDialog {

    private Activity activity;
    private AlertDialog alertDialog;

    /**
     * Default constructor.
     *
     * @param activity: from the activity the card is invoked.
     */
    public LoadingDialog(Activity activity) {
        this.activity = activity;
    }

    /**
     * Start the LoadingDialog.
     */
    public void startLoadingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(false);

        alertDialog = builder.create();
        alertDialog.show();
    }

    /**
     * Dismissed the LoadingDialog.
     */
    public void dismissDialog() {
        alertDialog.dismiss();
    }
}

package be.ehb.kameelrace.util;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingHandler extends Handler {

    private ProgressBar progressBar;
    private TextView progressTV;

    public LoadingHandler(ProgressBar progressBar, TextView progressTV) {
        this.progressBar = progressBar;
        this.progressTV = progressTV;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        progressBar.setProgress(msg.arg1);
    }
}

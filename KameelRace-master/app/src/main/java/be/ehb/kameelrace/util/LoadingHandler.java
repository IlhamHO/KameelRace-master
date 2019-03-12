package be.ehb.kameelrace.util;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class LoadingHandler extends Handler {

    private ProgressBar progressBar;

    public LoadingHandler(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        progressBar.setProgress(msg.arg1);
    }
}

package be.ehb.kameelrace;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;

import be.ehb.kameelrace.util.LoadingHandler;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    private ProgressBar jefPbLoading, joskePbLoading, freddyPbLoading;
    private LoadingHandler jefLoadingHandler, joskeLoadingHandler, freddyLoadingHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.kameel_spinner);
        jefPbLoading = findViewById(R.id.pb_jef);
        joskePbLoading = findViewById(R.id.pb_joske);
        freddyPbLoading = findViewById(R.id.pb_freddy);
        jefLoadingHandler = new LoadingHandler(jefPbLoading);
        joskeLoadingHandler = new LoadingHandler(joskePbLoading);
        freddyLoadingHandler = new LoadingHandler(freddyPbLoading);
    }

    public void onStartClicked(View v){
        Thread jefBackgroudThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i <= 20; i++) {
                  Message message = new Message();
                    message.arg1 = i;
                    jefLoadingHandler.sendMessage(message);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        jefBackgroudThread.start();

        Thread joskeBackgrougThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for( int j = 0; j<= 20; j++){
                    Message message = new Message();
                    message.arg1 = j;
                    joskeLoadingHandler.sendMessage(message);

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                            e.printStackTrace();
                    }
                }

            }
        });
        joskeBackgrougThread.start();

        Thread freddyBackgroundTread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int k = 0; k <= 20; k++) {
                    Message message = new Message();
                    message.arg1 = k;
                    freddyLoadingHandler.sendMessage(message);
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        freddyBackgroundTread.start();
    }


}

package be.ehb.kameelrace;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

import be.ehb.kameelrace.util.LoadingHandler;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private TextView tvLoading;
    private ProgressBar jefPbLoading, joskePbLoading, freddyPbLoading;
    private LoadingHandler jefLoadingHandler, joskeLoadingHandler, freddyLoadingHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLoading = findViewById(R.id.tv_loading);
        jefPbLoading = findViewById(R.id.pb_jef);
        joskePbLoading = findViewById(R.id.pb_joske);
        freddyPbLoading = findViewById(R.id.pb_freddy);
        jefLoadingHandler = new LoadingHandler(jefPbLoading,tvLoading);
        joskeLoadingHandler = new LoadingHandler(joskePbLoading,tvLoading);
        freddyLoadingHandler = new LoadingHandler(freddyPbLoading,tvLoading);
        spinner = (Spinner)findViewById(R.id.kameel_spinner);
        spinner.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.kameel_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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
                Random random= new Random();
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        CharSequence charSequence = (CharSequence) parent.getItemAtPosition(position);
        System.out.println("Item : " + charSequence.toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

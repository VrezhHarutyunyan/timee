package com.example.cybertech2.timee.activities;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cybertech2.timee.R;

public class LogoActivity extends AppCompatActivity {
    private  int progressStatus;
    ProgressBar  progressBar;
    private     Handler handler;
    private TextView textView;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_logo);

        progressBar = findViewById(R.id.progrssBarLogo);
        progressBar.setProgressTintList(ColorStateList.valueOf(Color.WHITE));
        textView = findViewById(R.id.textProgress);
                handler = new Handler();
                progressStatus=0;




        new Thread(new Runnable() {
            public void run() {
                while (progressStatus <= 150) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        public void run() {
                        progressBar.setProgress(progressStatus);
                        }

                    });

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Intent myIntent = new Intent(LogoActivity.this,HomeActivity.class);
                myIntent.putExtra("key", "......"); //Optional parameters
                startActivity(myIntent);
            }
        }).start();

}
}

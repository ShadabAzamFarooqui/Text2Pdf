package com.example.berylsystems.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class SplashActivity extends Activity {

    String s = " Text2Pdf ";
    int i;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        textView=(TextView) findViewById(R.id.textView);
        handler(s.charAt(i));
    }


    void handler(final char c) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i < s.length() - 1) {
                    textView.append("" + c);
                    i = i + 1;
                    handler(s.charAt(i));
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                    finish();
                }
            }
        }, 200);
    }
}

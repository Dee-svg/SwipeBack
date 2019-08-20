package com.kevin.swipeback.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.kevin.swipeback.BaseTestActivity;
import com.kevin.swipeback.R;

public class WelcomeActivity  extends BaseTestActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        swipeDragToClose();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(context,MainActivity.class));
                finish();
            }
        },1500);
    }
}

package com.kevin.swipeback.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gw.swipeback.SwipeBack;
import com.kevin.swipeback.BaseTestActivity;
import com.kevin.swipeback.R;

public class MainActivity extends BaseTestActivity {
    private TextView openOffSwipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openOffSwipe= findViewById(R.id.main_open_off_swipe);
        findViewById(R.id.main_to_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,Test1EditActivity.class));
            }
        });
        openOffSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isopen=(openOffSwipe.getText().toString()).equals("点击开启");
                if(isopen){
                    openOffSwipe.setText("点击关闭");
                    SwipeBack.enableDragToClose(context, true);
                }else {
                    openOffSwipe.setText("点击开启");
                    SwipeBack.enableDragToClose(context, false);
                }
            }
        });
    }
}

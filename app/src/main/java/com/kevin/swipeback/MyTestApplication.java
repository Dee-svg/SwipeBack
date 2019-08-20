package com.kevin.swipeback;

import android.app.Application;

import com.gw.swipeback.SwipeBack;

public class MyTestApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化侧滑退出
        SwipeBack.init(this);
    }
}

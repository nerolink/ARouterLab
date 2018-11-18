package com.nerolink.arouterlab;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openDebug();
        ARouter.init(this);
    }
}

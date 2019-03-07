package com.example.dell.m3_weiduxiangmu.app;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.example.dell.m3_weiduxiangmu.api.UserApi;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.autolayout.config.AutoLayoutConifg;

public class MyApp extends Application
{

    public static UserApi userApi;
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        AutoLayoutConifg.getInstance().useDeviceSize();
        context = getApplicationContext();

    }

   public static Context getApplication()
    {
        return context;
    }
}

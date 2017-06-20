package com.example.kubyhuang.mymacpro;

import android.app.Application;

import org.xutils.x;

/**
 * Created by kubyhuang on 2017/2/3.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}

package com.bianhua.com;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    /**
     * context 全局唯一的上下文
     */
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }



    public static Context getContext() {
        return context;
    }
}

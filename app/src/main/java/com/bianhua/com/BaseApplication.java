package com.bianhua.com;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {


    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;




    }



    /**
     * context 全局唯一的上下文
     */
    public static Context getContext() {
        return context;
    }
}

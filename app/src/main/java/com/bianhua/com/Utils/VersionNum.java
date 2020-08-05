package com.bianhua.com.Utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.bianhua.com.BaseApplication;
    //获取App版本号
public class VersionNum {
      public static String versionName="";

        public static String GetVersion(){
            PackageManager packageManager = BaseApplication.getContext().getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(BaseApplication.getContext().getPackageName(), 0);
                versionName=packageInfo.versionName;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return versionName;
        }


}

package com.bianhua.com.Utils.Sp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences    存储
 */
public class StorageCustomerInfoUtil {

    public static void putInfo(Context context, String key, String value) {
        SharedPreferences sps = context.getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sps.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void putInfo(Context context, String key, boolean value) {
        SharedPreferences sps = context.getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sps.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void putInfo(Context context, String key, int value) {
        SharedPreferences sps = context.getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sps.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getIntInfo(Context context, String key, int value) {
        SharedPreferences sps = context.getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        return sps.getInt(key, value);

    }

    public static boolean getBooleanInfo(String key, Context context) {

        SharedPreferences sps = context.getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        boolean value = sps.getBoolean(key, false);

        return value;
    }

    public static String getInfo(String key, Context context) {

        SharedPreferences sps = context.getSharedPreferences("customerInfo", Context.MODE_PRIVATE);
        String value = sps.getString(key, "");

        return value;
    }

    /**
     * @param key
     * @param context
     * @return
     */
    public static boolean removeKey(String key, Context context) {
        SharedPreferences sp = context.getSharedPreferences("customerInfo",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
        return true;

    }

    public static boolean clearKey(Context context) {

        SharedPreferences sp = context.getSharedPreferences("customerInfo",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
        return true;

    }

}

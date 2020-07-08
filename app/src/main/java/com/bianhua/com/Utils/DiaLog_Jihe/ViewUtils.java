package com.bianhua.com.Utils.DiaLog_Jihe;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bianhua.com.BaseApplication;
import com.bianhua.com.R;

/**
 *  吐司+dailog提示框
 */
public class ViewUtils {
    /**
     *      吐司1   位置在中间
     *
     * @param context        上下文
     * @param text           吐司的内容
     * @param duration       吐司的时长
     */
    public static void makeToast01(Context context, String text, int duration) {
        Toast result = new Toast(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.toast_layout, null);
        TextView textView = (TextView) layout.findViewById(R.id.toast_text);
        textView.setText(text);
        result.setView(layout);
        result.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        result.setDuration(duration);
        result.show();
    }

    /**
     *  吐司2                 原生吐司
     *
     * @param text            吐司的内容
     */
    public static void makeToast02(String text){
        Toast.makeText(BaseApplication.getContext(), text,  Toast.LENGTH_LONG);
    }



    /**
     * 选择提示框            在屏幕中间
     *
     * @param context                    上下文
     * @param isCanceledOnTouchOutside   是否可以点击其他区域
     * @param msg                        提示内容
     * @param onChoseDialogClickCallback 点击事件的回调
     * @return
     */
    public static Dialog showChoseDialog(Context context, boolean isCanceledOnTouchOutside, String msg,
                                         final OnChoseDialogClickCallback onChoseDialogClickCallback) {
        final Dialog dialog = new Dialog(context, R.style.MyProgressDialog);
        dialog.setContentView(R.layout.chose_dialog);
        dialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
        Button confirmBt = (Button) dialog.findViewById(R.id.left_bt);
        Button cancleBt = (Button) dialog.findViewById(R.id.right_bt);
        ((TextView) dialog.findViewById(R.id.title_text)).setText(msg);
        cancleBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onChoseDialogClickCallback != null) {
                    dialog.dismiss();
                    onChoseDialogClickCallback.clickCancel();
                } else {
                    dialog.dismiss();
                }
            }
        });
        confirmBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onChoseDialogClickCallback != null) {
                    dialog.dismiss();
                    onChoseDialogClickCallback.clickOk();
                } else {
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
        return dialog;
    }

    public interface OnChoseDialogClickCallback {
        public void clickOk();      //确定后执行的函数

        public void clickCancel();  //取消函数
    }



}

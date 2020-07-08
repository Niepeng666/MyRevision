package com.bianhua.com.Utils.DiaLog_Jihe;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bianhua.com.R;

/**
 *  dailog提示框
 */
public class ChooseDialog extends Dialog {

    private OnChooseDialogListener listener;
    private TextView textTip00;
    private  TextView textTip01;
    private  TextView textCancle;

    public ChooseDialog(@NonNull Context context) {
        super(context);
    }
    /**
     *         选择提示框            从底部弹出
     *
     * @param context                    上下文
     * @param name1                      第一个按钮文字
     * @param name2                      第二个按钮文字
     *
     * @return
     */
    public ChooseDialog(Context context, String name1, String name2) {
        super(context, R.style.payDialogstyle);
        setContentView(R.layout.dialog_choose);
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textTip00 = (TextView) findViewById(R.id.text_tip00);
        textTip00.setText(name1);
        textTip01 = (TextView) findViewById(R.id.text_tip01);
        textTip01.setText(name2);
        textCancle = (TextView) findViewById(R.id.text_cancle);
    }

    public ChooseDialog setOnChooseDialogListener(final OnChooseDialogListener listener) {

        this.listener = listener;

        textCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (listener != null) {
                    listener.onCancle();
                }
            }
        });

        textTip00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (listener != null) {
                    listener.onSelect0();
                }
            }
        });
        textTip01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (listener != null) {
                    listener.onSelect1();
                }
            }
        });
        return this;
    }
    public interface OnChooseDialogListener{

        void onCancle();        //取消按钮

        void onSelect0();       //第一个按钮

        void onSelect1();       //第二个按钮
    }
}

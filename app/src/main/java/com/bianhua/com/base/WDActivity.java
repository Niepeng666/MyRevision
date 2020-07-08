package com.bianhua.com.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;


/**
 * @author 聂俊鹏
 * @date 2020/07/08 10:00
 * qq:2241659414
 */
public abstract class WDActivity extends AppCompatActivity {
    public Activity context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(getLayoutId());
        initView();
        //全局设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //
        ButterKnife.bind(this);
    }

    /**
     * 设置layoutId
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化视图
     */
    protected abstract void initView();

    /**
     * destory activity销毁的方法
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     *
     */
    @Override
    protected void onStart() {
        super.onStart();

    }

    public abstract void onCheckedChanged(RadioGroup group, int checkedId);
}

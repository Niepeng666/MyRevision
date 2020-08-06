package com.bianhua.com.activity;

import android.util.Log;

import com.bianhua.com.R;
import com.bianhua.com.Utils.DiaLog_Jihe.ViewUtils;
import com.bianhua.com.Utils.Jurisdiction.PermissionsUtils;
import com.bianhua.com.Utils.VersionNum;
import com.bianhua.com.base.WDActivity;

/**
 *  LoginActivity 登录的页面
 */
public class LoginActivity extends WDActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
       //一键授权
        PermissionsUtils.requestPermissionselect(this);
        //获取App版本号
        ViewUtils.makeToast01(context,VersionNum.GetVersion(),1500);
        initData();
    }
    //逻辑操作
    private void initData() {



    }

}
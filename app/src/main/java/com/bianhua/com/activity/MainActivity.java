package com.bianhua.com.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bianhua.com.R;
import com.bianhua.com.Utils.ActivityManager;
import com.bianhua.com.base.WDActivity;
import com.bianhua.com.bean.SendMessageCommunitor;
import com.bianhua.com.fragment.CircleFragment;
import com.bianhua.com.fragment.HomeFragment;
import com.bianhua.com.fragment.MeFragment;
import com.bianhua.com.fragment.SendFragment;
import com.bianhua.com.fragment.ShareFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * MainActivity 主页面
 */
public class MainActivity extends WDActivity implements SendMessageCommunitor {


    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.home_btn)
    RadioButton homeBtn;
    @BindView(R.id.circle_btn)
    RadioButton circleBtn;
    @BindView(R.id.cart_btn)
    RadioButton cartBtn;
    @BindView(R.id.list_btn)
    RadioButton listBtn;
    @BindView(R.id.me_btn)
    RadioButton meBtn;
    @BindView(R.id.bottom_menu)
    RadioGroup bottomMenu;
    private HomeFragment homeFragment;
    private CircleFragment circleFragment;
    private MeFragment meFragment;
    private SendFragment sendFragment;
    private ShareFragment shareFragment;
   Fragment currentFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * 获取activity布局里的控件ID
     */
    @Override
    protected void initView() {
        homeFragment = new HomeFragment();
        circleFragment = new CircleFragment();
        meFragment = new MeFragment();
        sendFragment = new SendFragment();
        shareFragment = new ShareFragment();
        currentFragment = homeFragment;
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.add(R.id.container, homeFragment)
                .show(homeFragment).commit();


    }



    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.home_btn) {
            showFragment(homeFragment);
        } else if (checkedId == R.id.circle_btn) {
            showFragment(circleFragment);
        }else if (checkedId == R.id.me_btn){
            showFragment(meFragment);
        }else if (checkedId==R.id.cart_btn){
            showFragment(sendFragment);
        }else if (checkedId== R.id.list_btn){
            showFragment(shareFragment);
        }
    }

    @Override
    public void sendMessage(String msg) {
            if ("mainselecet1".equals(msg)){
                showFragment(homeFragment);
            }else  if ("mainselecet1".equals(msg)){
                showFragment(circleFragment);
            }else  if ("mainselecet1".equals(msg)){
                showFragment(sendFragment);
            }else  if ("mainselecet1".equals(msg)){
                showFragment(shareFragment);
            }else  if ("mainselecet1".equals(msg)){
                showFragment(meFragment);
            }
    }


    /**
     * 展示Fragment
     */
    private void showFragment(Fragment fragment) {
        if (currentFragment != fragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(currentFragment);
            currentFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.container, fragment).show(fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
        }
    }
    private long firstime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            /** 设置双击退出 */
            long secondtime = System.currentTimeMillis();
            if (secondtime - firstime > 3000) {
                Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show();
                firstime = System.currentTimeMillis();
                return true;
            } else {
                finish();
                ActivityManager.exit();
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);

    }


}
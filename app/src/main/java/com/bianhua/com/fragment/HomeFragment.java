package com.bianhua.com.fragment;

import android.widget.TextView;

import com.bianhua.com.R;
import com.bianhua.com.base.WDFragment;
import com.bianhua.com.bean.SendMessageCommunitor;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author 聂俊鹏
 * @date 首页
 * qq:2241659414
 */
public class HomeFragment extends WDFragment {


    @BindView(R.id.text_chuan)
    TextView textChuan;
    private SendMessageCommunitor sendMessage;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.text_chuan)
    public void onViewClicked() {

        sendMessage.sendMessage("mainselecet1");
    }
}

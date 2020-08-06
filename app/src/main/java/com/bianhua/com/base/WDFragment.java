package com.bianhua.com.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bianhua.com.bean.SendMessageCommunitor;
import com.gyf.immersionbar.ImmersionBar;


public abstract class WDFragment extends Fragment {
	public Activity context;
	private SendMessageCommunitor sendMessage;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		View view = inflater.inflate(getLayoutId(),container,false);
		context=getActivity();
		initView();
		//沉浸式状态栏
		ImmersionBar.with(this).barAlpha(0.1f).init();
		return view;
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

}

package com.bianhua.com.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bianhua.com.bean.SendMessageCommunitor;


public abstract class WDFragment extends Fragment {
	public Activity context;
	private SendMessageCommunitor sendMessage;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
		View view = inflater.inflate(getLayoutId(),container,false);
		context=getActivity();
		initView();
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
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		sendMessage = (SendMessageCommunitor) activity;

	}
}

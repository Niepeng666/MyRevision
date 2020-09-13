package com.bianhua.com.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bianhua.com.bean.SendMessageCommunitor
import com.gyf.immersionbar.ImmersionBar

abstract class WDFragment : Fragment() {
    var context: Activity? = null
     val sendMessage: SendMessageCommunitor? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutId, container, false)
        context = activity
        //沉浸式状态栏
        ImmersionBar.with(this).barAlpha(0.1f).init()
        return view
    }

    /**
     * 设置layoutId
     * @return
     */
    protected abstract val layoutId: Int

}
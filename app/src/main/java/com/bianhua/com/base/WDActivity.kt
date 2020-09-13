package com.bianhua.com.base

import android.app.Activity
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bianhua.com.fragment.HomeFragment
import com.gyf.immersionbar.ImmersionBar

/**
 * @author 聂俊鹏
 * @date 2020/07/08 10:00
 * qq:2241659414
 */
abstract class WDActivity : AppCompatActivity() {
    @JvmField
    var context: Activity? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContentView(layoutId)
        initView()
        //全局设置竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        //沉浸式状态栏
        ImmersionBar.with(this).barAlpha(0.1f).init()
    }

    /**
     * 设置layoutId
     * @return
     */
    protected abstract val layoutId: Int

    /**
     * 初始化视图
     */
    protected abstract fun initView()

    /**
     * destory activity销毁的方法
     */
    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     *
     */
    override fun onStart() {
        super.onStart()
    }

}
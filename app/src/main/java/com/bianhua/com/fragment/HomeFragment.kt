package com.bianhua.com.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bianhua.com.R
import com.bianhua.com.Utils.DiaLog_Jihe.ViewUtils
import com.bianhua.com.base.WDFragment
import com.bianhua.com.bean.SendMessageCommunitor
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.title_layout.*

/**
 * @author 聂俊鹏
 * @date 首页         第一个fragment
 * qq:2241659414
 */
class HomeFragment : WDFragment(){



    override val layoutId: Int = R.layout.fragment_home

    override fun onResume() {
        super.onResume()
        title_text.setText("首页")


    }

}
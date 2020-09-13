package com.bianhua.com.activity

import android.view.KeyEvent
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bianhua.com.R
import com.bianhua.com.Utils.ActivityManager
import com.bianhua.com.base.WDActivity
import com.bianhua.com.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * MainActivity 主页面
 */
class MainActivity : WDActivity(), RadioGroup.OnCheckedChangeListener {
   lateinit var homeFragment: HomeFragment
    lateinit var circleFragment: CircleFragment
    lateinit var sendFragment: SendFragment
    lateinit var myFragment: MyFragment
    lateinit var shareFragment: ShareFragment
    lateinit var currentFragment: Fragment


    /**
     * 布局
     */
    override val layoutId: Int = R.layout.activity_main


    override fun initView() {
    bottom_menu!!.setOnCheckedChangeListener(this)

       homeFragment = HomeFragment()
       circleFragment = CircleFragment()
       sendFragment = SendFragment()
       shareFragment= ShareFragment()
       myFragment = MyFragment()
    currentFragment = homeFragment

     val beginTransaction = supportFragmentManager.beginTransaction()
         beginTransaction.add(R.id.container,homeFragment).show(homeFragment).commit()
}




    /**
     * 防止错误退出！
     */
    private var firstime: Long = 0
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            /** 设置双击退出  */
            val secondtime = System.currentTimeMillis()
            if (secondtime - firstime > 3000) {
                Toast.makeText(this, "再按一次返回键退出", Toast.LENGTH_SHORT).show()
                firstime = System.currentTimeMillis()
                return true
            } else {
                finish()
                ActivityManager.exit()
                System.exit(0)
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onCheckedChanged(group : RadioGroup?, checkedId: Int) {
        if (checkedId == R.id.home_btn) {
            showFragment(homeFragment);
        } else if (checkedId == R.id.circle_btn) {
            showFragment(circleFragment);
        }else if (checkedId == R.id.me_btn){
            showFragment(myFragment);
        }else if (checkedId==R.id.cart_btn){
            showFragment(sendFragment);
        }else if (checkedId== R.id.list_btn){
            showFragment(shareFragment);
        }
    }

    private fun showFragment(fragment: Fragment){
        if (currentFragment != fragment) {
         val transaction =supportFragmentManager.beginTransaction()
            transaction.hide(currentFragment);
            currentFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.container, fragment).show(fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
        }

    }

}
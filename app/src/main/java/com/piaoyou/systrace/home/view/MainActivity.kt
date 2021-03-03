package com.piaoyou.systrace.home.view

import android.Manifest
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.PermissionUtils
import com.blankj.utilcode.util.ToastUtils
import com.meituan.robust.patch.RobustModify
import com.piaoyou.systrace.R
import com.piaoyou.systrace.base.App
import com.piaoyou.systrace.configChange.view.ConfigChangeActivity
import com.piaoyou.systrace.utils.RouterXX


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tvAction).setOnClickListener {
            gotoConfigChangeActivity()
        }
        findViewById<View>(android.R.id.content).setOnClickListener {
            runRobust()
        }
    }

    private fun runRobust() {
        ToastUtils.showShort("点击 contentView")
        PermissionUtils.permission(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).callback(object : PermissionUtils.SimpleCallback {
            override fun onGranted() {
                App.setPatchExecutor()
            }

            override fun onDenied() {
                ToastUtils.showShort("权限被拒绝")
            }
        }).request()
    }

    private fun gotoConfigChangeActivity() {
        //throw IllegalArgumentException("")
        RobustModify.modify()
        RouterXX.startActivity(this, ConfigChangeActivity::class.java)
        //如果不新增 RouterXX.startActivity(this, ConfigChangeActivity::class.java) 方法，直接调用下面注释方法，则可以生成patch.jar
        //startActivity(Intent(this, ConfigChangeActivity::class.java))
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.iTag(TAG, "onRestart-$this")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.iTag(TAG, "onStop-$this")
    }

    override fun onDestroy() {
        LogUtils.iTag(TAG, "onDestroy-$this")
        super.onDestroy()
    }

    companion object {
        const val TAG = "MainActivity"
    }

}
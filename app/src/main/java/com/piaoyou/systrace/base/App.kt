package com.piaoyou.systrace.base

import android.Manifest
import android.app.Application
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.PermissionUtils
import com.meituan.robust.PatchExecutor
import com.piaoyou.systrace.robust.PatchManipulateImp
import com.piaoyou.systrace.robust.RobustCallBackSample
import kotlin.properties.Delegates

/**
 * @Author zhan
 * @Date 2/25/21 6:14 PM
 * @Desc
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initInstance()
        setUnCaughtCrash()
    }

    private fun initInstance() {
        instance = this
    }

    private fun setUnCaughtCrash() {
        Thread.setDefaultUncaughtExceptionHandler { _, e ->
            LogUtils.e("uncaughtException", e.message)
            setPatchExecutor()
        }
    }

    companion object {

        private val STORAGE_PERMISSION = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )

        var instance: Application by Delegates.notNull()

        /**
         * robust 加载 patch.jar
         */
        fun setPatchExecutor() {
            if (PermissionUtils.isGranted(STORAGE_PERMISSION[0], STORAGE_PERMISSION[1])) {
                PatchExecutor(
                    instance,
                    PatchManipulateImp(),
                    RobustCallBackSample()
                ).start()
            }
        }
    }
}
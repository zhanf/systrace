package com.piaoyou.systrace.home.base

import androidx.lifecycle.LifecycleObserver

/**
 * @Author zhan
 * @Date 2020/12/26 10:21 AM
 * @Desc
 */
interface ILifecycleObserver : LifecycleObserver {

    fun onCreate()

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()
}
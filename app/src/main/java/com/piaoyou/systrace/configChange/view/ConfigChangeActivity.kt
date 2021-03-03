package com.piaoyou.systrace.configChange.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.LogUtils
import com.piaoyou.systrace.R
import com.piaoyou.systrace.databinding.ActivityConfigChangeBinding

class ConfigChangeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfigChangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigChangeBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_config_change)
        setContentView(binding.root)
        LogUtils.iTag(TAG, "onCreate-$this")
        binding.tvSave.setOnClickListener {
            binding.tvSave.text = "1111111111"
            recreate()
        }
        initFragment()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("Text", "333")
        super.onSaveInstanceState(outState)
        binding.tvSave.onSaveInstanceState()
        LogUtils.iTag(TAG, "onSaveInstanceState-$this")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val string = savedInstanceState.getString("Text")
        binding.tvSave.text = string
        LogUtils.iTag(TAG, "onRestoreInstanceState-$this")
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

    private fun initFragment() {
        var fragment = supportFragmentManager.findFragmentByTag(TAG)
        if (null == fragment) {
            fragment = ConfigChangeFragment()
        }
        if (!fragment.isAdded) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.containerView, fragment, TAG)
            transaction.commit()
        }
    }


    companion object {
        const val TAG = "ConfigChangeFragment"

    }
}
package com.piaoyou.systrace.configChange.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.LogUtils
import com.piaoyou.systrace.R

class ConfigChangeFragment : Fragment() {

    private lateinit var dummy_button: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.iTag(TAG, "onCreate-$this")

//        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_config_change, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtils.iTag(TAG, "onViewCreated-$this")
        dummy_button = view.findViewById(R.id.dummy_button)


    }

    override fun onResume() {
        super.onResume()
        LogUtils.iTag(TAG, "onResume-$this")

    }

    override fun onPause() {
        super.onPause()
        LogUtils.iTag(TAG, "onPause-$this")

    }

    override fun onDestroy() {
        LogUtils.iTag(TAG, "onDestroy-$this")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("Text", "onViewStateRestored")
        super.onSaveInstanceState(outState)
        LogUtils.iTag(TAG, "onSaveInstanceState-$this")

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        val string = savedInstanceState?.getString("Text")
        dummy_button.text = string
        LogUtils.iTag(TAG, "onViewStateRestored-$this")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtils.iTag(TAG, "onDestroyView-$this")
    }

    override fun onDetach() {
        LogUtils.iTag(TAG, "onDetach-$this")
        super.onDetach()
    }

    companion object {
        private val TAG = ConfigChangeFragment::class.simpleName
    }
}
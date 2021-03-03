package com.piaoyou.systrace.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.piaoyou.systrace.R
import com.piaoyou.systrace.home.base.BaseFragment

class LifecycleFragment : BaseFragment() {

    companion object {
        fun newInstance() = LifecycleFragment()
    }

    private lateinit var viewModel: LifecycleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lifecycle_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LifecycleViewModel::class.java)
        lifecycle.addObserver(viewModel)
    }

}
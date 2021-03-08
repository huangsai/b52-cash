package com.mobile.app.core

import com.mobile.guava.android.mvvm.BaseFragment

abstract class MyBaseFragment : BaseFragment() {

    override fun onResume() {
        super.onResume()
        if (onResumeCount == 1) {
            onFirstResume()
        }
    }

    protected open fun setupWindowInsets() {}

    protected open fun onFirstResume() {}
}
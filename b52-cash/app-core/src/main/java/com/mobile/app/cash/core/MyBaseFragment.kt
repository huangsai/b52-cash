package com.mobile.app.cash.core

import androidx.annotation.LayoutRes
import com.mobile.guava.android.mvvm.BaseFragment

abstract class MyBaseFragment(
    @LayoutRes contentLayoutId: Int = 0
) : BaseFragment(contentLayoutId) {

    override fun onResume() {
        super.onResume()
        if (onResumeCount == 1) {
            onFirstResume()
        }
    }

    protected open fun setupWindowInsets() {}

    protected open fun onFirstResume() {}
}
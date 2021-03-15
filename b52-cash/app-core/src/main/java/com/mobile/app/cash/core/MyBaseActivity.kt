package com.mobile.app.cash.core

import android.content.pm.PackageManager
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import com.mobile.guava.android.mvvm.AndroidX
import com.mobile.guava.android.mvvm.BaseActivity

abstract class MyBaseActivity(
    @LayoutRes contentLayoutId: Int = 0
) : BaseActivity(contentLayoutId) {

    protected open fun setupWindowInsets() {}

    protected fun checkPermission(vararg permissions: String): Boolean {
        val granted = PackageManager.PERMISSION_GRANTED
        permissions.forEach {
            if (ContextCompat.checkSelfPermission(AndroidX.myApp, it) != granted) {
                return false
            }
        }
        return true
    }
}
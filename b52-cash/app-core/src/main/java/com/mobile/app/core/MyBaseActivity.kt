package com.mobile.app.core

import com.mobile.guava.android.mvvm.BaseActivity

abstract class MyBaseActivity : BaseActivity() {

    protected open fun setupWindowInsets() {}
}
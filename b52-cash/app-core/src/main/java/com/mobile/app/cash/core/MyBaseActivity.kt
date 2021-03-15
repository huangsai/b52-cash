package com.mobile.app.cash.core

import com.mobile.guava.android.mvvm.BaseActivity

abstract class MyBaseActivity : BaseActivity() {

    protected open fun setupWindowInsets() {}
}
package com.mobile.app.cash.core

import com.mobile.guava.android.mvvm.BaseAppCompatDialogFragment

abstract class MyBaseAppCompatDialogFragment : BaseAppCompatDialogFragment() {

    protected open fun setupWindowInsets() {}
}
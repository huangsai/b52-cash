package com.mobile.app.core

import com.mobile.guava.android.mvvm.BaseAppCompatDialogFragment

abstract class MyBaseAppCompatDialogFragment : BaseAppCompatDialogFragment() {

    protected open fun setupWindowInsets() {}
}
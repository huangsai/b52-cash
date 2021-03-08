package com.mobile.app.core

import com.mobile.guava.android.mvvm.BaseBottomSheetDialogFragment

abstract class MyBaseBottomSheetDialogFragment : BaseBottomSheetDialogFragment() {

    protected open fun setupWindowInsets() {}
}
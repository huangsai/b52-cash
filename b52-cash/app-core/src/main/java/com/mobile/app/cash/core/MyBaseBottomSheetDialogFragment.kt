package com.mobile.app.cash.core

import com.mobile.guava.android.mvvm.BaseBottomSheetDialogFragment

abstract class MyBaseBottomSheetDialogFragment : BaseBottomSheetDialogFragment() {

    protected open fun setupWindowInsets() {}
}
package com.mobile.app.cash.core.common

import androidx.core.view.isVisible
import com.mobile.app.cash.views.databinding.CashCommonEmptyBinding
import com.mobile.guava.android.mvvm.lifecycle.SimplePresenter

class CommonEmptyPresenter(
    private val binding: CashCommonEmptyBinding,
    private val onClick: (() -> Unit)? = null
) : SimplePresenter() {

    init {
        if (null != onClick) {
            binding.root.setOnClickListener { onClick?.invoke() }
        }
    }

    fun hide() {
        binding.root.isVisible = false
    }

    fun progress(msg: String = "") {
        binding.txtError.text = msg
        binding.root.isVisible = true
    }

    fun error(msg: String) {
        binding.txtError.text = msg
        binding.root.isVisible = true
    }
}
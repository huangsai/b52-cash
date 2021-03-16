package com.mobile.app.cash.main.zygote

import com.mobile.app.cash.core.MyViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MainViewModel @Inject constructor() : MyViewModel() {

    private val _isSplashed = MutableStateFlow(false)
    val isSplashed: StateFlow<Boolean> get() = _isSplashed

    fun setIsSplashed(isSplashed: Boolean) {
        _isSplashed.value = isSplashed
    }
}
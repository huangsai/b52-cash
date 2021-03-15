package com.mobile.app.cash.main.zygote

import com.mobile.app.cash.core.MyViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : MyViewModel() {

    private val _selectedPageIndex = MutableStateFlow(0)
    val selectedPageIndex: StateFlow<Int> get() = _selectedPageIndex

    fun setSelectedPageIndex(selectedPageIndex: Int) {
        _selectedPageIndex.value = selectedPageIndex
    }
}
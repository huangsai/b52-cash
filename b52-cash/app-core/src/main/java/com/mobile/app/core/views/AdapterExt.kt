package com.mobile.app.core.views

import com.pacific.adapter.AdapterUtils
import com.pacific.adapter.BaseRecyclerAdapter
import com.pacific.adapter.RecyclerItem

fun swapIsSelected(
    unselectedPosition: Int,
    selectedPosition: Int,
    adapter: BaseRecyclerAdapter<RecyclerItem>
) {
    if (unselectedPosition == -1 && selectedPosition == -1) {
        return
    }
    require(selectedPosition >= 0 && selectedPosition < adapter.itemCount)
    if (unselectedPosition == selectedPosition) {
        val item = adapter.get<RecyclerItem>(unselectedPosition)
        item.isSelected = !item.isSelected
        adapter.notifyItemChanged(unselectedPosition, AdapterUtils.ADAPTER_SELECTED)
    } else {
        if (unselectedPosition >= 0) {
            adapter.get<RecyclerItem>(unselectedPosition).isSelected = false
            adapter.notifyItemChanged(unselectedPosition, AdapterUtils.ADAPTER_SELECTED)
        }
        adapter.get<RecyclerItem>(selectedPosition).isSelected = true
        adapter.notifyItemChanged(selectedPosition, AdapterUtils.ADAPTER_SELECTED)
    }
}

fun swapIsEnable(
    disablePosition: Int,
    enablePosition: Int,
    adapter: BaseRecyclerAdapter<RecyclerItem>
) {
    if (disablePosition == -1 && enablePosition == -1) {
        return
    }
    require(enablePosition >= 0 && enablePosition < adapter.itemCount)
    if (disablePosition == enablePosition) {
        val item = adapter.get<RecyclerItem>(disablePosition)
        item.isSelected = !item.isSelected
        adapter.notifyItemChanged(disablePosition, AdapterUtils.ADAPTER_SELECTED)
    } else {
        if (disablePosition >= 0) {
            adapter.get<RecyclerItem>(disablePosition).isEnable = false
            adapter.notifyItemChanged(disablePosition, AdapterUtils.ADAPTER_ENABLE)
        }
        adapter.get<RecyclerItem>(enablePosition).isEnable = true
        adapter.notifyItemChanged(enablePosition, AdapterUtils.ADAPTER_ENABLE)
    }
}
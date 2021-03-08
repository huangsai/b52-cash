package com.mobile.app.core.views

import android.transition.TransitionManager
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.ImageView
import android.widget.ScrollView
import androidx.core.widget.NestedScrollView

fun ScrollView.scrollToBottom() {
    val lastChild = getChildAt(childCount - 1)
    val bottom = lastChild.bottom + paddingBottom
    val delta = bottom - (scrollY + height)
    smoothScrollBy(0, delta)
}

fun NestedScrollView.scrollToBottom() {
    val lastChild = getChildAt(childCount - 1)
    val bottom = lastChild.bottom + paddingBottom
    val delta = bottom - (scrollY + height)
    smoothScrollBy(0, delta)
}

fun ImageView.animRotate(degrees: Float) {
    TransitionManager.beginDelayedTransition(this.parent as ViewGroup, Rotate())
    this.rotation = degrees
}

fun WebView.applyCommonSetting() {
    with(this.settings) {
        builtInZoomControls = false
        setSupportZoom(false)
        domStorageEnabled = true
        displayZoomControls = false
        useWideViewPort = true
        javaScriptEnabled = true
        loadWithOverviewMode = true
        cacheMode = WebSettings.LOAD_DEFAULT
        mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
    }
}
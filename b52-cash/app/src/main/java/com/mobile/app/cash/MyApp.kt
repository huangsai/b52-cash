package com.mobile.app.cash

import androidx.multidex.MultiDexApplication
import com.mobile.app.cash.core.CoreX

class MyApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        CoreX.setup(this, BuildConfig.DEBUG)
    }
}
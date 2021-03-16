package com.mobile.app.cash.main

import com.mobile.app.cash.main.dagger.DaggerMainComponent
import com.mobile.app.cash.main.dagger.MainComponent
import com.mobile.app.cash.store.StoreX

object MainX {

    val component: MainComponent by lazy {
       DaggerMainComponent.factory().create(
            StoreX.component
        )
    }
}
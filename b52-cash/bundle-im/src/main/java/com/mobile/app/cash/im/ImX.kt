package com.mobile.app.cash.im

import com.mobile.app.cash.im.dagger.ImComponent
import com.mobile.app.cash.im.dagger.DaggerImComponent
import com.mobile.app.cash.store.StoreX

object ImX {

    val component: ImComponent by lazy {
        DaggerImComponent.factory().create(
            StoreX.component
        )
    }
}
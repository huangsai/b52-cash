package com.mobile.app.cash.auth

import com.mobile.app.cash.auth.dagger.AuthComponent
import com.mobile.app.cash.auth.dagger.DaggerAuthComponent
import com.mobile.app.cash.store.StoreX

object AuthX {

    val component: AuthComponent by lazy {
        DaggerAuthComponent.factory().create(
            StoreX.component
        )
    }
}
package com.mobile.app.store

import com.mobile.app.store.db.PlatformDatabase
import com.mobile.app.store.file.PlatformPrefs
import com.mobile.guava.data.PlatformContext
import com.mobile.app.store.dagger.StoreComponent
import com.mobile.app.store.dagger.DaggerStoreComponent

object StoreX {

    const val HTTP_CODE_LOGGED_OUT = -1

    val HTTP_SERVERS: Map<Int, String> = mapOf(
        100 to "https://www.google.com.hk/",// alpha
        200 to "https://www.google.com.hk/",// beta
        300 to "https://www.google.com.hk/"// release
    )

    lateinit var component: StoreComponent
        private set

    fun setup(
        platformDatabase: PlatformDatabase,
        platformContext: PlatformContext,
        platformPrefs: PlatformPrefs
    ) {
        if (::component.isInitialized) {
            return
        }

        platformPrefs.flavorId = 100
        component = DaggerStoreComponent.factory().create(
            platformDatabase,
            platformContext,
            platformPrefs
        )
    }
}
package com.mobile.app.cash.store

import com.mobile.app.cash.store.dagger.DaggerStoreComponent
import com.mobile.app.cash.store.dagger.StoreComponent
import com.mobile.app.cash.store.db.PlatformDatabase
import com.mobile.app.cash.store.file.PlatformPrefs
import com.mobile.guava.data.PlatformContext
import kotlin.math.abs

object StoreX {

    const val HTTP_CODE_LOGGED_OUT = -1
    const val FLAVOR_ALPHA = 100
    const val FLAVOR_BETA = 200
    const val FLAVOR_RELEASE = 300
    const val FLAVOR_RELEASE_FINAL = -300

    val HTTP_SERVERS: Map<Int, String> = mapOf(
        FLAVOR_ALPHA to "https://www.google.com.hk/",// alpha
        FLAVOR_BETA to "https://www.google.com.hk/",// beta
        FLAVOR_RELEASE to "https://www.google.com.hk/",// release
        FLAVOR_RELEASE_FINAL to "https://www.google.com.hk/"// release
    )

    lateinit var component: StoreComponent
        private set

    fun setup(
        platformDatabase: PlatformDatabase,
        platformContext: PlatformContext,
        platformPrefs: PlatformPrefs
    ) {
        if (StoreX::component.isInitialized) {
            return
        }

        if (abs(platformPrefs.flavorId) < 100) {
            platformPrefs.flavorId = FLAVOR_ALPHA
        }

        component = DaggerStoreComponent.factory().create(
            platformDatabase,
            platformContext,
            platformPrefs
        )
    }
}
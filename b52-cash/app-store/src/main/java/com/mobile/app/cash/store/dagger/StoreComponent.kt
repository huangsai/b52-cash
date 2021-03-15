package com.mobile.app.cash.store.dagger

import com.mobile.app.cash.store.db.PlatformDatabase
import com.mobile.app.cash.store.file.PlatformPrefs
import com.mobile.app.cash.store.http.service.DataService
import com.mobile.app.cash.store.repository.UserRepository
import com.mobile.guava.data.DataComponent
import com.mobile.guava.data.PlatformContext
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        StoreModule::class
    ]
)
@Singleton
interface StoreComponent : DataComponent {

    fun dataService(): DataService

    fun platformDatabase(): PlatformDatabase

    fun platformPrefs(): PlatformPrefs

    fun userRepository(): UserRepository

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance platformDatabase: PlatformDatabase,
            @BindsInstance platformContext: PlatformContext,
            @BindsInstance platformPrefs: PlatformPrefs
        ): StoreComponent
    }
}
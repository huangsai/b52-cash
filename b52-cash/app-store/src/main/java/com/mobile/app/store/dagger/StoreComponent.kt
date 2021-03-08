package com.mobile.app.store.dagger

import com.mobile.app.store.db.PlatformDatabase
import com.mobile.app.store.file.PlatformPrefs
import com.mobile.app.store.http.service.DataService
import com.mobile.app.store.repository.UserRepository
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
package com.mobile.app.cash.core

import android.app.Application
import androidx.room.Room
import com.airbnb.mvrx.Mavericks
import com.mobile.app.cash.core.base.AppDatabase
import com.mobile.app.cash.core.base.AppPrefs
import com.mobile.app.cash.core.base.BugTree
import com.mobile.app.cash.core.dagger.CoreComponent
import com.mobile.app.cash.store.StoreX
import com.mobile.guava.android.context.AppUtils
import com.mobile.guava.android.mvvm.AndroidX
import com.mobile.guava.android.mvvm.AppContext
import com.mobile.guava.android.mvvm.AppManager
import timber.log.Timber

object CoreX {

    val PROVIDER_AUTHORITY by lazy {
        AppUtils.getPackageName(AndroidX.myApp) + ".fileProvider"
    }

    lateinit var component: CoreComponent
        private set

    fun setup(
        app: Application,
        coreComponent: CoreComponent,
        isDebug: Boolean
    ) {
        if (isDebug) {
        } else {
            Timber.plant(BugTree())
        }

        component = coreComponent
        AndroidX.setup(app, isDebug)
        StoreX.setup(createAppDatabase(), AppContext(), AppPrefs)

        AppManager.initialize()
        Mavericks.initialize(app)
    }

    private fun createAppDatabase(): AppDatabase {
        return Room.databaseBuilder(AndroidX.myApp, AppDatabase::class.java, "coreX_v1.db3")
            .addCallback(AppDatabase.DbCallback())
            .addMigrations(AppDatabase.DbMigration(1, 1))
            .build()
    }
}
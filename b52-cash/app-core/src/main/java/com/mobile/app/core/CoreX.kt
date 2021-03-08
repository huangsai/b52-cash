package com.mobile.app.core

import android.app.Application
import androidx.room.Room
import com.mobile.app.core.base.AppDatabase
import com.mobile.app.core.base.AppPrefs
import com.mobile.app.core.base.BugTree
import com.mobile.app.store.StoreX
import com.mobile.guava.android.context.AppUtils
import com.mobile.guava.android.mvvm.AndroidX
import com.mobile.guava.android.mvvm.AppContext
import com.mobile.guava.android.mvvm.AppManager
import timber.log.Timber

object CoreX {

    val PROVIDER_AUTHORITY by lazy {
        AppUtils.getPackageName(AndroidX.myApp) + ".fileProvider"
    }

    fun setup(app: Application, isDebug: Boolean) {
        if (isDebug) {
        } else {
            Timber.plant(BugTree())
        }
        AndroidX.setup(app, isDebug)
        StoreX.setup(createAppDatabase(), AppContext(), AppPrefs)

        AppManager.initialize()
    }

    private fun createAppDatabase(): AppDatabase {
        return Room.databaseBuilder(AndroidX.myApp, AppDatabase::class.java, "coreX_v1.db3")
            .addCallback(AppDatabase.DbCallback())
            .addMigrations(AppDatabase.DbMigration(1, 1))
            .build()
    }
}
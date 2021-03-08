package com.mobile.app.store.repository

import com.mobile.app.store.dagger.StoreComponent
import com.mobile.app.store.db.PlatformDatabase
import com.mobile.app.store.file.PlatformPrefs
import com.mobile.app.store.http.service.DataService
import com.mobile.guava.data.PlatformContext
import com.mobile.guava.jvm.Guava
import com.mobile.guava.jvm.domain.Source

abstract class BaseRepository(
    protected val service: DataService,
    protected val database: PlatformDatabase,
    protected val context: PlatformContext,
    protected val prefs: PlatformPrefs,
    protected val component: StoreComponent
) {

    protected fun <T> errorSource(e: Throwable): Source<T> {
        Guava.timber.d(e)
        return Source.Error(e)
    }
}
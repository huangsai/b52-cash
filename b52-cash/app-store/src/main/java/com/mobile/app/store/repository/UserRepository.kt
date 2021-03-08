package com.mobile.app.store.repository

import com.mobile.app.store.dagger.StoreComponent
import com.mobile.app.store.db.PlatformDatabase
import com.mobile.app.store.file.PlatformPrefs
import com.mobile.app.store.http.service.DataService
import com.mobile.guava.data.PlatformContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    service: DataService,
    database: PlatformDatabase,
    context: PlatformContext,
    prefs: PlatformPrefs,
    component: StoreComponent
) : BaseRepository(service, database, context, prefs, component) {

}
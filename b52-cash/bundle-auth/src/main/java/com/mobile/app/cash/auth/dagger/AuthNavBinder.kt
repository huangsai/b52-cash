package com.mobile.app.cash.auth.dagger

import com.mobile.app.cash.auth.AuthActivity
import com.mobile.app.cash.core.dagger.IntentResolverKey
import com.mobile.app.cash.core.navigation.IntentKey
import com.mobile.app.cash.core.navigation.IntentResolver
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class AuthNavBinder {

    @Provides
    @IntoMap
    @IntentResolverKey(IntentKey.AuthActivity::class)
    fun provideAuthActivity(): IntentResolver<*> {
        return AuthActivity.Companion
    }
}
package com.mobile.app.cash.main.dagger

import com.mobile.app.cash.core.dagger.FragmentResolverKey
import com.mobile.app.cash.core.dagger.IntentResolverKey
import com.mobile.app.cash.core.navigation.FragmentKey
import com.mobile.app.cash.core.navigation.FragmentResolver
import com.mobile.app.cash.core.navigation.IntentKey
import com.mobile.app.cash.core.navigation.IntentResolver
import com.mobile.app.cash.main.zygote.MainActivity
import com.mobile.app.cash.main.zygote.SplashDialogFragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class MainNavBinder {

    @Provides
    @IntoMap
    @IntentResolverKey(IntentKey.MainActivity::class)
    fun provideMainActivity(): IntentResolver<*> {
        return MainActivity
    }

    @Provides
    @IntoMap
    @FragmentResolverKey(FragmentKey.SplashDialogFragment::class)
    fun provideSplashDialogFragment(): FragmentResolver<*> {
        return SplashDialogFragment
    }
}
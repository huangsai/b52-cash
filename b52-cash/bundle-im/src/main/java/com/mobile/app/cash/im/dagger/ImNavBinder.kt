package com.mobile.app.cash.im.dagger

import com.mobile.app.cash.core.dagger.FragmentResolverKey
import com.mobile.app.cash.core.navigation.FragmentKey
import com.mobile.app.cash.core.navigation.FragmentResolver
import com.mobile.app.cash.im.ImFragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ImNavBinder {

    @Provides
    @IntoMap
    @FragmentResolverKey(FragmentKey.ImFragment::class)
    fun provideImFragment(): FragmentResolver<*> {
        return ImFragment.Companion
    }
}
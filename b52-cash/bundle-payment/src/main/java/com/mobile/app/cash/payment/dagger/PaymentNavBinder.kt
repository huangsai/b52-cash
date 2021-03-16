package com.mobile.app.cash.payment.dagger

import com.mobile.app.cash.core.dagger.FragmentResolverKey
import com.mobile.app.cash.core.navigation.FragmentKey
import com.mobile.app.cash.core.navigation.FragmentResolver
import com.mobile.app.cash.payment.game.GameWalletFragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class PaymentNavBinder {

    @Provides
    @IntoMap
    @FragmentResolverKey(FragmentKey.GameWalletFragment::class)
    fun provideGameWalletFragment(): FragmentResolver<*> {
        return GameWalletFragment.Companion
    }
}
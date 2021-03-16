package com.mobile.app.cash.payment.dagger

import androidx.lifecycle.ViewModel
import com.mobile.app.cash.payment.game.GameWalletModel
import com.mobile.guava.android.mvvm.dagger.FeatureScopeViewModelFactoryBinder
import com.mobile.guava.android.mvvm.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [FeatureScopeViewModelFactoryBinder::class])
abstract class PaymentBinder {

    @Binds
    @IntoMap
    @ViewModelKey(GameWalletModel::class)
    abstract fun bindGameWalletModel(it: GameWalletModel): ViewModel
}
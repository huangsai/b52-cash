package com.mobile.app.cash.im.dagger

import androidx.lifecycle.ViewModel
import com.mobile.app.cash.im.ImViewModel
import com.mobile.guava.android.mvvm.dagger.FeatureScopeViewModelFactoryBinder
import com.mobile.guava.android.mvvm.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [FeatureScopeViewModelFactoryBinder::class])
abstract class ImBinder {

    @Binds
    @IntoMap
    @ViewModelKey(ImViewModel::class)
    abstract fun bindImViewModel(it: ImViewModel): ViewModel
}
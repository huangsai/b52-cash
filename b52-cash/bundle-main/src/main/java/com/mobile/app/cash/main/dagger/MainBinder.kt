package com.mobile.app.cash.main.dagger

import androidx.lifecycle.ViewModel
import com.mobile.app.cash.main.zygote.MainViewModel
import com.mobile.guava.android.mvvm.dagger.FeatureScopeViewModelFactoryBinder
import com.mobile.guava.android.mvvm.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [FeatureScopeViewModelFactoryBinder::class])
abstract class MainBinder {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(it: MainViewModel): ViewModel
}
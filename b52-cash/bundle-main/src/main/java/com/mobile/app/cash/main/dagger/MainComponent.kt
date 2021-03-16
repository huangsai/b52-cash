package com.mobile.app.cash.main.dagger

import com.mobile.app.cash.store.dagger.StoreComponent
import com.mobile.guava.android.mvvm.dagger.FeatureScope
import com.mobile.guava.android.mvvm.dagger.ViewModelFactoryComponent
import dagger.Component

@Component(
    modules = [MainBinder::class],
    dependencies = [StoreComponent::class]
)
@FeatureScope
interface MainComponent : ViewModelFactoryComponent {

    @Component.Factory
    interface Factory {

        fun create(storeComponent: StoreComponent): MainComponent
    }
}
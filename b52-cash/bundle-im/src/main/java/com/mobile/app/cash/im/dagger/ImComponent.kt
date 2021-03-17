package com.mobile.app.cash.im.dagger

import com.mobile.app.cash.store.dagger.StoreComponent
import com.mobile.guava.android.mvvm.dagger.FeatureScope
import com.mobile.guava.android.mvvm.dagger.ViewModelFactoryComponent
import dagger.Component

@Component(
    modules = [ImBinder::class],
    dependencies = [StoreComponent::class]
)
@FeatureScope
interface ImComponent : ViewModelFactoryComponent {

    @Component.Factory
    interface Factory {

        fun create(storeComponent: StoreComponent): ImComponent
    }
}
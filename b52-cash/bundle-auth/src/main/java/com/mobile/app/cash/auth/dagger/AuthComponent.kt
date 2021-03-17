package com.mobile.app.cash.auth.dagger

import com.mobile.app.cash.store.dagger.StoreComponent
import com.mobile.guava.android.mvvm.dagger.FeatureScope
import com.mobile.guava.android.mvvm.dagger.ViewModelFactoryComponent
import dagger.Component

@Component(
    modules = [AuthBinder::class],
    dependencies = [StoreComponent::class]
)
@FeatureScope
interface AuthComponent : ViewModelFactoryComponent {

    @Component.Factory
    interface Factory {

        fun create(storeComponent: StoreComponent): AuthComponent
    }
}
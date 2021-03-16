package com.mobile.app.cash.payment.dagger

import com.mobile.app.cash.store.dagger.StoreComponent
import com.mobile.guava.android.mvvm.dagger.FeatureScope
import com.mobile.guava.android.mvvm.dagger.ViewModelFactoryComponent
import dagger.Component

@Component(
    modules = [PaymentBinder::class],
    dependencies = [StoreComponent::class]
)
@FeatureScope
interface PaymentComponent : ViewModelFactoryComponent {

    @Component.Factory
    interface Factory {

        fun create(storeComponent: StoreComponent): PaymentComponent
    }
}
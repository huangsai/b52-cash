package com.mobile.app.cash

import com.mobile.app.cash.auth.dagger.AuthNavBinder
import com.mobile.app.cash.core.dagger.CoreComponent
import com.mobile.app.cash.im.dagger.ImNavBinder
import com.mobile.app.cash.main.dagger.MainNavBinder
import com.mobile.app.cash.payment.dagger.PaymentNavBinder
import com.mobile.guava.android.mvvm.dagger.AppScope
import dagger.Component

@Component(
    modules = [
        MainNavBinder::class,
        PaymentNavBinder::class,
        AuthNavBinder::class,
        ImNavBinder::class
    ]
)
@AppScope
interface AppComponent : CoreComponent {

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}
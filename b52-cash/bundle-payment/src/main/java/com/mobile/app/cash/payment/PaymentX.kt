package com.mobile.app.cash.payment

import com.mobile.app.cash.payment.dagger.PaymentComponent
import com.mobile.app.cash.payment.dagger.DaggerPaymentComponent
import com.mobile.app.cash.store.StoreX

object PaymentX {

    val component: PaymentComponent by lazy {
        DaggerPaymentComponent.factory().create(
            StoreX.component
        )
    }
}
package com.mobile.app.cash.core.navigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class IntentKey {

    @Parcelize
    class MainActivity(val id: Long) : IntentKey(), Parcelable
}
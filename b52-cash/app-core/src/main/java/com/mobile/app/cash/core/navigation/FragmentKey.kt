package com.mobile.app.cash.core.navigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class FragmentKey {

    @Parcelize
    class SplashDialogFragment(val id: Long) : FragmentKey(), Parcelable

    @Parcelize
    class GameWalletFragment(val position: Int) : FragmentKey(), Parcelable

    @Parcelize
    class ImFragment(val position: Int) : FragmentKey(), Parcelable
}
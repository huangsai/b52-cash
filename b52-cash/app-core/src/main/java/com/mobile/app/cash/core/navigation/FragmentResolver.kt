package com.mobile.app.cash.core.navigation

import androidx.fragment.app.Fragment

interface FragmentResolver<in keyT : FragmentKey> {

    fun getFragment(key: keyT): Fragment
}
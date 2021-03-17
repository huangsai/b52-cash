package com.mobile.app.cash.im

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mobile.app.cash.core.MyBaseFragment
import com.mobile.app.cash.core.navigation.FragmentKey
import com.mobile.app.cash.core.navigation.FragmentResolver
import com.mobile.app.cash.core.navigation.MainActivityFragmentApi

class ImFragment : MyBaseFragment(), MainActivityFragmentApi {


    companion object : FragmentResolver<FragmentKey.ImFragment> {

        override fun getFragment(key: FragmentKey.ImFragment): ImFragment {
            return ImFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("key", key)
                }
            }
        }
    }
}
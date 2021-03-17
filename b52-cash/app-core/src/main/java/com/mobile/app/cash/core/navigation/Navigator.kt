package com.mobile.app.cash.core.navigation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mobile.guava.android.mvvm.dagger.AppScope
import javax.inject.Inject
import javax.inject.Provider

@AppScope
class Navigator @Inject constructor(
    @JvmSuppressWildcards
    private val intentMap: MutableMap<Class<out IntentKey>, Provider<IntentResolver<*>>>,
    @JvmSuppressWildcards
    private val fragmentMap: MutableMap<Class<out FragmentKey>, Provider<FragmentResolver<*>>>
) {

    @Suppress("UNCHECKED_CAST")
    fun createIntent(context: Context, key: IntentKey): Intent {
        val resolver = intentMap[key::class.java]?.get() as IntentResolver<IntentKey>?
        return resolver?.getIntent(context, key) ?: throw IllegalStateException(
            "Cannot resolve key $key"
        )
    }

    @Suppress("UNCHECKED_CAST")
    fun createFragment(key: FragmentKey): Fragment {
        val resolver = fragmentMap[key::class.java]?.get() as FragmentResolver<FragmentKey>?
        return resolver?.getFragment(key) ?: throw IllegalStateException(
            "Cannot resolve key $key"
        )
    }

    @Suppress("UNCHECKED_CAST")
    fun createDialogFragment(key: FragmentKey): AppCompatDialogFragment {
        return createFragment(key) as AppCompatDialogFragment
    }

    @Suppress("UNCHECKED_CAST")
    fun createBottomSheetDialogFragment(key: FragmentKey): BottomSheetDialogFragment {
        return createFragment(key) as BottomSheetDialogFragment
    }
}
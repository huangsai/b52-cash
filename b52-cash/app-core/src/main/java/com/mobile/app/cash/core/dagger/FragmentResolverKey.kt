package com.mobile.app.cash.core.dagger

import com.mobile.app.cash.core.navigation.FragmentKey
import dagger.MapKey
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class FragmentResolverKey(val value: KClass<out FragmentKey>)

package com.mobile.app.cash.core.dagger

import com.mobile.app.cash.core.navigation.IntentKey
import dagger.MapKey
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class IntentResolverKey(val value: KClass<out IntentKey>)

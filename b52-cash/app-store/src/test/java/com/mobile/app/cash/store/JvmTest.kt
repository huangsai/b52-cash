package com.mobile.app.cash.store

import com.google.common.truth.Truth
import com.mobile.guava.jvm.Guava
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.AfterTest
import kotlin.test.BeforeTest

@RunWith(MockitoJUnitRunner::class)
class JvmTest {

    @BeforeTest
    fun beforeTest() {
        Guava.isDebug = true
        StoreX.setup(TestDatabase, TestContext, TestPrefs)
    }

    @Test
    fun test() {
        Truth.assertThat(StoreX.component).isNotNull()
        Truth.assertThat(StoreX.component.platformPrefs()).isEqualTo(TestPrefs)
        Truth.assertThat(StoreX.component.platformDatabase()).isEqualTo(TestDatabase)
        Truth.assertThat(StoreX.component.platformContext()).isEqualTo(TestContext)
    }

    @AfterTest
    fun afterTest() {
    }
}
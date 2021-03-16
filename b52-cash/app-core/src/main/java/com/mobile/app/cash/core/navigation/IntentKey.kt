package com.mobile.app.cash.core.navigation

sealed class IntentKey {

    class MainActivity(val id: Long) : IntentKey()
}
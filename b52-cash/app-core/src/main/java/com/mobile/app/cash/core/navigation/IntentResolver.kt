package com.mobile.app.cash.core.navigation

import android.content.Context
import android.content.Intent

interface IntentResolver<in keyT : IntentKey> {

    fun getIntent(context: Context, key: keyT): Intent
}
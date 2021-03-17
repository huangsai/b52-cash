package com.mobile.app.cash.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.mobile.app.cash.core.MyBaseActivity
import com.mobile.app.cash.core.navigation.IntentKey
import com.mobile.app.cash.core.navigation.IntentResolver
import com.mobile.app.cash.views.databinding.CashActivityAuthBinding

class AuthActivity : MyBaseActivity() {

    private lateinit var binding: CashActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)
        binding = CashActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object : IntentResolver<IntentKey.AuthActivity> {

        override fun getIntent(context: Context, key: IntentKey.AuthActivity): Intent {
            return Intent(context, AuthActivity::class.java)
        }
    }
}
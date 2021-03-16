package com.mobile.app.cash.main.zygote

import android.Manifest
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobile.app.cash.core.MyBaseActivity
import com.mobile.app.cash.main.R
import com.mobile.app.cash.views.databinding.CashActivityMainBinding
import com.mobile.guava.android.mvvm.AndroidX
import com.mobile.guava.android.mvvm.requestMultiplePermissions
import dev.chrisbanes.insetter.Insetter
import dev.chrisbanes.insetter.Side
import dev.chrisbanes.insetter.windowInsetTypesOf

class MainActivity : MyBaseActivity(R.layout.cash_activity_main) {

    private lateinit var binding: CashActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val neededPermissions = arrayOf(
        Manifest.permission.READ_PHONE_STATE
    )

    private val permissionLauncher = registerForActivityResult(
        requestMultiplePermissions
    ) {
        var hasNeededPermission = true
        it.forEach { (t, u) ->
            if (!u) {
                hasNeededPermission = false
            }
        }
        if (hasNeededPermission) {
            setup()
        } else {
            withoutPermission()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = CashActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupWindowInsets()

        permissionLauncher.launch(neededPermissions)
    }

    /**
     * 沉浸式处理系统控件边界
     */
    override fun setupWindowInsets() {
        Insetter.builder()
            .padding(
                windowInsetTypesOf(ime = true, statusBars = true, navigationBars = true),
                Side.LEFT or Side.RIGHT
            )
            .applyToView(binding.root)
    }

    /**
     * 所有条件具备后，开始初始化界面
     */
    private fun setup() {
    }

    /**
     * 当必要权限没有得倒授权，强制退出APP
     */
    private fun withoutPermission() {
        MaterialAlertDialogBuilder(this, R.style.cash_CommonAlertDialog)
            .setCancelable(false)
            .setTitle(R.string.cash_common_alert_title)
            .setMessage(R.string.cash_common_alert_without_permission)
            .setPositiveButton(
                R.string.alert_known
            ) { dialog, _ ->
                dialog.dismiss()
                AndroidX.exitSystem()
                android.os.Process.killProcess(android.os.Process.myPid())
            }
            .show()
    }
}
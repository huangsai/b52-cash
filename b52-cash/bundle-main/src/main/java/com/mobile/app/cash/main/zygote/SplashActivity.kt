package com.mobile.app.cash.main.zygote

import android.Manifest
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobile.app.cash.core.MyBaseActivity
import com.mobile.app.cash.core.common.CommonEmptyPresenter
import com.mobile.app.cash.core.views.ZoomOutPageTransformer
import com.mobile.app.cash.main.MainX
import com.mobile.app.cash.main.R
import com.mobile.app.cash.views.databinding.CashActivitySplashBinding
import com.mobile.guava.android.context.toColor
import com.mobile.guava.android.mvvm.AndroidX
import com.mobile.guava.android.mvvm.newStartActivity
import com.mobile.guava.android.mvvm.requestMultiplePermissions
import com.pacific.adapter.RecyclerAdapter

/**
 * APP启动页
 */
class SplashActivity : MyBaseActivity() {

    private val adapter = RecyclerAdapter()

    private lateinit var binding: CashActivitySplashBinding
    private lateinit var commonEmptyPresenter: CommonEmptyPresenter

    private var timer: MyTimer? = null

    private val viewModel: SplashViewModel by viewModels {
        MainX.component.viewModelFactory()
    }

    private val neededPermissions = arrayOf(
        Manifest.permission.READ_PHONE_STATE
    )

    private val permissionLauncher = registerForActivityResult(requestMultiplePermissions) {
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

    private val onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.navigationBarColor = toColor(R.color.cash_status_bar)

        super.onCreate(savedInstanceState)
        binding = CashActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        commonEmptyPresenter = CommonEmptyPresenter(binding.layoutEmpty)
        commonEmptyPresenter.progress()

        permissionLauncher.launch(neededPermissions)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }

    private fun setup() {
        binding.viewPager.registerOnPageChangeCallback(onPageChangeCallback)
        binding.viewPager.offscreenPageLimit = 1
        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())
        binding.viewPager.adapter = adapter
        requestAd()
    }

    private fun requestAd() {
        timer = MyTimer()
        timer!!.start()
    }

    private fun requestUser() {
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

    private inner class MyTimer : CountDownTimer(3000L, 1000L) {

        override fun onTick(millisUntilFinished: Long) {
            val sSrc = "广告时间：${(millisUntilFinished / 1000L + 1)}"
            binding?.txtTimer?.text = sSrc
        }

        override fun onFinish() {
            newStartActivity(MainActivity::class.java)
            finish()
        }
    }
}

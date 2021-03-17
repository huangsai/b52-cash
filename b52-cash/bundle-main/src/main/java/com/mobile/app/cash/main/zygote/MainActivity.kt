package com.mobile.app.cash.main.zygote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.mobile.app.cash.core.CoreX
import com.mobile.app.cash.core.MyBaseActivity
import com.mobile.app.cash.core.navigation.FragmentKey
import com.mobile.app.cash.core.navigation.IntentKey
import com.mobile.app.cash.core.navigation.IntentResolver
import com.mobile.app.cash.core.navigation.MainActivityApi
import com.mobile.app.cash.core.views.ZoomOutPageTransformer
import com.mobile.app.cash.main.MainX
import com.mobile.app.cash.views.databinding.CashActivityMainBinding
import dev.chrisbanes.insetter.Insetter
import dev.chrisbanes.insetter.Side
import dev.chrisbanes.insetter.windowInsetTypesOf

/**
 * APP首页
 */
class MainActivity : MyBaseActivity(), MainActivityApi {

    private lateinit var binding: CashActivityMainBinding

    private val viewModel: MainViewModel by viewModels {
        MainX.component.viewModelFactory()
    }

    private val onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)
        binding = CashActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupWindowInsets()

        binding.viewPager.registerOnPageChangeCallback(onPageChangeCallback)
        binding.viewPager.offscreenPageLimit = 10
        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())
        binding.viewPager.adapter = MyAdapter(this)
    }

    /**
     * 设置ViewPager2当前显示页
     */
    override fun setCurrentItem(position: Int) {
        binding.viewPager.setCurrentItem(position, false)
    }

    /**
     * 设置ViewPager2是否可以滚动
     */
    override fun setUserInputEnabled(enabled: Boolean) {
        binding.viewPager.isUserInputEnabled = enabled
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

    private class MyAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

        override fun getItemCount(): Int {
            return 5
        }

        override fun createFragment(position: Int): Fragment {
            return CoreX.component.navigator().createFragment(
                FragmentKey.GameWalletFragment(position)
            )
        }
    }

    companion object : IntentResolver<IntentKey.MainActivity> {

        override fun getIntent(context: Context, key: IntentKey.MainActivity): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}

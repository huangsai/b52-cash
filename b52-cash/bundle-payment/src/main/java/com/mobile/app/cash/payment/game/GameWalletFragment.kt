package com.mobile.app.cash.payment.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mobile.app.cash.core.MyBaseFragment
import com.mobile.app.cash.core.navigation.FragmentKey
import com.mobile.app.cash.core.navigation.FragmentResolver
import com.mobile.app.cash.payment.PaymentX
import com.mobile.app.cash.views.databinding.CashFragmentGameWalletBinding

/**
 * 游戏钱包
 */
class GameWalletFragment : MyBaseFragment() {

    private var _binding: CashFragmentGameWalletBinding? = null
    private val binding: CashFragmentGameWalletBinding get() = _binding!!

    private lateinit var key: FragmentKey.GameWalletFragment

    private val viewModel: GameWalletModel by viewModels {
        PaymentX.component.viewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        key = arguments?.getParcelable("key") ?: throw IllegalStateException("No key")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CashFragmentGameWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object : FragmentResolver<FragmentKey.GameWalletFragment> {

        override fun getFragment(key: FragmentKey.GameWalletFragment): Fragment {
            return GameWalletFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("key", key)
                }
            }
        }
    }
}
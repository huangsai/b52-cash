package com.mobile.app.cash.payment.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobile.app.cash.core.MyBaseFragment
import com.mobile.app.cash.payment.R
import com.mobile.app.cash.views.databinding.CashFragmentGameWalletBinding

/**
 * 游戏钱包
 */
class GameWalletFragment : MyBaseFragment(R.layout.cash_fragment_game_wallet) {

    private var _binding: CashFragmentGameWalletBinding? = null
    private val binding: CashFragmentGameWalletBinding get() = _binding!!

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
}
package com.mobile.app.cash.payment.block

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mobile.app.cash.core.MyBaseFragment
import com.mobile.app.cash.payment.R
import com.mobile.app.cash.views.databinding.CashFragmentBlockWalletBinding

/**
 * 区块钱包
 */
class BlockWalletFragment : MyBaseFragment() {

    private var _binding: CashFragmentBlockWalletBinding? = null
    private val binding: CashFragmentBlockWalletBinding get() = _binding!!

    private val viewModel: BlockWalletViewModel by viewModels(
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CashFragmentBlockWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
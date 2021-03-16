package com.mobile.app.cash.payment.buysell

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mobile.app.cash.core.MyBaseFragment
import com.mobile.app.cash.payment.R
import com.mobile.app.cash.views.databinding.CashFragmentBuySellBinding

/**
 * 买卖
 */
class BuySellFragment : MyBaseFragment(R.layout.cash_fragment_buy_sell) {

    private var _binding: CashFragmentBuySellBinding? = null
    private val binding: CashFragmentBuySellBinding get() = _binding!!

    private val viewModel: BuySellViewModel by viewModels(
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CashFragmentBuySellBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
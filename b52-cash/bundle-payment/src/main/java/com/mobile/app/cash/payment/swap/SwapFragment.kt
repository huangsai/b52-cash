package com.mobile.app.cash.payment.swap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mobile.app.cash.core.MyBaseFragment
import com.mobile.app.cash.views.databinding.CashFragmentSwapBinding

/**
 * 买卖
 */
class SwapFragment : MyBaseFragment() {

    private var _binding: CashFragmentSwapBinding? = null
    private val binding: CashFragmentSwapBinding get() = _binding!!

    private val viewModel: SwapViewModel by viewModels(
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CashFragmentSwapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
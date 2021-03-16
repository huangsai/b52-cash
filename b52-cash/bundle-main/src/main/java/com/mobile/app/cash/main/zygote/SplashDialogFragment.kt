package com.mobile.app.cash.main.zygote

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mobile.app.cash.core.MyBaseAppCompatDialogFragment
import com.mobile.app.cash.core.navigation.FragmentKey
import com.mobile.app.cash.core.navigation.FragmentResolver
import com.mobile.app.cash.views.R
import com.mobile.app.cash.views.databinding.CashFragmentSplashDialogBinding

class SplashDialogFragment : MyBaseAppCompatDialogFragment() {

    private var _binding: CashFragmentSplashDialogBinding? = null
    private val binding: CashFragmentSplashDialogBinding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    private var timer: MyTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.cash_SplashDialog)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).also {
            it.window?.let { sWindow ->
                sWindow.navigationBarColor = Color.TRANSPARENT
                WindowCompat.setDecorFitsSystemWindows(sWindow, false)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isCancelable = false
        _binding = CashFragmentSplashDialogBinding.inflate(inflater, container, false)

        timer = MyTimer()
        timer!!.start()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog!!.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        timer?.cancel()
    }

    private inner class MyTimer : CountDownTimer(3000L, 1000L) {

        override fun onTick(millisUntilFinished: Long) {
            _binding?.txtTimer?.text = (millisUntilFinished / 1000L + 1).toString()
        }

        override fun onFinish() {
            viewModel.setIsSplashed(true)
            dismiss()
        }
    }

    companion object : FragmentResolver<FragmentKey.SplashDialogFragment> {

        override fun getFragment(key: FragmentKey.SplashDialogFragment): Fragment {
            return SplashDialogFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("key", key)
                }
            }
        }
    }
}

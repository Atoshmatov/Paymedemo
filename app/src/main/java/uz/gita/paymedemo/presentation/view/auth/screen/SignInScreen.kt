package uz.gita.paymedemo.presentation.view.auth.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.paymedemo.NavGraphDirections
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenSigninBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.SignInViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.SignInViewModelImpl
import uz.gita.paymedemo.utils.addListener

@AndroidEntryPoint
class SignInScreen:Fragment(R.layout.screen_signin) {
    private val binding by viewBinding(ScreenSigninBinding::bind)
    private val viewModel: SignInViewModel by viewModels<SignInViewModelImpl>()
    private var shared: SharedPrefToken? = null
    private val args: SignInScreenArgs by navArgs()
    private var boolPhoneNumber = false
    private var boolPassword = false
    private var checked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        shared = SharedPrefToken(requireContext())
        listener()
        singInButton.setOnClickListener {
            viewModel.openScreen()
        }
        viewModel.openMainScreenLiveData.observe(this@SignInScreen, openMainScreenObserver)
    }

    //observer object
    private val openMainScreenObserver = Observer<Unit> {
        val action = NavGraphDirections.actionGlobalPinCodeScreen()
        findNavController().navigate(action)
        shared!!.id = 2
    }


    private fun listener() = with(binding) {
        numberSignIn.addListener {
            boolPhoneNumber =
                it.length == 17 && "\\+998[\\ 0-9]*\$".toRegex().matches(it) && it == args.number
            Timber.tag("QQQ").d(it)
            check()
        }
        passwordSignIn.addListener {
            boolPassword = (it.length in 5..8) && it == shared!!.password
            Timber.tag("QQQ").d(it)
            check()
        }
    }

    private fun check() {
        checked = boolPhoneNumber && boolPassword
        binding.singInButton.isEnabled = checked
        if (checked) {
            binding.singInButton.setTextColor(resources.getColor(R.color.white))
        } else {
            binding.singInButton.setTextColor(resources.getColor(R.color.hint_color))
        }
    }
}
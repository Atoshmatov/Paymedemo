package uz.gita.paymedemo.presentation.ui.auth.screen

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenSigninBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.SignInViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.SignInViewModelImpl
import uz.gita.paymedemo.utils.addListener

@AndroidEntryPoint
class SignInScreen : Fragment(R.layout.screen_signin) {
    private val binding by viewBinding(ScreenSigninBinding::bind)
    private val viewModel: SignInViewModel by viewModels<SignInViewModelImpl>()
    private var shared: SharedPrefToken? = null
    private var boolPhoneNumber = false
    private var boolPassword = false
    private var checked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openScreenLiveData.observe(this@SignInScreen, openMainScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        shared = SharedPrefToken(requireContext())
        listener()
        singInButton.setOnClickListener {
            viewModel.openScreen()
        }
    }

    //observer object
    private val openMainScreenObserver = Observer<Unit> {
        val navOption = NavOptions.Builder()
            .setPopUpTo(R.id.signUPScreen, true).build()
        findNavController().navigate(R.id.action_signInScreen_to_pinCodeNewScreen,  null,navOption)
        shared!!.id = 2
    }

    // function
    private fun listener() = with(binding) {
        numberSignIn.addListener {
            boolPhoneNumber =
                it.length == 17 && "\\+998[\\ 0-9]*\$".toRegex().matches(it)
            check()
        }
        passwordSignIn.addListener {
            boolPassword = (it.length in 5..8) && it == shared!!.password
            check()
        }
    }

    private fun check() {
        checked = boolPhoneNumber && boolPassword
        binding.singInButton.isEnabled = checked
        if (checked) {
            binding.singInButton.setTextColor(
                ContextCompat.getColor(
                    requireContext(), R.color.white
                )
            )
        } else {
            binding.singInButton.setTextColor(
                ContextCompat.getColor(
                    requireContext(), R.color.hint_color
                )
            )
        }
    }
}
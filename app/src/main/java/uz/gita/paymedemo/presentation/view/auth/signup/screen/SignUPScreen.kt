package uz.gita.paymedemo.presentation.view.auth.signup.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenSignupBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.signup.SignUpViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.signup.impl.SignUPViewModelImpl

@AndroidEntryPoint
class SignUPScreen : Fragment(R.layout.screen_signup) {
    private val binding by viewBinding(ScreenSignupBinding::bind)
    private val viewModel: SignUpViewModel by viewModels<SignUPViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}
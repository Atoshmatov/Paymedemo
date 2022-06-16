package uz.gita.paymedemo.presentation.viewmodel.auth.signin.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.signup.SignUpViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModelImpl @Inject constructor() : ViewModel(), SignUpViewModel {
}
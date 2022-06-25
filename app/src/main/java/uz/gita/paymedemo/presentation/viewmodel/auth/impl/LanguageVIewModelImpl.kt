package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.LanguageVIewModel
import javax.inject.Inject

@HiltViewModel
class LanguageVIewModelImpl @Inject constructor() : ViewModel(), LanguageVIewModel {
    override val openSignUpScreen = MutableLiveData<Unit>()

    override fun openSingUp() {
        openSignUpScreen.value = Unit
    }
}
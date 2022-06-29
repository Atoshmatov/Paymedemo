package uz.gita.paymedemo.presentation.viewmodel.auth

import androidx.lifecycle.LiveData

interface LanguageVIewModel {
    val openSignUpScreen: LiveData<Unit>
    val notConnectionLiveData: LiveData<Boolean>


    fun openSingUp()
}
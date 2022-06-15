package uz.gita.paymedemo.presentation.viewmodel.auth.language

import androidx.lifecycle.LiveData

interface LanguageVIewModel {
    val openSignUpScreen: LiveData<Unit>


    fun openSingUp()
}
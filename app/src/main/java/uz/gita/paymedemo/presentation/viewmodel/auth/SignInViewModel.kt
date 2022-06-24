package uz.gita.paymedemo.presentation.viewmodel.auth

import androidx.lifecycle.LiveData

interface SignInViewModel {
    val openMainScreenLiveData:LiveData<Unit>

    fun openScreen()
}
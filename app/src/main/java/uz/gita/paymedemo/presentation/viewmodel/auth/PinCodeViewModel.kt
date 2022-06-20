package uz.gita.paymedemo.presentation.viewmodel.auth

import androidx.lifecycle.LiveData

interface PinCodeViewModel {
    val openMainScreenLiveData: LiveData<Unit>

    fun openMainScreen()
}
package uz.gita.paymedemo.presentation.viewmodel.auth

import androidx.lifecycle.LiveData

interface PinCodeNewViewModel {
    val openMainScreenLiveData: LiveData<Unit>
    fun openMainScreen()
}
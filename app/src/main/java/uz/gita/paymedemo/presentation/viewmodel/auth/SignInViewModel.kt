package uz.gita.paymedemo.presentation.viewmodel.auth

import androidx.lifecycle.LiveData

interface SignInViewModel {
    val openScreenLiveData:LiveData<Unit>

    fun openScreen()
}
package uz.gita.paymedemo.presentation.viewmodel.auth

import androidx.lifecycle.LiveData
import uz.gita.paymedemo.data.remote.request.auth.VerifyRequest

interface VerifyVIewModel {
    val progressLiveDate: LiveData<Boolean>
    val notConnectionLiveData: LiveData<Unit>
    val errorLiveData: LiveData<String>
    val openPinCodeScreenLiveDate: LiveData<Unit>
    val backRegisterScreenLiveDate: LiveData<Unit>

    fun codeVerifyUser(data: VerifyRequest)
    fun backRegisterScreen()
}
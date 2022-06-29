package uz.gita.paymedemo.presentation.viewmodel.auth

import androidx.lifecycle.LiveData
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest

interface SignUpViewModel {
    val progressLiveData: LiveData<Boolean>
    val notConnectionLiveData: LiveData<Unit>
    val errorLiveData: LiveData<String>
    val openVerifyScreenLiveData: LiveData<Unit>
    val openSingInScreenLiveData: LiveData<Unit>

    fun registerUser(data: SignUpRequest)
    fun openSignInScreen()
}
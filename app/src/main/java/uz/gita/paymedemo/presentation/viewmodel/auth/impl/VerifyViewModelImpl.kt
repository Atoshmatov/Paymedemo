package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.paymedemo.data.remote.request.auth.VerifyRequest
import uz.gita.paymedemo.presentation.viewmodel.auth.VerifyVIewModel
import uz.gita.paymedemo.utils.isConnected
import javax.inject.Inject

@HiltViewModel
class VerifyViewModelImpl @Inject constructor() : ViewModel(), VerifyVIewModel {
    override val progressLiveDate = MutableLiveData<Boolean>()
    override val notConnectionLiveData = MutableLiveData<Unit>()
    override val errorLiveData = MutableLiveData<String>()
    override val openPinCodeScreenLiveDate = MutableLiveData<Unit>()
    override val backRegisterScreenLiveDate = MutableLiveData<Unit>()

    override fun codeVerifyUser(data: VerifyRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            if (!isConnected()) {
                openPinCodeScreenLiveDate.postValue(Unit)
                return@launch
            }
            progressLiveDate.postValue(true)
            openPinCodeScreenLiveDate.postValue(Unit)
        }
    }

    override fun backRegisterScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            backRegisterScreenLiveDate.postValue(Unit)
        }
    }

}
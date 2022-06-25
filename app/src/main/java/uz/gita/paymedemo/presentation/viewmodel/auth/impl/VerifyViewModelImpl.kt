package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.paymedemo.data.remote.request.auth.VerifyRequest
import uz.gita.paymedemo.domain.usecase.auth.VerifyUseCase
import uz.gita.paymedemo.presentation.viewmodel.auth.VerifyVIewModel
import uz.gita.paymedemo.utils.isConnected
import javax.inject.Inject

@HiltViewModel
class VerifyViewModelImpl @Inject constructor(
    private val verify: VerifyUseCase
) : ViewModel(), VerifyVIewModel {
    override val progressLiveDate = MutableLiveData<Boolean>()
    override val notConnectionLiveData = MutableLiveData<Unit>()
    override val errorLiveData = MutableLiveData<String>()
    override val openPinCodeScreenLiveDate = MutableLiveData<Unit>()
    override val backRegisterScreenLiveDate = MutableLiveData<Unit>()

    override fun codeVerifyUser(data: VerifyRequest) {
        if (!isConnected()) {
            notConnectionLiveData.value = Unit
            return
        }
        progressLiveDate.value = true
        verify.verifyCode(data).onEach {
            progressLiveDate.postValue(false)
            it.onSuccess {
                openPinCodeScreenLiveDate.postValue(Unit)
            }.onFailure {
                errorLiveData.postValue(it.message)
            }
        }.launchIn(viewModelScope)
    }

    override fun backRegisterScreen() {
        backRegisterScreenLiveDate.value = Unit
    }

}
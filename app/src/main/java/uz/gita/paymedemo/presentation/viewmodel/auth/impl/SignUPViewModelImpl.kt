package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest
import uz.gita.paymedemo.domain.usecase.auth.SignUpUseCase
import uz.gita.paymedemo.presentation.viewmodel.auth.SignUpViewModel
import uz.gita.paymedemo.utils.isConnected
import javax.inject.Inject


@HiltViewModel
class SignUPViewModelImpl
@Inject constructor(
    private val sign: SignUpUseCase
) : ViewModel(), SignUpViewModel {
    override val progressLiveData = MutableLiveData<Boolean>()
    override val notConnectionLiveData = MutableLiveData<Unit>()
    override val errorLiveData = MutableLiveData<String>()
    override val openVerifyScreenLiveData = MutableLiveData<Unit>()

    override fun registerUser(data: SignUpRequest) {
        if (!isConnected()) {
            notConnectionLiveData.value = Unit
            return
        }
        progressLiveData.value = true
        sign.registerUser(data).onEach {
            progressLiveData.postValue(false)
            it.onSuccess {
                openVerifyScreenLiveData.postValue(Unit)
            }.onFailure {
                errorLiveData.postValue(it.message)
            }
        }.launchIn(viewModelScope)
    }
}
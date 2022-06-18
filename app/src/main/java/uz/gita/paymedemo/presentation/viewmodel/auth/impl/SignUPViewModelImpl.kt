package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest
import uz.gita.paymedemo.presentation.viewmodel.auth.SignUpViewModel
import uz.gita.paymedemo.utils.isConnected
import javax.inject.Inject


@HiltViewModel
class SignUPViewModelImpl
@Inject constructor(
) : ViewModel(), SignUpViewModel {
    override val progressLiveData = MutableLiveData<Boolean>()
    override val notConnectionLiveData = MutableLiveData<Unit>()
    override val errorLiveData = MutableLiveData<String>()
    override val openVerifyScreenLiveData = MutableLiveData<Unit>()

    override fun registerUser(data: SignUpRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            if (!isConnected()) {
                notConnectionLiveData.postValue(Unit)
                return@launch
            }
            progressLiveData.postValue(true)
            openVerifyScreenLiveData.postValue(Unit)
        }
    }

}
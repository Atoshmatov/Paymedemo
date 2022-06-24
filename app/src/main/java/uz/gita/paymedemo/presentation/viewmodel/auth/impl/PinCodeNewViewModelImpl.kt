package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.paymedemo.presentation.viewmodel.auth.PinCodeNewViewModel
import javax.inject.Inject

@HiltViewModel
class PinCodeNewViewModelImpl @Inject constructor() : ViewModel(), PinCodeNewViewModel {
    override val openMainScreenLiveData = MutableLiveData<Unit>()

    override fun openMainScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            openMainScreenLiveData.postValue(Unit)
        }
    }
}
package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.PinCodeNewViewModel
import javax.inject.Inject

@HiltViewModel
class PinCodeNewViewModelImpl @Inject constructor() : ViewModel(), PinCodeNewViewModel {
    override val openMainScreenLiveData = MutableLiveData<Unit>()

    override fun openMainScreen() {
            openMainScreenLiveData.value = Unit
    }
}
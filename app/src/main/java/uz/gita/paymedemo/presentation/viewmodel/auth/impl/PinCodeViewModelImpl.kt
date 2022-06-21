package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.PinCodeViewModel
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModelImpl @Inject constructor() : ViewModel(), PinCodeViewModel {
    override val openMainScreenLiveData = MutableLiveData<Unit>()

    override fun openMainScreen() {
        openMainScreenLiveData.value = Unit
    }
}
package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.PoliceViewModel
import javax.inject.Inject

@HiltViewModel
class PoliceViewModelImpl @Inject constructor() : ViewModel(), PoliceViewModel {
    override val openSigInScreenLiveData = MutableLiveData<Unit>()

    override fun openSingScreen() {
            openSigInScreenLiveData.value = Unit
    }
}
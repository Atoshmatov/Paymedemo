package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.paymedemo.presentation.viewmodel.auth.PoliceViewModel
import javax.inject.Inject

@HiltViewModel
class PoliceViewModelImpl @Inject constructor() : ViewModel(), PoliceViewModel {
    override val openSigInScreenLiveData = MutableLiveData<Unit>()

    override fun openSingScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            openSigInScreenLiveData.postValue(Unit)
        }
    }
}
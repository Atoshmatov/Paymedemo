package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.paymedemo.presentation.viewmodel.auth.SignInViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModelImpl @Inject constructor() : ViewModel(), SignInViewModel {
    override val openMainScreenLiveData = MutableLiveData<Unit>()

    override fun openScreen() {
        viewModelScope.launch(Dispatchers.IO) {
            openMainScreenLiveData.postValue(Unit)
        }
    }
}
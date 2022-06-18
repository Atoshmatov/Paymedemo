package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.paymedemo.presentation.viewmodel.auth.IntroViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModelImpl @Inject constructor() : ViewModel(), IntroViewModel {
    override val openLanguageScreenLiveData = MutableLiveData<Unit>()

    override fun openLang() {
        viewModelScope.launch(Dispatchers.IO) {
            openLanguageScreenLiveData.postValue(Unit)
        }
    }
}
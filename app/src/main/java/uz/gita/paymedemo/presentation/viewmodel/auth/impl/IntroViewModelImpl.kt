package uz.gita.paymedemo.presentation.viewmodel.auth.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.IntroViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModelImpl @Inject constructor() : ViewModel(), IntroViewModel {
    override val openLanguageScreenLiveData = MutableLiveData<Unit>()
    override val backLanguageScreenLiveData = MutableLiveData<Unit>()

    override fun openLang() {
        openLanguageScreenLiveData.value = Unit
    }

    override fun backScreen() {
        backLanguageScreenLiveData.value = Unit
    }
}
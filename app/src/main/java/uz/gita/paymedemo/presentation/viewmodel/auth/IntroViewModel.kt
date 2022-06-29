package uz.gita.paymedemo.presentation.viewmodel.auth

import androidx.lifecycle.LiveData

interface IntroViewModel {
    val openLanguageScreenLiveData: LiveData<Unit>
    val backLanguageScreenLiveData: LiveData<Unit>

    fun openLang()
    fun backScreen()
}
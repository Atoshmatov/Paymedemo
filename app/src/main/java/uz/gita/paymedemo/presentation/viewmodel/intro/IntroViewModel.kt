package uz.gita.paymedemo.presentation.viewmodel.intro

import androidx.lifecycle.LiveData

interface IntroViewModel {
    val openLanguageScreenLiveData: LiveData<Unit>

    fun openLang()
}
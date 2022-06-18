package uz.gita.paymedemo.presentation.viewmodel.splash

import androidx.lifecycle.LiveData

interface SplashViewModel {
    val openLanguageScreen: LiveData<Unit>
    val notConnectionLiveData: LiveData<Unit>
}
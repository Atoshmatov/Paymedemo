package uz.gita.paymedemo.presentation.viewmodel.auth

import androidx.lifecycle.LiveData

interface PoliceViewModel {
    val openSigInScreenLiveData: LiveData<Unit>

    fun openSingScreen()
}
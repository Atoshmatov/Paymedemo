package uz.gita.paymedemo.presentation.viewmodel.police

import androidx.lifecycle.LiveData

interface PoliceViewModel {
    val openSigInScreenLiveData: LiveData<Unit>

    fun openSingScreen()
}
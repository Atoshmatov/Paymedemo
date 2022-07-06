package uz.gita.paymedemo.presentation.viewmodel.main.pager.basic

import androidx.lifecycle.LiveData
import uz.gita.paymedemo.data.remote.response.main.basic.Basic

interface BasicViewModel {
    val openCardScreenLiveData: LiveData<Unit>
    val cardListLIveData: LiveData<List<Basic.CardAddResponse>>
    val errorLiveData: LiveData<String>
    val placeHolderLiveData: LiveData<Boolean>
    val progressLiveData: LiveData<Boolean>
    val notConnectionLiveData: LiveData<Unit>

    fun openCardScreen()
    fun loadCard()
}
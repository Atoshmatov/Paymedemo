package uz.gita.paymedemo.presentation.viewmodel.main.pager.basic

import androidx.lifecycle.LiveData
import uz.gita.paymedemo.data.remote.response.main.basic.Basic

interface CardsViewModel {
    val openAddCardScreenLiveData: LiveData<Unit>
    val cardListLiveData: LiveData<List<Basic.CardAddResponse>>
    val errorLiveData: LiveData<String>
    val placeHolderLiveData: LiveData<Boolean>
    val progressLiveData: LiveData<Boolean>
    val notConnectionLiveData: LiveData<Unit>
    val backScreenLiveData: LiveData<Unit>
    fun showEventDialog(data: Basic.CardAddResponse)
    val showEventDialogLivaData: LiveData<Basic.CardAddResponse>


    fun openAddScreen()
    fun getAllCard()
    fun backScreen()
}
package uz.gita.paymedemo.presentation.viewmodel.main.pager.basic

import androidx.lifecycle.LiveData
import uz.gita.paymedemo.data.remote.response.main.basic.Basic

interface CardViewModel {
    val openAddCardScreenLiveData: LiveData<Unit>
    val cardListLiveData: LiveData<List<Basic.CardAddResponse>>
    val errorLiveData: LiveData<String>
    val placeHolderLiveData: LiveData<Boolean>
    val progressLiveData: LiveData<Boolean>
    val notConnectionLiveData: LiveData<Unit>
    val backScreenLiveData: LiveData<Unit>


    fun openAddScreen()
    fun getAllCard()
    fun backScreen()
}
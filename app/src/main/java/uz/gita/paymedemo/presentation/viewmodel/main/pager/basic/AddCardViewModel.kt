package uz.gita.paymedemo.presentation.viewmodel.main.pager.basic

import androidx.lifecycle.LiveData
import uz.gita.paymedemo.data.common.models.ThemeModel
import uz.gita.paymedemo.data.remote.request.main.basic.BasicRequest

interface AddCardViewModel {
    val progressLiveData: LiveData<Boolean>
    val isNotConnectionLiveData: LiveData<Unit>
    val errorLiveData: LiveData<String>
    val openScreenLiveData: LiveData<Unit>
    val colorListLiveData: LiveData<List<ThemeModel>>


    fun addCard(data: BasicRequest.CardAddRequest)
    fun openScreen()
    fun loadList()
}
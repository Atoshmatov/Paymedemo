package uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.paymedemo.data.remote.response.main.basic.Basic
import uz.gita.paymedemo.domain.usecase.main.basic.BasicUseCase
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.BasicViewModel
import uz.gita.paymedemo.utils.isConnected
import javax.inject.Inject

@HiltViewModel
class BasicViewModelImpl @Inject constructor(private val basic: BasicUseCase) : ViewModel(),
    BasicViewModel {
    override val openCardScreenLiveData = MutableLiveData<Unit>()
    override val cardListLIveData = MutableLiveData<List<Basic.CardAddResponse>>()
    override val errorLiveData = MutableLiveData<String>()
    override val placeHolderLiveData = MutableLiveData<Boolean>()
    override val progressLiveData = MutableLiveData<Boolean>()
    override val notConnectionLiveData = MutableLiveData<Unit>()

    override fun openCardScreen() {
        openCardScreenLiveData.value = Unit
    }

    override fun loadCard() {
        if (!isConnected()) {
            notConnectionLiveData.value = Unit
            return
        }
        progressLiveData.value = true
        basic.getAllCardNetWork().onEach {
            progressLiveData.value = false
            it.onSuccess { list ->
                cardListLIveData.value = list
                placeHolderLiveData.value = list.isEmpty()
            }.onFailure { error ->
                errorLiveData.value = error.message
            }
        }.launchIn(viewModelScope)
    }
}
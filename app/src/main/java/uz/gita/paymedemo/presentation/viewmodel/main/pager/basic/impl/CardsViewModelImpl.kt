package uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.paymedemo.data.remote.response.main.basic.Basic
import uz.gita.paymedemo.domain.usecase.main.basic.BasicUseCase
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.CardViewModel
import uz.gita.paymedemo.utils.isConnected
import javax.inject.Inject

@HiltViewModel
class CardsViewModelImpl
@Inject constructor(
    private val basicUseCase: BasicUseCase
) :
    ViewModel(),
    CardViewModel {
    override val openAddCardScreenLiveData = MutableLiveData<Unit>()
    override val cardListLiveData = MutableLiveData<List<Basic.CardAddResponse>>()
    override val errorLiveData = MutableLiveData<String>()
    override val placeHolderLiveData = MutableLiveData<Boolean>()
    override val progressLiveData = MutableLiveData<Boolean>()
    override val notConnectionLiveData = MutableLiveData<Unit>()
    override val backScreenLiveData = MutableLiveData<Unit>()

    override fun openAddScreen() {
        openAddCardScreenLiveData.value = Unit
    }

    override fun getAllCard() {
        if (!isConnected()) {
            notConnectionLiveData.value = Unit
            return
        }
        progressLiveData.value = true
        basicUseCase.getAllCardNetWork().onEach {
            progressLiveData.value = false
            it.onSuccess { list ->
                cardListLiveData.value = list
                placeHolderLiveData.value = list.isEmpty()
            }.onFailure { error ->
                errorLiveData.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun backScreen() {
        backScreenLiveData.value = Unit
    }
}
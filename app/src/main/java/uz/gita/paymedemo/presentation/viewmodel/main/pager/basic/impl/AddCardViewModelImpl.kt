package uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.paymedemo.data.common.models.ThemeModel
import uz.gita.paymedemo.data.remote.request.main.basic.BasicRequest
import uz.gita.paymedemo.domain.usecase.main.basic.BasicUseCase
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.AddCardViewModel
import uz.gita.paymedemo.utils.isConnected
import javax.inject.Inject

@HiltViewModel
class AddCardViewModelImpl
@Inject constructor(
    private val basic: BasicUseCase
) : ViewModel(), AddCardViewModel {
    override val progressLiveData = MutableLiveData<Boolean>()
    override val isNotConnectionLiveData = MutableLiveData<Unit>()
    override val errorLiveData = MutableLiveData<String>()
    override val openScreenLiveData = MutableLiveData<Unit>()
    override val colorListLiveData = MutableLiveData<List<ThemeModel>>()

    override fun addCard(data: BasicRequest.CardAddRequest) {
        if (!isConnected()) {
            isNotConnectionLiveData.value = Unit
            return
        }
        progressLiveData.value = true
        basic.insertCard(data).onEach {
            progressLiveData.value = false
            it.onSuccess {
                openScreenLiveData.value = Unit
            }.onFailure { error ->
                errorLiveData.value = error.message
            }
        }.launchIn(viewModelScope)
    }

    override fun openScreen() {
        //TODO
    }

    override fun loadList() {
        basic.getColor().onEach {
            colorListLiveData.value = it
        }.launchIn(viewModelScope)
    }

}
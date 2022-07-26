package uz.gita.paymedemo.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.paymedemo.data.common.models.BottomCardModel
import uz.gita.paymedemo.domain.usecase.main.basic.CardUseCase
import uz.gita.paymedemo.presentation.viewmodel.main.CardViewModel
import javax.inject.Inject

@HiltViewModel
class CardViewModelImpl
@Inject constructor(
    private val card: CardUseCase
) : CardViewModel, ViewModel() {
    override val cardList = MutableLiveData<List<BottomCardModel>>()

    override fun getAllItem() {
        card.getItem().onEach {
            cardList.value = it
        }.launchIn(viewModelScope)
    }
}
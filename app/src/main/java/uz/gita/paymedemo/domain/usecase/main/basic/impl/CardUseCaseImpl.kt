package uz.gita.paymedemo.domain.usecase.main.basic.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.paymedemo.data.common.models.BottomCardModel
import uz.gita.paymedemo.domain.repository.main.basic.CardRepository
import uz.gita.paymedemo.domain.usecase.main.basic.CardUseCase
import javax.inject.Inject

class CardUseCaseImpl
@Inject constructor(
    private val card: CardRepository
) : CardUseCase {
    override fun getItem(): Flow<List<BottomCardModel>> = flow {
        emit(card.getItem())
    }
}
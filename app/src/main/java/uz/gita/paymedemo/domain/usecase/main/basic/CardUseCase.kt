package uz.gita.paymedemo.domain.usecase.main.basic

import kotlinx.coroutines.flow.Flow
import uz.gita.paymedemo.data.common.models.BottomCardModel

interface CardUseCase {
    fun getItem(): Flow<List<BottomCardModel>>
}
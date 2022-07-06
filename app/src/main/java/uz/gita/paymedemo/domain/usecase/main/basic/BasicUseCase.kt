package uz.gita.paymedemo.domain.usecase.main.basic

import kotlinx.coroutines.flow.Flow
import uz.gita.paymedemo.data.common.models.ThemeModel
import uz.gita.paymedemo.data.remote.request.main.basic.BasicRequest
import uz.gita.paymedemo.data.remote.response.main.basic.Basic


interface BasicUseCase {
    fun getAllCardNetWork(): Flow<Result<List<Basic.CardAddResponse>>>
    fun insertCard(data: BasicRequest.CardAddRequest): Flow<Result<Unit>>
    fun deleteCard(data: BasicRequest.DeleteCardRequest): Flow<Result<Unit>>
    fun updateCard(data: BasicRequest.CardUpdateRequest): Flow<Result<Unit>>
    fun getColor(): Flow<List<ThemeModel>>
}
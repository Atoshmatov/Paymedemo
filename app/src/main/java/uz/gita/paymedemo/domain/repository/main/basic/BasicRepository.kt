package uz.gita.paymedemo.domain.repository.main.basic

import retrofit2.Response
import uz.gita.paymedemo.data.common.models.ThemeModel
import uz.gita.paymedemo.data.remote.request.main.basic.BasicRequest
import uz.gita.paymedemo.data.remote.response.main.basic.Basic

interface BasicRepository {
    suspend fun getAllCardsNetWork(): Response<List<Basic.CardAddResponse>>
    suspend fun insertCard(data: BasicRequest.CardAddRequest): Response<Basic.CardAddResponse>
    suspend fun updateCard(data: BasicRequest.CardUpdateRequest): Response<Basic.CardUpdateResponse>
    suspend fun deleteCard(data: BasicRequest.DeleteCardRequest): Response<Basic.DeleteCardResponse>
    suspend fun getColorList(): List<ThemeModel>
}
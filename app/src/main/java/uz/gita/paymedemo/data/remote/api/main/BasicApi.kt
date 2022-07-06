package uz.gita.paymedemo.data.remote.api.main

import retrofit2.Response
import retrofit2.http.*
import uz.gita.paymedemo.data.remote.request.main.basic.BasicRequest
import uz.gita.paymedemo.data.remote.response.main.basic.Basic

interface BasicApi {

    @GET("card")
    suspend fun getAllCards(
        @Header("Authorization") accessToken: String
    ): Response<List<Basic.CardAddResponse>>

    @POST("card")
    suspend fun insertCard(
        @Body card: BasicRequest.CardAddRequest,
        @Header("Authorization") accessToken: String
    ): Response<Basic.CardAddResponse>

    @DELETE("card")
    suspend fun deleteCard(
        @Query("cardId") cardId: BasicRequest.DeleteCardRequest,
        @Header("Authorization") accessToken: String
    ): Response<Basic.DeleteCardResponse>

    @PUT("card")
    suspend fun update(
        @Body data: BasicRequest.CardUpdateRequest,
        @Header("Authorization") accessToken: String
    ): Response<Basic.CardUpdateResponse>
}
package uz.gita.paymedemo.data.remote.api.auth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.paymedemo.data.remote.auth.request.SignUpRequest
import uz.gita.paymedemo.data.remote.auth.response.SignUpResponse


interface SignUpApi {
    @POST("register")
    suspend fun register(@Body data: SignUpRequest): Response<SignUpResponse>
}
package uz.gita.paymedemo.data.remote.api.auth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest
import uz.gita.paymedemo.data.remote.response.auth.SignUpResponse
import uz.gita.paymedemo.data.remote.response.auth.VerifyResponse


interface AuthApi {

    @POST("auth/sign-up")
    suspend fun signUp(@Body data: SignUpRequest): Response<SignUpResponse>

    @POST("auth/sign-up/verify")
    suspend fun signUpVerify(
        @Header("Authorization") token: String,
        @Body code: String
    ): Response<VerifyResponse>
}
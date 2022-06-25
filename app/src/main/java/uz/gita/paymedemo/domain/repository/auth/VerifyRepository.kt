package uz.gita.paymedemo.domain.repository.auth

import retrofit2.Response
import uz.gita.paymedemo.data.remote.request.auth.VerifyRequest
import uz.gita.paymedemo.data.remote.response.auth.VerifyResponse

interface VerifyRepository {
    suspend fun verifyUser(data: VerifyRequest): Response<VerifyResponse>
    suspend fun saveToken(accessToken: String, refreshToken: String)
}
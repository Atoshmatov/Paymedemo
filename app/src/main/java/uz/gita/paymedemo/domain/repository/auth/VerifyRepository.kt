package uz.gita.paymedemo.domain.repository.auth

import retrofit2.Response
import uz.gita.paymedemo.data.remote.request.auth.CodeRequest
import uz.gita.paymedemo.data.remote.response.auth.VerifyResponse

interface VerifyRepository {
    suspend fun verifyUser(data: CodeRequest): Response<VerifyResponse>
    suspend fun saveToken(data:VerifyResponse)
}
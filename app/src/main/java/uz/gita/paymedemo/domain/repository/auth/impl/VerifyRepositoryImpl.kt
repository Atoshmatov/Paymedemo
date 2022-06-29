package uz.gita.paymedemo.domain.repository.auth.impl

import retrofit2.Response
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.data.remote.api.auth.AuthApi
import uz.gita.paymedemo.data.remote.request.auth.CodeRequest
import uz.gita.paymedemo.data.remote.response.auth.VerifyResponse
import uz.gita.paymedemo.domain.repository.auth.VerifyRepository
import javax.inject.Inject

class VerifyRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val shared: SharedPrefToken
) : VerifyRepository {
    override suspend fun verifyUser(data: CodeRequest): Response<VerifyResponse> {
        return authApi.signUpVerify("Bearer ${shared.token}", CodeRequest(data.code))
    }

    override suspend fun saveToken(data: VerifyResponse) {
        shared.acessToken = data.accessToken
        shared.refreshToken = data.refreshToken
    }
}
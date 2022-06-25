package uz.gita.paymedemo.domain.repository.auth.impl

import retrofit2.Response
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.data.remote.api.auth.AuthApi
import uz.gita.paymedemo.data.remote.request.auth.VerifyRequest
import uz.gita.paymedemo.data.remote.response.auth.VerifyResponse
import uz.gita.paymedemo.domain.repository.auth.VerifyRepository
import javax.inject.Inject

class VerifyRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val shared: SharedPrefToken
) : VerifyRepository {
    override suspend fun verifyUser(data: VerifyRequest): Response<VerifyResponse> {
        return authApi.signUpVerify(data.token, data.code)
    }

    override suspend fun saveToken(accessToken: String, refreshToken: String) {
        shared.acessToken = accessToken
        shared.refreshToken = refreshToken
    }
}
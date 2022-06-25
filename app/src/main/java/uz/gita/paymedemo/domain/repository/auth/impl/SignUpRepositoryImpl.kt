package uz.gita.paymedemo.domain.repository.auth.impl

import retrofit2.Response
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.data.remote.api.auth.AuthApi
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest
import uz.gita.paymedemo.data.remote.response.auth.SignUpResponse
import uz.gita.paymedemo.domain.repository.auth.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl
@Inject constructor(
    private val signUpApi: AuthApi,
    private val shared: SharedPrefToken
) : SignUpRepository {
    override suspend fun registerUser(data: SignUpRequest): Response<SignUpResponse> {
        return signUpApi.signUp(data)
    }

    override suspend fun saveToken(token: String) {
        shared.token = token
    }
}
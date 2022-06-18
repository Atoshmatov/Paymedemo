package uz.gita.paymedemo.domain.repository.auth.signup.impl

import retrofit2.Response
import uz.gita.paymedemo.data.remote.api.auth.SignUpApi
import uz.gita.paymedemo.data.remote.auth.request.SignUpRequest
import uz.gita.paymedemo.data.remote.auth.response.SignUpResponse
import uz.gita.paymedemo.domain.repository.auth.signup.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl
@Inject constructor(
    private val signUpApi: SignUpApi
) : SignUpRepository {
    override suspend fun registerUser(data: SignUpRequest): Response<SignUpResponse> {
        return signUpApi.register(data)
    }
}
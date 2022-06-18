package uz.gita.paymedemo.domain.repository.auth.impl

import retrofit2.Response
import uz.gita.paymedemo.data.remote.api.auth.SignUpApi
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest
import uz.gita.paymedemo.data.remote.response.response.SignUpResponse
import uz.gita.paymedemo.domain.repository.auth.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl
@Inject constructor(
    private val signUpApi: SignUpApi
) : SignUpRepository {
    override suspend fun registerUser(data: SignUpRequest): Response<SignUpResponse> {
        return signUpApi.register(data)
    }
}
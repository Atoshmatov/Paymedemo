package uz.gita.paymedemo.domain.repository.auth

import retrofit2.Response
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest
import uz.gita.paymedemo.data.remote.response.response.SignUpResponse

interface SignUpRepository {
    suspend fun registerUser(data: SignUpRequest):Response<SignUpResponse>
}
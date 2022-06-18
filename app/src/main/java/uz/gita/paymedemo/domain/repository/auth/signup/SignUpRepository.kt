package uz.gita.paymedemo.domain.repository.auth.signup

import retrofit2.Response
import uz.gita.paymedemo.data.remote.auth.request.SignUpRequest
import uz.gita.paymedemo.data.remote.auth.response.SignUpResponse

interface SignUpRepository {
    suspend fun registerUser(data: SignUpRequest):Response<SignUpResponse>
}
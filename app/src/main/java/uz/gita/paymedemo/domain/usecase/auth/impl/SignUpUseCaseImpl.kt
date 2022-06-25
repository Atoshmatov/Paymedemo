package uz.gita.paymedemo.domain.usecase.auth.impl

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.paymedemo.data.remote.modele.ErrorMessage
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest
import uz.gita.paymedemo.domain.repository.auth.SignUpRepository
import uz.gita.paymedemo.domain.usecase.auth.SignUpUseCase
import javax.inject.Inject

class SignUpUseCaseImpl @Inject constructor(
    private val signUpRepository: SignUpRepository,
    private val gson: Gson
) : SignUpUseCase {
    override fun registerUser(data: SignUpRequest): Flow<Result<Unit>> = flow {
        val response = signUpRepository.registerUser(data)
        if (response.isSuccessful) {
            response.body()?.let {
                signUpRepository.saveToken(it.token)
            }
            emit(Result.success(Unit))
        } else {
            var error = ErrorMessage(500, "Unknown error")
            response.errorBody()?.string()?.let {
                error = gson.fromJson(it, ErrorMessage::class.java)
            }
            emit(Result.failure(Exception(error.message)))
        }
    }.flowOn(Dispatchers.IO)
}
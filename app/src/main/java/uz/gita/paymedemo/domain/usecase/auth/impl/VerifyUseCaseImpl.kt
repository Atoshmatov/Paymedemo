package uz.gita.paymedemo.domain.usecase.auth.impl

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.paymedemo.data.remote.modele.ErrorMessage
import uz.gita.paymedemo.data.remote.request.auth.VerifyRequest
import uz.gita.paymedemo.domain.repository.auth.VerifyRepository
import uz.gita.paymedemo.domain.usecase.auth.VerifyUseCase
import javax.inject.Inject

class VerifyUseCaseImpl @Inject constructor(
    private val verifyRepository: VerifyRepository,
    private val gson: Gson
) : VerifyUseCase {

    override fun verifyCode(data: VerifyRequest): Flow<Result<Unit>> = flow {
        val response = verifyRepository.verifyUser(data)
        if (response.isSuccessful) {
            response.body()?.let {
                verifyRepository.saveToken(it.accessToken, it.refreshToken)
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
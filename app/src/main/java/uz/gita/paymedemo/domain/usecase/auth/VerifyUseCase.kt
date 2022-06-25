package uz.gita.paymedemo.domain.usecase.auth

import kotlinx.coroutines.flow.Flow
import uz.gita.paymedemo.data.remote.request.auth.VerifyRequest

interface VerifyUseCase {
    fun verifyCode(data: VerifyRequest): Flow<Result<Unit>>
}
package uz.gita.paymedemo.domain.usecase.auth

import kotlinx.coroutines.flow.Flow
import uz.gita.paymedemo.data.remote.request.auth.CodeRequest

interface VerifyUseCase {
    fun verifyCode(data: CodeRequest): Flow<Result<Unit>>
}
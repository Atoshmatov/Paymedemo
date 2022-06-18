package uz.gita.paymedemo.domain.usecase.auth

import kotlinx.coroutines.flow.Flow
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest

interface SinUpUseCase {
    fun registerUser(data: SignUpRequest): Flow<Result<Unit>>
}
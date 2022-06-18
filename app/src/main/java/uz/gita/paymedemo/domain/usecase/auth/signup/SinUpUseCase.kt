package uz.gita.paymedemo.domain.usecase.auth.signup

import kotlinx.coroutines.flow.Flow
import uz.gita.paymedemo.data.remote.auth.request.SignUpRequest

interface SinUpUseCase {
    fun registerUser(data: SignUpRequest): Flow<Result<Unit>>
}
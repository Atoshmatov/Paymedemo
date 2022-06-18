package uz.gita.paymedemo.domain.usecase.auth.impl

import uz.gita.paymedemo.domain.repository.auth.SignUpRepository
import uz.gita.paymedemo.domain.usecase.auth.SignInUseCase
import javax.inject.Inject

class SignInUseCaseImpl
@Inject constructor(
    private val signUpRepository: SignUpRepository
) : SignInUseCase {

}
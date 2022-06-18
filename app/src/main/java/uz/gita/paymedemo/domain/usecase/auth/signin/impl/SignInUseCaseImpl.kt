package uz.gita.paymedemo.domain.usecase.auth.signin.impl

import uz.gita.paymedemo.domain.repository.auth.signup.SignUpRepository
import uz.gita.paymedemo.domain.usecase.auth.signin.SignInUseCase
import javax.inject.Inject

class SignInUseCaseImpl
@Inject constructor(
    private val signUpRepository: SignUpRepository
) : SignInUseCase {

}
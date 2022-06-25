package uz.gita.paymedemo.di.auth

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.paymedemo.domain.usecase.auth.SignUpUseCase
import uz.gita.paymedemo.domain.usecase.auth.VerifyUseCase
import uz.gita.paymedemo.domain.usecase.auth.impl.SignUpUseCaseImpl
import uz.gita.paymedemo.domain.usecase.auth.impl.VerifyUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindSingUseCase(impl: SignUpUseCaseImpl): SignUpUseCase

    @Binds
    fun bindVerifyUseCase(impl: VerifyUseCaseImpl): VerifyUseCase
}
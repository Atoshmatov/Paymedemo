package uz.gita.paymedemo.di.main

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.paymedemo.domain.usecase.main.basic.BasicUseCase
import uz.gita.paymedemo.domain.usecase.main.basic.impl.BasicUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindBasicUseCase(impl: BasicUseCaseImpl): BasicUseCase
}
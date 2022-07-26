package uz.gita.paymedemo.di.main

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.paymedemo.domain.repository.main.basic.impl.CardRepositoryImpl
import uz.gita.paymedemo.domain.usecase.main.basic.BasicUseCase
import uz.gita.paymedemo.domain.usecase.main.basic.CardUseCase
import uz.gita.paymedemo.domain.usecase.main.basic.impl.BasicUseCaseImpl
import uz.gita.paymedemo.domain.usecase.main.basic.impl.CardUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindBasicUseCase(impl: BasicUseCaseImpl): BasicUseCase

    @Binds
    fun bindCardUseCase(impl: CardUseCaseImpl): CardUseCase
}
package uz.gita.paymedemo.di.main

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.paymedemo.domain.repository.main.basic.BasicRepository
import uz.gita.paymedemo.domain.repository.main.basic.CardRepository
import uz.gita.paymedemo.domain.repository.main.basic.impl.BasicRepositoryImpl
import uz.gita.paymedemo.domain.repository.main.basic.impl.CardRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun binBasicRepository(impl: BasicRepositoryImpl): BasicRepository

    @[Binds Singleton]
    fun bindCardRepository(impl: CardRepositoryImpl): CardRepository
}
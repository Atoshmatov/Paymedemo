package uz.gita.paymedemo.di.main

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.paymedemo.domain.repository.main.basic.BasicRepository
import uz.gita.paymedemo.domain.repository.main.basic.impl.BasicRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

//    @[Provides Singleton]
//    fun binBasicRepository(impl: BasicRepositoryImpl): BasicRepository
}
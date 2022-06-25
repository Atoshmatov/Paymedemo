package uz.gita.paymedemo.di.auth

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.paymedemo.domain.repository.auth.SignUpRepository
import uz.gita.paymedemo.domain.repository.auth.VerifyRepository
import uz.gita.paymedemo.domain.repository.auth.impl.SignUpRepositoryImpl
import uz.gita.paymedemo.domain.repository.auth.impl.VerifyRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindSignUpRepository(impl: SignUpRepositoryImpl): SignUpRepository

    @[Binds Singleton]
    fun bindVerifyRepository(impl: VerifyRepositoryImpl): VerifyRepository
}
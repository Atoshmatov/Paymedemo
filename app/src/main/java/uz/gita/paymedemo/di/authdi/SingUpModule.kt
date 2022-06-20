package uz.gita.paymedemo.di.authdi

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.gita.paymedemo.data.remote.api.auth.SignUpApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingUpModule {

    @[Provides Singleton]
    fun getSingUpApi(retrofit: Retrofit): SignUpApi = retrofit.create(SignUpApi::class.java)
}
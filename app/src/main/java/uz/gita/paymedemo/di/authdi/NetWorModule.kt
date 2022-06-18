package uz.gita.paymedemo.di.authdi

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetWorModule {

    @[Provides Singleton]
    fun getGson(): Gson = Gson()
}
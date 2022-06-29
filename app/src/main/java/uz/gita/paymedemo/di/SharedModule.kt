package uz.gita.paymedemo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.paymedemo.data.local.SharedPrefToken
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SharedModule {

    @[Provides Singleton]
    fun getSharedPref(@ApplicationContext context: Context): SharedPrefToken =
        SharedPrefToken(context)
}
package uz.gita.paymedemo.di.main

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.paymedemo.data.local.CardDatabase
import uz.gita.paymedemo.data.local.dao.CardsDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @[Provides Singleton]
    fun getCardDatabase(@ApplicationContext context: Context): CardDatabase =
        Room.databaseBuilder(context, CardDatabase::class.java, "MyCard").build()

    @[Provides Singleton]
    fun getCardDao(database: CardDatabase): CardsDao = database.getCardDao()

}
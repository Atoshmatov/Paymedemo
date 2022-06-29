package uz.gita.paymedemo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.paymedemo.data.local.dao.CardsDao
import uz.gita.paymedemo.data.local.entity.CardEntity

@Database(entities = [CardEntity::class], version = 1)
abstract class CardDatabase : RoomDatabase() {
    abstract fun getCardDao(): CardsDao
}
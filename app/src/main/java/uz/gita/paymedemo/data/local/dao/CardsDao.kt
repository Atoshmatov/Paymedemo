package uz.gita.paymedemo.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.paymedemo.data.local.entity.CardEntity

@Dao
interface CardsDao : BaseDao<CardEntity> {
    @Query("Select * from CardEntity")
    fun getAllCards(): List<CardEntity>
}
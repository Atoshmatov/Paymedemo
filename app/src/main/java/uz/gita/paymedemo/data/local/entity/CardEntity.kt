package uz.gita.paymedemo.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val pan: String,
    val name: String,
    val expiredAt: String,
    val theme: Int
)

package uz.gita.paymedemo.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.gita.paymedemo.data.remote.response.main.basic.Basic

@Entity
data class CardEntity(
    @PrimaryKey(autoGenerate = true)
    val cardId: Long,
    val name: String,
    val pan: String,
    val expiredAt: String,
    val theme: Int,
    val amount: Int,
    val owner: String,
    val status: String
)

fun CardEntity.toCardData(): Basic.CardAddResponse =
    Basic.CardAddResponse(cardId, name, pan, expiredAt, theme, amount, owner, status)

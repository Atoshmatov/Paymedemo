package uz.gita.paymedemo.data.remote.response.main.basic

import uz.gita.paymedemo.data.local.entity.CardEntity

sealed class Basic {
    data class CardAddResponse(
        val cardId: Long,
        val name: String,
        val pan: String,
        val expiredAt: String,
        val theme: Int,
        val amount: Int,
        val owner: String,
        val status: String
    )

    data class CardUpdateResponse(
        val cardId: Long,
        val name: String,
        val theme: Int
    )

    data class DeleteCardResponse(
        val cardId: Long
    )
}

fun Basic.CardAddResponse.toCardEntity(): CardEntity =
    CardEntity(cardId, name, pan, expiredAt, theme, amount, owner, status)

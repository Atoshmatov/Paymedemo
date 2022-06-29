package uz.gita.paymedemo.data.common.models

import java.io.Serializable

data class CardModel(
    val id: Long = 0,
    val pan: String,
    val name: String,
    val expiredAt: String,
    val theme: Int
) : Serializable

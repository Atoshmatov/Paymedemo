package uz.gita.paymedemo.data.common.models

import java.io.Serializable

data class BottomCardModel(
    val image: Int,
    val title: String
) : Serializable {
    override fun toString(): String {
        return title
    }
}
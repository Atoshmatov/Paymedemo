package uz.gita.paymedemo.domain.repository.main.basic

import uz.gita.paymedemo.data.common.models.BottomCardModel
import uz.gita.paymedemo.data.common.models.ThemeModel

interface CardRepository {
    suspend fun getItem(): List<BottomCardModel>
}
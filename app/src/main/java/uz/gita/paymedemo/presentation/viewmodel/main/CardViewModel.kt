package uz.gita.paymedemo.presentation.viewmodel.main

import androidx.lifecycle.LiveData
import uz.gita.paymedemo.data.common.models.BottomCardModel


interface CardViewModel {
    val cardList: LiveData<List<BottomCardModel>>
    fun getAllItem()
}
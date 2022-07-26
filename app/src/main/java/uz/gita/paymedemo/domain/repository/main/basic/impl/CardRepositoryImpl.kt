package uz.gita.paymedemo.domain.repository.main.basic.impl

import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.common.models.BottomCardModel
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.domain.repository.main.basic.CardRepository
import javax.inject.Inject

class
CardRepositoryImpl
@Inject constructor(
    private val shared: SharedPrefToken
) : CardRepository {
    private val cardItemList = ArrayList<BottomCardModel>()

    init {
        addList()
    }

    override suspend fun getItem(): List<BottomCardModel> = cardItemList


    private fun addList() {
        cardItemList.add(
            BottomCardModel(
                R.drawable.ic_tab_perevod,
                title = R.string.deposit_card.toString()
            )
        )
        cardItemList.add(
            BottomCardModel(
                R.drawable.ic_history_small,
                title = R.string.cashFlow.toString()
            )
        )
        cardItemList.add(
            BottomCardModel(
                R.drawable.ic_gear,
                title = R.string.card_settings.toString()
            )
        )
        cardItemList.add(
            BottomCardModel(
                R.drawable.ic_lock,
                title = R.string.block.toString()
            )
        )
        cardItemList.add(
            BottomCardModel(
                R.drawable.ic_delete,
                title = R.string.delete.toString()
            )
        )
    }

}
package uz.gita.paymedemo.domain.repository.main.basic.impl

import retrofit2.Response
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.common.models.ThemeModel
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.data.remote.api.main.BasicApi
import uz.gita.paymedemo.data.remote.request.main.basic.BasicRequest
import uz.gita.paymedemo.data.remote.response.main.basic.Basic
import uz.gita.paymedemo.domain.repository.main.basic.BasicRepository
import javax.inject.Inject

class BasicRepositoryImpl
@Inject constructor(
    private val cardApi: BasicApi,
    private val shared: SharedPrefToken
) : BasicRepository {
    private val colorList = ArrayList<ThemeModel>()

    init {
        addList()
    }

    override suspend fun getAllCardsNetWork(): Response<List<Basic.CardAddResponse>> {
        return cardApi.getAllCards("Bearer ${shared.acessToken}")
    }

    override suspend fun insertCard(data: BasicRequest.CardAddRequest): Response<Basic.CardAddResponse> {
        return cardApi.insertCard(data, "Bearer ${shared.acessToken}")
    }

    override suspend fun updateCard(data: BasicRequest.CardUpdateRequest): Response<Basic.CardUpdateResponse> {
        return cardApi.update(data, "Bearer ${shared.acessToken}")
    }

    override suspend fun deleteCard(data: BasicRequest.DeleteCardRequest): Response<Basic.DeleteCardResponse> {
        return cardApi.deleteCard(data, "Bearer ${shared.acessToken}")
    }

    override suspend fun getColorList(): List<ThemeModel> = colorList

    private fun addList() {
        colorList.add(ThemeModel(1, R.color.color_1_1))
        colorList.add(ThemeModel(2, R.color.color_2_2))
        colorList.add(ThemeModel(3, R.color.color_3_3))
        colorList.add(ThemeModel(4, R.color.color_4_4))
        colorList.add(ThemeModel(5, R.color.color_5_5))
        colorList.add(ThemeModel(6, R.color.color_6_6))
        colorList.add(ThemeModel(7, R.color.color_1_1))
    }
}
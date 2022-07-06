package uz.gita.paymedemo.domain.usecase.main.basic.impl

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.paymedemo.data.common.models.ThemeModel
import uz.gita.paymedemo.data.remote.modele.ErrorMessage
import uz.gita.paymedemo.data.remote.request.main.basic.BasicRequest
import uz.gita.paymedemo.data.remote.response.main.basic.Basic
import uz.gita.paymedemo.domain.repository.main.basic.BasicRepository
import uz.gita.paymedemo.domain.usecase.main.basic.BasicUseCase
import javax.inject.Inject

class BasicUseCaseImpl
@Inject constructor(
    private val cardRp: BasicRepository,
    private val gson: Gson
) : BasicUseCase {
    override fun getAllCardNetWork(): Flow<Result<List<Basic.CardAddResponse>>> =
        flow<Result<List<Basic.CardAddResponse>>> {
            val response = cardRp.getAllCardsNetWork()
            if (response.isSuccessful) {
                response.body()?.let { result ->
                    emit(Result.success(result))
                }
            } else {
                var error = ErrorMessage(406, "Unknown error")
                response.errorBody()?.string()?.let {
                    error = gson.fromJson(it, ErrorMessage::class.java)
                }
                emit(Result.failure(Exception(error.message)))
            }
        }
            .catch { emit(Result.failure(Exception(it))) }
            .flowOn(Dispatchers.IO)

    override fun insertCard(data: BasicRequest.CardAddRequest): Flow<Result<Unit>> =
        flow<Result<Unit>> {
            val response = cardRp.insertCard(data)
            if (response.isSuccessful) {
                emit(Result.success(Unit))
            } else {
                var error = ErrorMessage(406, "Unknown error")
                response.errorBody()?.string()?.let {
                    error = gson.fromJson(it, ErrorMessage::class.java)
                }
                emit(Result.failure(Exception(error.message)))
            }
        }.flowOn(Dispatchers.IO)

    override fun deleteCard(data: BasicRequest.DeleteCardRequest) = flow {
        val response = cardRp.deleteCard(data)
        if (response.isSuccessful) {
            emit(Result.success(Unit))
        } else {
            var error = ErrorMessage(406, "Unknown error")
            response.errorBody()?.string()?.let {
                error = gson.fromJson(it, ErrorMessage::class.java)
            }
            emit(Result.failure(Exception(error.message)))
        }
    }.flowOn(Dispatchers.IO)

    override fun updateCard(data: BasicRequest.CardUpdateRequest) = flow {
        val response = cardRp.updateCard(data)
        if (response.isSuccessful) {
            emit(Result.success(Unit))
        } else {
            var error = ErrorMessage(406, "Unknown error")
            response.errorBody()?.string()?.let {
                error = gson.fromJson(it, ErrorMessage::class.java)
            }
            emit(Result.failure(Exception(error.message)))
        }
    }.flowOn(Dispatchers.IO)

    override fun getColor(): Flow<List<ThemeModel>> = flow {
        emit(cardRp.getColorList())
    }
}
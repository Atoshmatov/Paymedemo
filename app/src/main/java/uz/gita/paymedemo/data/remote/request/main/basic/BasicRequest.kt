package uz.gita.paymedemo.data.remote.request.main.basic

sealed class BasicRequest {
    data class CardAddRequest(
        val pan: String,
        val expiredAt: String,
        val name: String,
        val theme: Int
    )

    data class CardUpdateRequest(
        val cardId: Long,
        val name: String,
        val theme: Int
    )


    data class DeleteCardRequest(
        val cardId: Long
    )

}
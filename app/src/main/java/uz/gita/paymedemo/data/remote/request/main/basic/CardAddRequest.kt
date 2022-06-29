package uz.gita.paymedemo.data.remote.request.main.basic

data class CardAddRequest(
    val id: Long = 0,
    val pan: String,
    val expiredAt: String,
    val name: String,
    val theme: Int
)

package uz.gita.paymedemo.data.remote.request.auth

data class VerifyRequest(
    val token: String,
    val code: String
)

package uz.gita.paymedemo.data.remote.response.auth

data class VerifyResponse(
    val accessToken: String,
    val refreshToken: String
)

package uz.gita.paymedemo.data.remote.request.auth

data class VerifyRequest(
    val phoneNumber:String,
    val pinCode:String
)

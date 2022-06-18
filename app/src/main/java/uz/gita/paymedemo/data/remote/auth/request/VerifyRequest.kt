package uz.gita.paymedemo.data.remote.auth.request

data class VerifyRequest(
    val phoneNumber:String,
    val pinCode:String
)

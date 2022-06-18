package uz.gita.paymedemo.data.remote.auth.request

data class SignUpRequest(
    val firstName:String,
    val lastName:String,
    val phoneNumber:String,
    val password:String
)

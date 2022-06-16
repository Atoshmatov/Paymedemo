package uz.gita.paymedemo.data.remote.auth.request.signup

data class SignUpRequest(
    val firstName:String,
    val lastName:String,
    val phoneNumber:String,
    val password:String
)

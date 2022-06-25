package uz.gita.paymedemo.data.remote.request.auth

data class SignUpRequest(
    val firstName:String,
    val lastName:String,
    val phone:String,
    val password:String
)

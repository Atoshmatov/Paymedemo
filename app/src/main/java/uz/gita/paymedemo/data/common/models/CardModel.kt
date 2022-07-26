package uz.gita.paymedemo.data.common.models

import java.io.Serializable

data class CardModel(
    val cardId: Long = 0,
    val pan: String,
    val name: String,
    val expiredAt: String,
    val theme: Int
) : Serializable
/*
Rustam Akbaraliyev, [04.07.2022 19:10]
/auth/sign-in

{
    "phone":"+998913610045",
    "password":"Qwerty123"
}

/auth/sign-in/verify

{
    "code" : "708562"
}

/transfer

{
    "cardNumber":"",
    "amount": 10000,
    "totalAmount": 10500,
    "senderCardId":4,
    "receiverCardId":5,
    "commit" :"tester"

}

/transfer/perform

{
    "transferHash":"048b667f-fc01-4f8e-ba1c-811caa850324"
}

Rustam Akbaraliyev, [04.07.2022 19:14]
/transfer/receiver-info

{
   "pan" :"860000000000002"
}

http://143.198.48.222/card

POST :
body {
    "pan":"860000000000000",
    "theme":1,
    "expiredAt":"1123",
    "name":"test"
}

GET

DELETE:
query parametr

cardId
* */
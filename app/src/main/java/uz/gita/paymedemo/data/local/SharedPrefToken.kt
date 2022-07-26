package uz.gita.paymedemo.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPrefToken @Inject constructor(@ApplicationContext context: Context) {
    private val pref = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)

    //token
    var token: String
        get() = pref.getString("TOKEN", "")!!
        set(value) = pref.edit().putString("TOKEN", value).apply()

    //access token
    var acessToken: String
        get() = pref.getString("TOKEN1", "")!!
        set(value) = pref.edit().putString("TOKEN1", value).apply()

    //refresh token
    var refreshToken: String
        get() = pref.getString("TOKEN2", "")!!
        set(value) = pref.edit().putString("TOKEN2", value).apply()

    // screen action
    var id: Int
        get() = pref.getInt("id", 0)
        set(value) = pref.edit().putInt("id", value).apply()

    //language position
    var language: String
        get() = pref.getString("lang", "")!!
        set(value) = pref.edit().putString("lang", value).apply()

    //code save
    var code: String
        get() = pref.getString("code", "")!!
        set(value) = pref.edit().putString("code", value).apply()

    //password
    var password: String
        get() = pref.getString("password", "")!!
        set(value) = pref.edit().putString("password", value).apply()

    //userName
    var userName1: String
        get() = pref.getString("userName1", "")!!
        set(value) = pref.edit().putString("userName1", value).apply()

    //userName
    var userName2: String
        get() = pref.getString("userName2", "")!!
        set(value) = pref.edit().putString("userName2", value).apply()

    //userName
    var phoneNumber: String
        get() = pref.getString("phoneNumber", "")!!
        set(value) = pref.edit().putString("phoneNumber", value).apply()
}
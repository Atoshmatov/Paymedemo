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
        get() = pref.getString("acessToken", "")!!
        set(value) = pref.edit().putString("acessToken", "").apply()

    //refresh token
    var refreshToken: String
        get() = pref.getString("refreshToken", "")!!
        set(value) = pref.edit().putString("refreshToken", "").apply()

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

    var password: String
        get() = pref.getString("password", "")!!
        set(value) = pref.edit().putString("password", value).apply()
}
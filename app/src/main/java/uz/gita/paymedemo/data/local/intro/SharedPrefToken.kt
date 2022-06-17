package uz.gita.paymedemo.data.local.intro

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefToken @Inject constructor(@ApplicationContext context: Context) {
    private val pref = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)

    //token
    var token: String
        get() = pref.getString("TOKEN", "")!!
        set(value) = pref.edit().putString("TOKEN", value).apply()

    // screen action
    var id: Int
        get() = pref.getInt("id", 0)
        set(value) = pref.edit().putInt("id", value).apply()

    //language position
    var language: Int
        get() = pref.getInt("lang", 0)
        set(value) = pref.edit().putInt("lang", value).apply()
}
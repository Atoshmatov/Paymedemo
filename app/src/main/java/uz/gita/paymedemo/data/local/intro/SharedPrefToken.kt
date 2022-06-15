package uz.gita.paymedemo.data.local.intro

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPrefToken @Inject constructor(@ApplicationContext context: Context) {
    private val pref = context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE)

    var language: Long
        get() = pref.getLong("token", 0)
        set(value) = pref.edit().putLong("token", value).apply()
}
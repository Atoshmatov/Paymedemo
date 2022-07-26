package uz.gita.paymedemo.utils.boradcast

import android.content.Context
import android.net.ConnectivityManager


class ServiceManager(private var context: Context) {
    fun ServiceManager(base: Context) {
        context = base
    }

    fun isNetworkAvailable(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
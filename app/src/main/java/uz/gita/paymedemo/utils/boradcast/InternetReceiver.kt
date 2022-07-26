package uz.gita.paymedemo.utils.boradcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import timber.log.Timber


class InternetReceiver : BroadcastReceiver() {

    /*override fun onReceive(context: Context, intent: Intent?) {
        *//* val connMgr = context
             .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
         val wifi = connMgr
             .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
         val mobile = connMgr
             .getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
         if (wifi!!.isAvailable || mobile!!.isAvailable) {
             Log.d("Network Available ", "Flag No 1")
         }*//*
        try {
            if (online(context)) {
                Toast.makeText(context, "network connected", Toast.LENGTH_SHORT).show()
                Timber.tag("TTT").d("${online(context)}")
            } else {
                Timber.tag("TTT").d("${online(context)}")
                Toast.makeText(context, "no network connected", Toast.LENGTH_SHORT).show()
            }

        } catch (e: NullPointerException) {
            e.printStackTrace()
        }

    }

    fun online(context: Context): Boolean {
        try {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netWorkInfo = cm.activeNetworkInfo
            return (netWorkInfo != null && netWorkInfo.isConnected)
        } catch (e: NullPointerException) {
            e.printStackTrace()
            return false
        }
    }*/
    override fun onReceive(context: Context, intent: Intent) {
        if (checkInternet(context)) {
            Timber.tag("TTT").d("${checkInternet(context)}")
            Toast.makeText(context, "Network Available Do operations", Toast.LENGTH_LONG).show();
        } else {
            Timber.tag("TTT").d("${checkInternet(context)}")
            Toast.makeText(context, "No Network Available Do operations", Toast.LENGTH_LONG).show();
        }
    }

    fun checkInternet(context: Context): Boolean {
        val serviceManager = ServiceManager(context);
        return serviceManager.isNetworkAvailable()
    }
}
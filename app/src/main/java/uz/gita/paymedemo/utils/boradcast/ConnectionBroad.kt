package uz.gita.paymedemo.utils.boradcast

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import timber.log.Timber

class ConnectionBroad : BroadcastReceiver() {
    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirPlanMode = intent?.getBooleanExtra("state", false) ?: return
        if (isAirPlanMode) {
            Connection.notConnectionLiveData.value = true
            Toast.makeText(context, "Enabled", Toast.LENGTH_SHORT).show()
            Timber.tag("AAA").d(isAirPlanMode.toString())
        } else {
            Connection.notConnectionLiveData.value = false
            Toast.makeText(context, "Disabled", Toast.LENGTH_SHORT).show()
            Timber.tag("AAA").d(isAirPlanMode.toString())
        }
    }
}
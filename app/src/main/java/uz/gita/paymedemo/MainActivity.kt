package uz.gita.paymedemo

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.r0adkll.slidr.Slidr
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.presentation.ui.auth.screen.LanguageScreen
import uz.gita.paymedemo.utils.LocaleHelper
import uz.gita.paymedemo.utils.boradcast.InternetReceiver
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var languageScreen: LanguageScreen? = null
    private var shared: SharedPrefToken? = null
    private var receiver: InternetReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        languageScreen = LanguageScreen()
        shared = SharedPrefToken(this)
        Slidr.attach(this);
        receiver = InternetReceiver()
        register()
    }

    protected fun register() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerReceiver(receiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            registerReceiver(receiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        }
    }

    protected fun unRegister() {
        try {
            unregisterReceiver(receiver)

        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }

    override fun attachBaseContext(newBase: Context?) {
        val local = Locale(SharedPrefToken(newBase ?: this).language)
        val contextWrapper = LocaleHelper.setLocale(newBase ?: this, local.toString())
        super.attachBaseContext(contextWrapper)
    }

    override fun onStop() {
        super.onStop()
        unRegister()
    }
}
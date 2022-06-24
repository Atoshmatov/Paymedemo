package uz.gita.paymedemo

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.r0adkll.slidr.Slidr
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.presentation.view.auth.screen.LanguageScreen
import uz.gita.paymedemo.utils.LocaleHelper
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var languageScreen: LanguageScreen? = null
    private var shared: SharedPrefToken? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        languageScreen = LanguageScreen()
        shared = SharedPrefToken(this)
        Slidr.attach(this);
    }

    override fun attachBaseContext(newBase: Context?) {
        val local = Locale(SharedPrefToken(newBase ?: this).language)
        val contextWrapper = LocaleHelper.setLocale(newBase ?: this, local.toString())
        super.attachBaseContext(contextWrapper)
    }
}
package uz.gita.paymedemo

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.presentation.view.auth.screen.LanguageScreen
import java.util.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var languageScreen: LanguageScreen? = null
    private var shared: SharedPrefToken? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        languageScreen = LanguageScreen()
        shared = SharedPrefToken(this)
        onOptionsItemSelected(shared!!.language)
        Timber.tag("EEE").d("${shared?.language}")
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun onOptionsItemSelected(id: Int) {
        var languageToLoad = "en";
        languageToLoad = when (id) {
            1 -> {
                "ru"
            }
            2 -> {
                "uz"
            }
            else -> {
                "en"
            }
        }
        val locale = Locale(languageToLoad);
        Locale.setDefault(locale);
        val config = Configuration();
        config.locale = locale;
        this.resources.updateConfiguration(config, this.resources.displayMetrics)
    }

    /*  private var mCurrentLocale: Locale? = null

      override fun onStart() {
          super.onStart()
          mCurrentLocale = resources.configuration.locale
      }

      override fun onRestart() {
          super.onRestart()
          val locale = getLocale(1)
          if (locale != mCurrentLocale) {
              mCurrentLocale = locale
              recreate()
          }
      }

      private fun getLocale(id: Int): Locale {
          var languageToLoad = "eng";
          languageToLoad = when (id) {
              1 -> {
                  "ru"
              }
              2 -> {
                  "uzb"
              }
              else -> {
                  "eng"
              }
          }
          return Locale(languageToLoad)
      }*/
}
package uz.gita.paymedemo.app

import android.app.Application
import com.mocklets.pluto.Pluto
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import uz.gita.paymedemo.BuildConfig


@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Pluto.initialize(this)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
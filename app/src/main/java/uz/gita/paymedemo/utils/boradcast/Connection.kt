package uz.gita.paymedemo.utils.boradcast

import androidx.lifecycle.MutableLiveData
import javax.inject.Singleton

@Singleton
object Connection {
    val notConnectionLiveData = MutableLiveData<Boolean>()
}
package uz.gita.paymedemo.presentation.viewmodel.main

import androidx.lifecycle.LiveData

interface MainViewModel {

    val selectPagePositionLiveData: LiveData<Int>

    fun selectPagePosition(pos: Int)
}
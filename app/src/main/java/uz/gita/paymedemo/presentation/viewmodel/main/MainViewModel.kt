package uz.gita.paymedemo.presentation.viewmodel.main

import androidx.lifecycle.LiveData

interface MainViewModel {
    //screen pos
    val selectPagePositionLiveData: LiveData<Int>
    fun selectPagePosition(pos: Int)

    //drawer open and close
    val openDrawLiveData: LiveData<Unit>
    val closeDrawLiveData: LiveData<Unit>
    val openDialogLiveData: LiveData<Unit>
    fun openDraw()
    fun closeDraw()
    fun openDialog()
}
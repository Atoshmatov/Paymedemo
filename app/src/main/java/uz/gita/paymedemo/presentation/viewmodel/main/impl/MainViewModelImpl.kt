package uz.gita.paymedemo.presentation.viewmodel.main.impl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.gita.paymedemo.presentation.viewmodel.main.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor() : ViewModel(), MainViewModel {
    override val selectPagePositionLiveData = MutableLiveData<Int>()
    override val openDrawLiveData = MutableLiveData<Unit>()
    override val closeDrawLiveData = MutableLiveData<Unit>()
    override val openDialogLiveData = MutableLiveData<Unit>()

    override fun selectPagePosition(pos: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            selectPagePositionLiveData.postValue(pos)
        }
    }

    override fun openDraw() {
        viewModelScope.launch(Dispatchers.IO) {
            openDrawLiveData.postValue(Unit)
        }
    }

    override fun closeDraw() {
        viewModelScope.launch(Dispatchers.IO) {
            closeDrawLiveData.postValue(Unit)
        }
    }

    override fun openDialog() {
        viewModelScope.launch(Dispatchers.IO) {
            openDialogLiveData.postValue(Unit)
        }
    }
}
package uz.gita.paymedemo.presentation.view.auth.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenMainBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.MainViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.MainViewModelImpl

class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
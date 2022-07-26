package uz.gita.paymedemo.presentation.ui.main.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenSettingBinding
import uz.gita.paymedemo.presentation.viewmodel.main.SettingViewModel
import uz.gita.paymedemo.presentation.viewmodel.main.impl.SettingViewModelImpl

@AndroidEntryPoint
class SettingScreen : Fragment(R.layout.screen_setting) {
    private val binding by viewBinding(ScreenSettingBinding::bind)
    private val viewModel: SettingViewModel by viewModels<SettingViewModelImpl>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}
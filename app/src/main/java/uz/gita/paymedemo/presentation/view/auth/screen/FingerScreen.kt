package uz.gita.paymedemo.presentation.view.auth.screen

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenFingerBinding

@AndroidEntryPoint
class FingerScreen : Fragment(R.layout.screen_finger) {
    private val binding by viewBinding(ScreenFingerBinding::bind)
}
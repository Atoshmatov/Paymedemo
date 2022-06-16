package uz.gita.paymedemo.presentation.view.auth.pincode.screen

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenPincodeBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.pincode.PinCodeViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.pincode.impl.PinCodeViewModelImpl

@AndroidEntryPoint
class PinCodeScreen : Fragment(R.layout.screen_pincode) {
    private val binding by viewBinding(ScreenPincodeBinding::bind)
    private val viewModel: PinCodeViewModel by viewModels<PinCodeViewModelImpl>()
}
package uz.gita.paymedemo.presentation.ui.auth.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenPincodeBinding

abstract class BasePinCodeScreen : Fragment(R.layout.screen_pincode) {
    protected val binding: ScreenPincodeBinding by viewBinding(ScreenPincodeBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
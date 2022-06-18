package uz.gita.paymedemo.presentation.view.auth.screen

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenPincodeBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.PinCodeViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.PinCodeViewModelImpl

@AndroidEntryPoint
class PinCodeScreen : Fragment(R.layout.screen_pincode) {
    private val binding by viewBinding(ScreenPincodeBinding::bind)
    private val viewModel: PinCodeViewModel by viewModels<PinCodeViewModelImpl>()
    private val numberList = ArrayList<TextView>()
    private val pincodeList = ArrayList<TextView>()
    private val code = StringBuilder(4)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loadView()
    }


    private fun loadView() {
        binding.keyboard3.apply {
            pincodeList.add(btOne)
            pincodeList.add(btTwo)
            pincodeList.add(btThree)
            pincodeList.add(btFour)
        }
        binding.keyboard.apply {
            numberList.add(btZero)
            numberList.add(btOne)
            numberList.add(btTwo)
            numberList.add(btThree)
            numberList.add(btFour)
            numberList.add(btFive)
            numberList.add(btSix)
            numberList.add(btSeven)
            numberList.add(btEight)
            numberList.add(btNine)
        }

        for (i in 0 until 10) {
            numberList[i].setOnClickListener {
                if (code.length == 4)
                    return@setOnClickListener
                code.append(i)
               Timber.tag("code")
            }
        }
    }
}


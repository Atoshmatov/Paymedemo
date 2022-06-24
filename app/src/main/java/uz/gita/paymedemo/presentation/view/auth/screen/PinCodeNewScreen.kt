package uz.gita.paymedemo.presentation.view.auth.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.paymedemo.NavGraphDirections
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenPincodeBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.PinCodeNewViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.PinCodeNewViewModelImpl

@AndroidEntryPoint
class PinCodeNewScreen : Fragment(R.layout.screen_pincode) {
    private val binding by viewBinding(ScreenPincodeBinding::bind)
    private val viewModel: PinCodeNewViewModel by viewModels<PinCodeNewViewModelImpl>()
    private val numberList = ArrayList<CardView>()
    private val pincodeList = ArrayList<AppCompatImageView>()
    private var code = StringBuilder(4)
    private var shared: SharedPrefToken? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openMainScreenLiveData.observe(this@PinCodeNewScreen, openMainScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        shared = SharedPrefToken(requireContext())
        subscriber()
        loadView()
        clearCode()
        enterPincodeText.text = resources.getString(R.string.enter_new_password)
        keyboard1.btConfirm.visibility = View.INVISIBLE
    }

    //observer Object
    private val openMainScreenObserver = Observer<Unit> {
        val navOption = NavOptions.Builder()
            .setPopUpTo(R.id.pinCodeNewScreen, true).build()
        val action = NavGraphDirections.actionGlobalMainScreen()
        findNavController().navigate(action, navOption)
    }

    //view Model Observer
    private fun subscriber() = with(viewModel) {}

    //call back function
    private fun loadView() {
        binding.keyboard1.apply {
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

        pincodeList.add(binding.imageviewCircle1)
        pincodeList.add(binding.imageviewCircle2)
        pincodeList.add(binding.imageviewCircle3)
        pincodeList.add(binding.imageviewCircle4)

        for (i in 0 until 10) {
            numberList[i].setOnClickListener {
                if (code.length == 4)
                    return@setOnClickListener
                code.append(i)
                Timber.tag("code").d("$code")
                for (j in code.indices) {
                    pincodeList[j].setBackgroundResource(R.drawable.pincode_2)
                }
                shared!!.code = code.toString()
                if (code.length == 4)
                    viewModel.openMainScreen()
            }
        }
    }

    private fun clearCode() {
        binding.keyboard1.btClear.setOnClickListener {
            if (code.isEmpty())
                return@setOnClickListener
            pincodeList[code.length - 1].setBackgroundResource(R.drawable.pincode_1)
            code.deleteCharAt(code.length - 1)
        }
    }
}
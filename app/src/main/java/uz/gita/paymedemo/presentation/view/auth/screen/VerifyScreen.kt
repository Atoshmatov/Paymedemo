package uz.gita.paymedemo.presentation.view.auth.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.data.remote.request.auth.VerifyRequest
import uz.gita.paymedemo.databinding.ScreenVerifyBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.VerifyVIewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.VerifyViewModelImpl
import uz.gita.paymedemo.utils.showToast
import uz.gita.paymedemo.utils.values

@AndroidEntryPoint
class VerifyScreen:Fragment(R.layout.screen_verify) {
    private val binding by viewBinding(ScreenVerifyBinding::bind)
    private val viewModel: VerifyVIewModel by viewModels<VerifyViewModelImpl>()
    private val args: VerifyScreenArgs by navArgs()
    private val numberList = ArrayList<TextView>(10)
    private var code = StringBuilder(6)
    private var shared: SharedPrefToken? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openPinCodeScreenLiveDate.observe(this@VerifyScreen, openPinCodeScreeObserver)
    }

    @SuppressLint("SetTextI18n", "FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        loadViews()
        shared = SharedPrefToken(requireContext())
        keyboard2.btClear.setOnClickListener {
            if (code.isEmpty()) return@setOnClickListener
            code.deleteCharAt(code.length - 1)
            verifyCode.setText(code.toString())
        }
        keyboard2.btClear.setOnLongClickListener {
            if (code.isEmpty()) return@setOnLongClickListener true
            code.clear()
            return@setOnLongClickListener true
        }
        keyboard2.btConfirm.setOnClickListener {
            viewModel.codeVerifyUser(
                VerifyRequest(
                    args.number,
                    verifyCode.values()
                )
            )
        }


        val number = resources.getString(R.string.text_phone_number)
        verifyCodeNumber.text = number + args.number
        Timber.tag("NUmber").d(args.number)
        Timber.tag("NUmber").d("${verifyCodeNumber.text}")
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorObserver)
        viewModel.notConnectionLiveData.observe(viewLifecycleOwner, notConnectionObserver)
        viewModel.progressLiveDate.observe(viewLifecycleOwner, progressObserver)
    }

    private val errorObserver = Observer<String> { showToast(it) }
    private val notConnectionObserver = Observer<Unit> { showToast("Sizda internet mavjud emas") }
    private val progressObserver = Observer<Boolean> {
//        if (it) binding.progress.show()
//        else binding.progress.hide()
    }
    private val openPinCodeScreeObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_verifyScreen_to_pinCodeScreen)
        shared!!.id = 2
    }

    private fun loadViews() {
        binding.keyboard2.apply {
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
                if (code.length == 6)
                    return@setOnClickListener
                code.append(i)
                binding.verifyCode.setText(code.toString())
            }
        }
    }

}
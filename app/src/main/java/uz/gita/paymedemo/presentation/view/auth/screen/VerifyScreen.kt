package uz.gita.paymedemo.presentation.view.auth.screen

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.data.remote.request.auth.CodeRequest
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        shared = SharedPrefToken(requireContext())
        // init function
        loadViews()
        clearCode()
        clearLongCode()
        verifyCode()

        // number send sms code
        val number = resources.getString(R.string.text_phone_number)
        verifyCodeNumber.text = number + args.number
        //action
        backScreen.setOnClickListener {
            viewModel.backRegisterScreen()
        }
        //observer
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorObserver)
        viewModel.notConnectionLiveData.observe(viewLifecycleOwner, notConnectionObserver)
        viewModel.progressLiveDate.observe(viewLifecycleOwner, progressObserver)
        viewModel.backRegisterScreenLiveDate.observe(viewLifecycleOwner, backRegisterScreenObserver)
    }

    //Observer Object
    private val errorObserver = Observer<String> { showToast(it) }
    private val notConnectionObserver = Observer<Unit> { showToast("Sizda internet mavjud emas") }
    private val progressObserver = Observer<Boolean> {
        if (it) {
            binding.verifyProgress1.show()
            binding.verifyProgress2.show()
        } else {
            binding.verifyProgress1.hide()
            binding.verifyProgress2.hide()
        }
    }
    private val openPinCodeScreeObserver = Observer<Unit> {
        val navOption = NavOptions.Builder()
            .setPopUpTo(R.id.signUPScreen, true).build()
        findNavController().navigate(R.id.action_verifyScreen_to_pinCodeNewScreen, null, navOption)
        shared!!.id = 2
    }
    private val backRegisterScreenObserver = Observer<Unit> {
        requireActivity().onBackPressed()
    }


    //function private
    private fun loadViews() {
        binding.keyboard2.apply {
            numberList.add(verifyBtZero)
            numberList.add(verifyBtOne)
            numberList.add(verifyBtTwo)
            numberList.add(verifyBtThree)
            numberList.add(verifyBtFour)
            numberList.add(verifyBtFive)
            numberList.add(verifyBtSix)
            numberList.add(verifyBtSeven)
            numberList.add(verifyBtEight)
            numberList.add(verifyBtNine)
        }
        for (i in 0 until 10) {
            numberList[i].setOnClickListener {
                if (code.length == 6) {
                    binding.keyboard2.verifyBtConfirm.visibility = View.VISIBLE
                    return@setOnClickListener
                }
                code.append(i)
                if (code.length == 6)
                    binding.keyboard2.verifyBtConfirm.visibility = View.VISIBLE
                binding.verifyCode.setText(code.toString())
            }
        }
    }
    private fun clearCode() {
        binding.keyboard2.verifyBtClear.setOnClickListener {
            if (code.isEmpty()) return@setOnClickListener
            code.deleteCharAt(code.length - 1)
            binding.keyboard2.verifyBtConfirm.visibility = View.GONE
            binding.verifyCode.setText(code.toString())
        }
    }
    private fun clearLongCode() = with(binding) {
        keyboard2.verifyBtClear.setOnLongClickListener {
            if (code.isEmpty()) return@setOnLongClickListener true
            code.clear()
            binding.keyboard2.verifyBtConfirm.visibility = View.GONE
            verifyCode.setText("")
            return@setOnLongClickListener true
        }
    }
    private fun verifyCode() = with(binding) {
        keyboard2.verifyBtConfirm.setOnClickListener {
            viewModel.codeVerifyUser(CodeRequest(verifyCode.values()))
        }
    }
}
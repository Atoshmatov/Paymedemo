package uz.gita.paymedemo.presentation.view.auth.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.data.remote.request.auth.SignUpRequest
import uz.gita.paymedemo.databinding.ScreenSignupBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.SignUpViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.SignUPViewModelImpl
import uz.gita.paymedemo.utils.addListener
import uz.gita.paymedemo.utils.values

@AndroidEntryPoint
class SignUPScreen : Fragment(R.layout.screen_signup) {
    private val binding by viewBinding(ScreenSignupBinding::bind)
    private val viewModel: SignUpViewModel by viewModels<SignUPViewModelImpl>()
    private var boolFirstName = false
    private var boolLastName = false
    private var boolPhoneNumber = false
    private var boolPassword = false
    private var checked = false
    private var shared: SharedPrefToken? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openVerifyScreenLiveData.observe(this@SignUPScreen, openVerifyScreenObserver)
    }

    @SuppressLint("ResourceAsColor", "FragmentLiveDataObserve", "ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        shared = SharedPrefToken(requireContext())
        listener()
        singUpButton.isEnabled = false
        singUpButton.setOnClickListener {
            viewModel.registerUser(
                SignUpRequest(
                    firstName.values(),
                    lastName.values(),
                    phoneNumber.values(),
                    password.values(),
                )
            )
        }
    }


    //observer Object
    private val openVerifyScreenObserver = Observer<Unit> {
        val navOption = NavOptions.Builder()
            .setPopUpTo(R.id.policeScreen, true).build()
        findNavController().navigate(
            SignUPScreenDirections.actionSignUPScreenToVerifyScreen(binding.phoneNumber.values()),
            navOption
        )
    }

    //additional features
    private fun subscribers() = with(viewModel) {

    }
    private fun listener() = with(binding) {
        firstName.addListener {
            boolFirstName = it.length in 5..20
            check()
        }
        lastName.addListener {
            boolLastName = it.length in 5..20
        }
        phoneNumber.addListener {
            boolPhoneNumber =
                it.length == 17 && "\\+998[\\ 0-9]*\$".toRegex().matches(it)
            check()
        }
        password.addListener {
            boolPassword = (it.length in 5..8)
            check()
            shared!!.password = it
            Timber.tag("NUMBER").d("$it")
        }
    }
    private fun check() {
        checked = boolFirstName && boolLastName && boolPhoneNumber && boolPassword
        binding.singUpButton.isEnabled = checked
        if (checked) {
            binding.singUpButton.setTextColor(resources.getColor(R.color.white))
        } else {
            binding.singUpButton.setTextColor(resources.getColor(R.color.hint_color))
        }
    }

}
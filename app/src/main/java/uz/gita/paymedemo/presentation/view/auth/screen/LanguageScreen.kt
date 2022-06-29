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
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenLanguageBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.LanguageVIewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.LanguageVIewModelImpl
import uz.gita.paymedemo.utils.LocaleHelper

@AndroidEntryPoint
class LanguageScreen : Fragment(R.layout.screen_language) {
    private val binding by viewBinding(ScreenLanguageBinding::bind)
    private val viewModel: LanguageVIewModel by viewModels<LanguageVIewModelImpl>()
    private var shared: SharedPrefToken? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = SharedPrefToken(requireContext())
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewModel.openSignUpScreen.observe(this@LanguageScreen, openSignUpObserver)

        rusButton.setOnClickListener {
            shared?.language = "ru"
            LocaleHelper.setLocale(requireContext(), "ru")
            viewModel.openSingUp()
        }
        uzButton.setOnClickListener {
            shared?.language = "uz"
            LocaleHelper.setLocale(requireContext(), "uz")
            viewModel.openSingUp()
        }
        engButton.setOnClickListener {
            LocaleHelper.setLocale(requireContext(), "en")
            shared?.language = "en"
            viewModel.openSingUp()
        }
    }

    private val openSignUpObserver = Observer<Unit> {
        val navOption = NavOptions.Builder()
            .setPopUpTo(R.id.splashScreen, true).build()
        findNavController().navigate(R.id.action_languageScreen_to_introScreen)
    }
}
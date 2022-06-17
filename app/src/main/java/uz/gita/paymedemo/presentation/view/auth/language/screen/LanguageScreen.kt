package uz.gita.paymedemo.presentation.view.auth.language.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.BuildConfig
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenLanguageBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.language.LanguageVIewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.language.impl.LanguageVIewModelImpl

@AndroidEntryPoint
class LanguageScreen : Fragment(R.layout.screen_language) {
    private val binding by viewBinding(ScreenLanguageBinding::bind)
    private val viewModel: LanguageVIewModel by viewModels<LanguageVIewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openSignUpScreen.observe(this@LanguageScreen, openSignUpObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        paymeVersion.text = resources.getString(R.string.text_splash_payme, BuildConfig.VERSION_NAME)
        uzButton.setOnClickListener {
            viewModel.openSingUp()
        }
        rusButton.setOnClickListener {
            viewModel.openSingUp()
        }
        engButton.setOnClickListener {
            viewModel.openSingUp()
        }
    }


    private val openSignUpObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_languageScreen_to_policeScreen)
    }
}
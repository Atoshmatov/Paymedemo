package uz.gita.paymedemo.presentation.view.splash.screen

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenSplashBinding
import uz.gita.paymedemo.presentation.viewmodel.splash.SplashViewModel
import uz.gita.paymedemo.presentation.viewmodel.splash.impl.SplashViewModelImpl
import uz.gita.paymedemo.utils.boradcast.ConnectionBroad

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {
    private val binding by viewBinding(ScreenSplashBinding::bind)
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()
    private lateinit var shared: SharedPrefToken
    private lateinit var reciver: ConnectionBroad


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openLanguageScreen.observe(this@SplashScreen, openLanguageObserver)
        reciver = ConnectionBroad()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            requireActivity().registerReceiver(reciver, it)
            Timber.tag("TTT").d(it.toString())
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        shared = SharedPrefToken(requireContext())
    }

    private val notConnectionObserver = Observer<Boolean> {

    }
    private val openLanguageObserver = Observer<Unit> {
        if (shared.acessToken.isEmpty() && shared.refreshToken.isEmpty() && shared.id == 0) {
            findNavController().navigate(R.id.action_splashScreen_to_languageScreen)
        } else if (shared.acessToken.isEmpty() && shared.refreshToken.isEmpty() && shared.id == 1) {
            findNavController().navigate(R.id.action_splashScreen_to_signUPScreen)
        } else if (shared.acessToken.isNotEmpty() && shared.refreshToken.isNotEmpty() && shared.id == 2) {
            findNavController().navigate(R.id.action_splashScreen_to_pinCodeScreen)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.openLanguageScreen.removeObservers(this@SplashScreen)
    }
}
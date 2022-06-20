package uz.gita.paymedemo.presentation.view.auth.screen

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.paymedemo.BuildConfig
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenLanguageBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.LanguageVIewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.LanguageVIewModelImpl
import java.util.*

@AndroidEntryPoint
class LanguageScreen : Fragment(R.layout.screen_language) {
    private val binding by viewBinding(ScreenLanguageBinding::bind)
    private val viewModel: LanguageVIewModel by viewModels<LanguageVIewModelImpl>()
    private var shared: SharedPrefToken? = null
    private var onClickRuListener1: ((Int) -> Unit)? = null
    private var onClickUzbListener2: ((Int) -> Unit)? = null
    private var onClickEngListener3: ((Int) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = SharedPrefToken(requireContext())
        viewModel.openSignUpScreen.observe(this@LanguageScreen, openSignUpObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        paymeVersion.text =
            resources.getString(R.string.text_splash_payme, BuildConfig.VERSION_NAME)
        rusButton.setOnClickListener {
            Timber.d("Click1 ${shared?.language}")
            onClickRuListener1?.invoke(1)
            onOptionsItemSelected(1)
            shared?.language = 1
            viewModel.openSingUp()
        }
        uzButton.setOnClickListener {
            Timber.d("Click2  ${shared?.language}")
            onClickUzbListener2?.invoke(2)
            onOptionsItemSelected(2)
            shared?.language = 2
            viewModel.openSingUp()
        }
        engButton.setOnClickListener {
            Timber.d("Click3  ${shared?.language}")
            onClickEngListener3?.invoke(3)
            onOptionsItemSelected(3)
            shared?.language = 3
            viewModel.openSingUp()
        }
    }

    private fun onOptionsItemSelected(id: Int) {
        var languageToLoad = "en"
        languageToLoad = when (id) {
            1 -> {
                "ru"
            }
            2 -> {
                "uz"
            }
            else -> {
                "en"
            }
        }
        val locale = Locale(languageToLoad);
        Locale.setDefault(locale);
        val config = Configuration();
        config.locale = locale;
        requireContext().resources.updateConfiguration(
            config,
            requireContext().resources.displayMetrics
        )
    }


    private val openSignUpObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_languageScreen_to_policeScreen)
    }

    //call back function
    fun setonClickRuListener1(block: (Int) -> Unit) {
        onClickRuListener1 = block
    }

    fun setonClickUzbListener2(block: (Int) -> Unit) {
        onClickUzbListener2 = block
    }

    fun setonClickEngListener3(block: (Int) -> Unit) {
        onClickEngListener3 = block
    }
}
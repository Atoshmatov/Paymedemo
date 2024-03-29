package uz.gita.paymedemo.presentation.ui.auth.screen

import android.content.Intent
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.os.Bundle
import android.os.CancellationSignal
import android.provider.Settings
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
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
import uz.gita.paymedemo.presentation.viewmodel.auth.PinCodeViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.PinCodeViewModelImpl
import uz.gita.paymedemo.utils.myApply
import java.util.concurrent.Executor


@AndroidEntryPoint
class PinCodeScreen : Fragment(R.layout.screen_pincode) {
    private var cancellationSignal: CancellationSignal? = null

    /* private val authenticationCallback: BiometricPrompt.AuthenticationCallback
         get() =
             @RequiresApi(Build.VERSION_CODES.P)
             object : BiometricPrompt.AuthenticationCallback() {
                 override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                     super.onAuthenticationError(errorCode, errString)
                     notifyUser("Authentication error: $errString")
                 }

                 override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                     super.onAuthenticationSucceeded(result)
                     notifyUser("Authentication Success!")
                     startActivity(Intent(requireContext(), Secret::class.java))
                 }
             }

     @RequiresApi(Build.VERSION_CODES.P)*/
    private val binding by viewBinding(ScreenPincodeBinding::bind)
    private val viewModel: PinCodeViewModel by viewModels<PinCodeViewModelImpl>()
    private val numberList = ArrayList<CardView>()
    private val pincodeList = ArrayList<AppCompatImageView>()
    private var code = StringBuilder(4)
    private var shared: SharedPrefToken? = null
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo
    private val REQUEST_CODE = BiometricManager.BIOMETRIC_SUCCESS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openMainScreenLiveData.observe(this@PinCodeScreen, openMainScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {
        shared = SharedPrefToken(requireContext())
        loadView()
        clearCode()
        main.post {
            biometricId()
        }
    }

    //observer Object
    private val openMainScreenObserver = Observer<Unit> {
        val navOption = NavOptions.Builder()
            .setPopUpTo(R.id.pinCodeScreen, true).build()
        val action = NavGraphDirections.actionGlobalMainScreen()
        findNavController().navigate(action, navOption)
        shared!!.id = 2
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
                if (code.length == 4) return@setOnClickListener
                code.append(i)
                Timber.tag("code").d("$code")
                for (j in code.indices) {
                    pincodeList[j].setBackgroundResource(R.drawable.pincode_2)
                }
                if (code.toString() == shared!!.code)
                    viewModel.openMainScreen()
            }
        }
    }
    private fun biometricId() {
        val biometricManager = BiometricManager.from(requireContext())
        when (biometricManager.canAuthenticate(BIOMETRIC_STRONG)) {
            BiometricManager.BIOMETRIC_SUCCESS ->
                Timber.tag("MY_APP_TAG").d("App can authenticate using biometrics.")
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                Timber.tag("MY_APP_TAG").e("No biometric features available on this device.")
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                Timber.tag("MY_APP_TAG").e("Biometric features are currently unavailable.")
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                val enrollIntent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                    putExtra(
                        Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                        BIOMETRIC_STRONG
                    )
                }
                startActivityForResult(enrollIntent, REQUEST_CODE)
            }
        }
        executor = ContextCompat.getMainExecutor(requireContext())
        biometricPrompt = BiometricPrompt(requireActivity(), executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    for (j in 0 until 4) {
                        pincodeList[j].setBackgroundResource(R.drawable.pincode_2)
                    }
                    if (REQUEST_CODE == BiometricManager.BIOMETRIC_SUCCESS)
                        viewModel.openMainScreen()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Biometric login for my app")
            .setSubtitle("Log in using your biometric credential")
            .setNegativeButtonText("Use account password")
            .build()

        biometricPrompt.authenticate(promptInfo)
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


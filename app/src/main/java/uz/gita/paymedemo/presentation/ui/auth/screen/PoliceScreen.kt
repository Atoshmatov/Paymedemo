package uz.gita.paymedemo.presentation.ui.auth.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenPoliceBinding
import uz.gita.paymedemo.presentation.viewmodel.auth.PoliceViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.PoliceViewModelImpl

class PoliceScreen : Fragment(R.layout.screen_police) {
    private val binding by viewBinding(ScreenPoliceBinding::bind)
    private val viewModel: PoliceViewModel by viewModels<PoliceViewModelImpl>()
    private lateinit var shared: SharedPrefToken
    private var checked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = SharedPrefToken(requireContext())
    }


    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewModel.openSigInScreenLiveData.observe(this@PoliceScreen, openSigInScreenObserver)

        checkId.setOnCheckedChangeListener { _, p ->
            checked = p
            acceptBtn.isEnabled = checked
            if (checked) {
                checkId.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.police_text_color
                    )
                )
                acceptBtn.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.white
                    )
                )
            } else {
                checkId.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.text_color
                    )
                )
                acceptBtn.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), R.color.hint_color
                    )
                )
            }
        }

        acceptBtn.setOnClickListener {
            viewModel.openSingScreen()
        }
    }

    private val openSigInScreenObserver = Observer<Unit> {
        val navOption = NavOptions.Builder()
            .setPopUpTo(R.id.introScreen, true).build()
        findNavController().navigate(R.id.action_policeScreen_to_signUPScreen)
        shared.id = 1
    }
}
package uz.gita.paymedemo.presentation.view.police.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import timber.log.Timber
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.intro.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenPoliceBinding
import uz.gita.paymedemo.presentation.viewmodel.police.PoliceViewModel
import uz.gita.paymedemo.presentation.viewmodel.police.impl.PoliceViewModelImpl

class PoliceScreen : Fragment(R.layout.screen_police) {
    private val binding by viewBinding(ScreenPoliceBinding::bind)
    private val viewModel: PoliceViewModel by viewModels<PoliceViewModelImpl>()
    private lateinit var shared: SharedPrefToken
    private var checked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = SharedPrefToken(requireContext())
        viewModel.openSigInScreenLiveData.observe(this@PoliceScreen, openSigInScreenObserver)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        checkId.setOnCheckedChangeListener { button, p ->
            checked = p
            acceptBtn.isEnabled = checked
            Timber.tag("AAA").d("$p")
            Timber.tag("AAA").d("checed $checked")
            if (!p) {
                acceptBtn.setTextColor(resources.getColor(R.color.text_color_black))
                button.setTextColor(resources.getColor(R.color.text_color_black))
            } else {
                acceptBtn.setTextColor(resources.getColor(R.color.white))
                button.setTextColor(resources.getColor(R.color.main_color))
            }

        }

        acceptBtn.setOnClickListener {
            viewModel.openSingScreen()
        }
    }

    private val openSigInScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_policeScreen_to_signUPScreen)
        shared.id = 1
    }
}
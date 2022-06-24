package uz.gita.paymedemo.presentation.view.auth.screen

import android.os.Bundle
import android.view.View
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
        viewModel.openSigInScreenLiveData.observe(this@PoliceScreen, openSigInScreenObserver)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        checkId.setOnCheckedChangeListener { _, p ->
            checked = p
            acceptBtn.isEnabled = checked
            if (checked) {
                checkId.setTextColor(resources.getColor(R.color.police_text_color))
                acceptBtn.setTextColor(resources.getColor(R.color.white))
            }else {
                checkId.setTextColor(resources.getColor(R.color.text_color))
                acceptBtn.setTextColor(resources.getColor(R.color.hint_color))
            }
        }

        acceptBtn.setOnClickListener {
            viewModel.openSingScreen()
        }
    }

    private val openSigInScreenObserver = Observer<Unit> {
        val navOption = NavOptions.Builder()
            .setPopUpTo(R.id.policeScreen, true).build()
        findNavController().navigate(R.id.action_policeScreen_to_signUPScreen, null, navOption)
        shared.id = 1
    }
}
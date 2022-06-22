package uz.gita.paymedemo.presentation.view.auth.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenIntroBinding
import uz.gita.paymedemo.presentation.view.auth.adapter.IntroAdapter
import uz.gita.paymedemo.presentation.viewmodel.auth.IntroViewModel
import uz.gita.paymedemo.presentation.viewmodel.auth.impl.IntroViewModelImpl


@AndroidEntryPoint
class IntroScreen : Fragment(R.layout.screen_intro) {
    private lateinit var listener: ViewPager2.OnPageChangeCallback
    private val binding by viewBinding(ScreenIntroBinding::bind)
    private val viewModel: IntroViewModel by viewModels<IntroViewModelImpl>()
    lateinit var shared: SharedPrefToken


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shared = SharedPrefToken(requireContext())
        viewModel.openLanguageScreenLiveData.observe(this@IntroScreen, openLanguageScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        val introAdapter = IntroAdapter(childFragmentManager, lifecycle)
        introPager.adapter = introAdapter
        listener = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 3) {
                    nextButton.visibility = View.GONE
                    introTab.visibility = View.GONE
                    getStart.visibility = View.VISIBLE
                } else {
                    nextButton.visibility = View.VISIBLE
                    introTab.visibility = View.VISIBLE
                    getStart.visibility = View.GONE
                }
            }
        }
        introPager.registerOnPageChangeCallback(listener)

        nextButton.setOnClickListener {
            introPager.unregisterOnPageChangeCallback(listener)
            introPager.currentItem = introPager.currentItem + 1
            if (introPager.currentItem == 3) {
                introPager.registerOnPageChangeCallback(listener)
                nextButton.visibility = View.GONE
                introTab.visibility = View.GONE
                getStart.visibility = View.VISIBLE
            } else {
                introPager.registerOnPageChangeCallback(listener)
                nextButton.visibility = View.VISIBLE
                introTab.visibility = View.VISIBLE
                getStart.visibility = View.GONE
            }
        }
        TabLayoutMediator(introTab, introPager) { _, _ -> }.attach()

        getStart.setOnClickListener {
            Timber.tag("AAA")
            viewModel.openLang()
        }
        skip.setOnClickListener {
            viewModel.openLang()
        }
    }

    private val openLanguageScreenObserver = Observer<Unit> {
        val navOption = NavOptions.Builder()
            .setPopUpTo(R.id.splashScreen, true).build()
        findNavController().navigate(R.id.action_introScreen_to_policeScreen)
    }
}
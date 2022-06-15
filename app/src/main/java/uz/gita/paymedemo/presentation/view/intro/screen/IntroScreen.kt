package uz.gita.paymedemo.presentation.view.intro.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenIntroBinding
import uz.gita.paymedemo.presentation.view.intro.adapter.IntroAdapter
import uz.gita.paymedemo.presentation.viewmodel.intro.IntroViewModel
import uz.gita.paymedemo.presentation.viewmodel.intro.impl.IntroViewModelImpl


@AndroidEntryPoint
class IntroScreen : Fragment(R.layout.screen_intro) {
    private lateinit var listener: ViewPager2.OnPageChangeCallback
    private val binding by viewBinding(ScreenIntroBinding::bind)
    private val viewModel: IntroViewModel by viewModels<IntroViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        val introAdapter = IntroAdapter(childFragmentManager, lifecycle)
        introPager.adapter = introAdapter
        listener = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
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
            if (introPager.currentItem == 2) {
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
    }
}
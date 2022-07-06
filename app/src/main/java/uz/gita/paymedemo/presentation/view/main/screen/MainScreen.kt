package uz.gita.paymedemo.presentation.view.main.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.ScreenMainBinding
import uz.gita.paymedemo.presentation.view.main.adapter.MainAdapter
import uz.gita.paymedemo.presentation.viewmodel.main.MainViewModel
import uz.gita.paymedemo.presentation.viewmodel.main.impl.MainViewModelImpl

class MainScreen : Fragment(R.layout.screen_main) {
    private val binding by viewBinding(ScreenMainBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        val adapter = MainAdapter(childFragmentManager, lifecycle)
        mainViewPager.adapter = adapter
        mainViewPager.isUserInputEnabled = false
        mainBottomTab.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.basic -> viewModel.selectPagePosition(0)
                R.id.transfer -> viewModel.selectPagePosition(1)
                R.id.payment -> viewModel.selectPagePosition(2)
                R.id.services -> viewModel.selectPagePosition(3)
                R.id.cashFlow -> viewModel.selectPagePosition(4)
            }
            return@setOnItemSelectedListener true
        }
        viewModel.selectPagePositionLiveData.observe(viewLifecycleOwner, selectPagePositionObserver)
    }

    private val selectPagePositionObserver = Observer<Int> {
        binding.mainViewPager.currentItem = it
    }
}
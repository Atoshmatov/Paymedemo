package uz.gita.paymedemo.presentation.ui.main.screen

import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.local.SharedPrefToken
import uz.gita.paymedemo.databinding.ScreenMainNavBinding
import uz.gita.paymedemo.presentation.ui.main.adapter.MainAdapter
import uz.gita.paymedemo.presentation.viewmodel.main.MainViewModel
import uz.gita.paymedemo.presentation.viewmodel.main.impl.MainViewModelImpl
import uz.gita.paymedemo.utils.hideKeyboard


@AndroidEntryPoint
class MainScreen : Fragment(R.layout.screen_main_nav) {
    private val binding by viewBinding(ScreenMainNavBinding::bind)
    private val viewModel: MainViewModel by viewModels<MainViewModelImpl>()
    private var shared: SharedPrefToken? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.closeDraw()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        shared = SharedPrefToken(requireContext())
        val adapter = MainAdapter(childFragmentManager, lifecycle)
        liner.mainViewPager.adapter = adapter
        liner.mainViewPager.isUserInputEnabled = false
        liner.mainBottomTab.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.basic -> {
                    binding.liner.burgerItem.visibility = View.VISIBLE
                    viewModel.selectPagePosition(0)
                    viewModel.closeDraw()
                }
                R.id.transfer -> {
                    closeBurger()
                    viewModel.selectPagePosition(1)
                }
                R.id.payment -> {
                    closeBurger()
                    viewModel.selectPagePosition(2)
                }
                R.id.services -> {
                    closeBurger()
                    viewModel.selectPagePosition(3)
                }
                R.id.cashFlow -> {
                    closeBurger()
                    viewModel.selectPagePosition(4)
                }
            }
            return@setOnItemSelectedListener true
        }
        liner.burger.setOnClickListener {
            viewModel.openDraw()
        }
        viewModel.selectPagePositionLiveData.observe(viewLifecycleOwner, selectPagePositionObserver)
        viewModel.openDrawLiveData.observe(viewLifecycleOwner, openDrawObserver)
        viewModel.closeDrawLiveData.observe(viewLifecycleOwner, closeDrawObserver)
        userName()
//        register()
    }

    private val openDrawObserver = Observer<Unit> {
        binding.draw.openDrawer(GravityCompat.START)
    }
    private val closeDrawObserver = Observer<Unit> {
        binding.draw.closeDrawer(GravityCompat.START)
        hideKeyboard()
    }
    private val selectPagePositionObserver = Observer<Int> {
        binding.liner.mainViewPager.currentItem = it
    }

    //function
    private fun closeBurger() {
        binding.liner.burgerItem.visibility = View.GONE
        viewModel.closeDraw()
    }

    private fun userName() = with(binding) {
        userName.text = shared!!.userName1 + " " + shared!!.userName2
        userPhoneNumber.text = shared!!.phoneNumber
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}




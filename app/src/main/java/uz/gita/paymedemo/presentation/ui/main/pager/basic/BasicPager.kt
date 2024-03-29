package uz.gita.paymedemo.presentation.ui.main.pager.basic

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.remote.response.main.basic.Basic
import uz.gita.paymedemo.databinding.PagerBasicBinding
import uz.gita.paymedemo.presentation.ui.main.pager.basic.adapter.BasicAdapter
import uz.gita.paymedemo.presentation.ui.main.screen.MainScreenDirections
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.BasicViewModel
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.impl.BasicViewModelImpl

@AndroidEntryPoint
class BasicPager : Fragment(R.layout.pager_basic) {
    private val binding by viewBinding(PagerBasicBinding::bind)
    private val viewModel: BasicViewModel by viewModels<BasicViewModelImpl>()
    private val basicAdapter = BasicAdapter()
    private var summa = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openCardScreenLiveData.observe(this@BasicPager, openCardScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        myCardListItem.adapter = basicAdapter
        myCardListItem.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewModel.loadCard()
        myCardListItem.smoothScrollBy(5, 0)
        viewModel.cardListLIveData.observe(viewLifecycleOwner, cardListObserver)
        myCardsMore.setOnClickListener {
            viewModel.openCardScreen()
        }
        myCard.setOnClickListener {
            viewModel.openCardScreen()
        }
    }

    private val cardListObserver = Observer<List<Basic.CardAddResponse>> {
        basicAdapter.submitList(it)
    }

    private val openCardScreenObserver = Observer<Unit> {
        findNavController().navigate(MainScreenDirections.actionMainScreenToCardScreen())
    }
    private val closeDrawObserver = Observer<Unit> {

    }
}
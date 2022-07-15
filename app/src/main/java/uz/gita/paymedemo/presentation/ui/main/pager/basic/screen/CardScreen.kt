package uz.gita.paymedemo.presentation.ui.main.pager.basic.screen

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
import uz.gita.paymedemo.databinding.ScreenCardsBinding
import uz.gita.paymedemo.presentation.ui.main.pager.basic.adapter.CardAdapter
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.CardViewModel
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.impl.CardsViewModelImpl

@AndroidEntryPoint
class CardScreen:Fragment(R.layout.screen_cards) {
    private val binding by viewBinding(ScreenCardsBinding::bind)
    private val viewModel: CardViewModel by viewModels<CardsViewModelImpl>()
    private var card: CardAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openAddCardScreenLiveData.observe(this@CardScreen, openAddCardScreenObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        card = CardAdapter(requireContext())
        recyclerView.adapter = card
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewModel.getAllCard()
        addCard.setOnClickListener {
            viewModel.openAddScreen()
        }
        backScreen.setOnClickListener {
            viewModel.backScreen()
        }
        viewModel.cardListLiveData.observe(viewLifecycleOwner, cardListObserver)
        viewModel.placeHolderLiveData.observe(viewLifecycleOwner, placeHolderObserver)
        viewModel.progressLiveData.observe(viewLifecycleOwner, progressObserver)
        viewModel.backScreenLiveData.observe(viewLifecycleOwner, backScreenObserver)
    }

    private val backScreenObserver = Observer<Unit> {
        requireActivity().onBackPressed()
    }
    private val progressObserver = Observer<Boolean> {
        if (it) {
            binding.signProgress1.show()
            binding.signProgress2.show()
        } else {
            binding.signProgress1.hide()
            binding.signProgress2.hide()
        }
    }
    private val placeHolderObserver = Observer<Boolean> {
        if (it) {
            binding.placeHolderImage.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE
        } else {
            binding.placeHolderImage.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        }
    }
    private val cardListObserver = Observer<List<Basic.CardAddResponse>> {
        card?.submitList(it)
    }
    private val openAddCardScreenObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_cardScreen_to_addCardScreen)
    }
}
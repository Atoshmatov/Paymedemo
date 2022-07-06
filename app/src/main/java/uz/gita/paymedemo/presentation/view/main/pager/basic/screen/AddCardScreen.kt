package uz.gita.paymedemo.presentation.view.main.pager.basic.screen

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.common.models.ThemeModel
import uz.gita.paymedemo.data.remote.request.main.basic.BasicRequest
import uz.gita.paymedemo.databinding.ScreenAddCardBinding
import uz.gita.paymedemo.presentation.view.main.pager.basic.adapter.CardScreenAdapter
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.AddCardViewModel
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.impl.AddCardViewModelImpl
import uz.gita.paymedemo.utils.addListener
import uz.gita.paymedemo.utils.myApply
import uz.gita.paymedemo.utils.values


@AndroidEntryPoint
class AddCardScreen : Fragment(R.layout.screen_add_card) {
    private val binding by viewBinding(ScreenAddCardBinding::bind)
    private val viewModel: AddCardViewModel by viewModels<AddCardViewModelImpl>()
    private var boolCardCode = false
    private var boolCardTime = false
    private var boolCardName = false
    private var checked = false
    private val cardScreenAdapter = CardScreenAdapter()
    private var themeId = 1


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {
        super.onViewCreated(view, savedInstanceState)
        listener()
        cardAddImageFon.cardBgImage.setBackgroundResource(R.drawable.card_bg_1)
        itemColorList.adapter = cardScreenAdapter
        itemColorList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        viewModel.loadList()

        cardScreenAdapter.setOnclickItemListener {
            themeId = it
            when (it) {
                0 -> {
                    cardAddImageFon.cardBgImage.setBackgroundResource(R.drawable.card_bg_1)
                }
                1 -> {
                    cardAddImageFon.cardBgImage.setBackgroundResource(R.drawable.card_bg_2)
                }
                2 -> {
                    cardAddImageFon.cardBgImage.setBackgroundResource(R.drawable.card_bg_3)
                }
                3 -> {
                    cardAddImageFon.cardBgImage.setBackgroundResource(R.drawable.card_bg_4)
                }
                4 -> {
                    cardAddImageFon.cardBgImage.setBackgroundResource(R.drawable.card_bg_5)
                }
                5 -> {
                    cardAddImageFon.cardBgImage.setBackgroundResource(R.drawable.card_bg_6)
                }
                else -> {
                   cardAddImageFon.cardBgImage.setBackgroundResource(R.drawable.card_bg_1)
                }
            }
        }
        viewModel.colorListLiveData.observe(viewLifecycleOwner, colorListObserver)
        addCardButton.setOnClickListener {
            viewModel.addCard(
                BasicRequest.CardAddRequest(
                    cardCode.values(),
                    time.values(),
                    cardText.values(),
                    themeId
                )
            )
        }

    }

    //observer object
    private val colorListObserver = Observer<List<ThemeModel>> {
        cardScreenAdapter.submitList(it)
    }

    //function
    private fun listener() = with(binding) {
        cardCode.addListener {
            boolCardCode = it.length == 16 && "[0-9]*$".toRegex().matches(it)
            check()
        }
        time.addListener {
            boolCardTime = it.length == 4 && "[0-9]*$".toRegex().matches(it)
            check()
        }
        cardText.addListener {
            boolCardName =
                it.length in 5..20 && "[A-Za-z]*".toRegex().matches(it)
            check()
        }
    }

    private fun check() {
        checked = boolCardCode && boolCardName && boolCardTime
        binding.addCardButton.isEnabled = checked
        if (checked) {
            binding.addCardButton.setTextColor(
                ContextCompat.getColor(
                    requireContext(), R.color.white
                )
            )
        } else {
            binding.addCardButton.setTextColor(
                ContextCompat.getColor(
                    requireContext(), R.color.hint_color
                )
            )
        }
    }
}
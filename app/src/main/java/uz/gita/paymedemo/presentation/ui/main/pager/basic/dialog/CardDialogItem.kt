package uz.gita.paymedemo.presentation.ui.main.pager.basic.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.data.common.models.BottomCardModel
import uz.gita.paymedemo.data.remote.response.main.basic.Basic
import uz.gita.paymedemo.databinding.CardDialogBottomBinding
import uz.gita.paymedemo.presentation.ui.main.adapter.CardItemAdapter
import uz.gita.paymedemo.presentation.viewmodel.main.CardViewModel
import uz.gita.paymedemo.presentation.viewmodel.main.impl.CardViewModelImpl

@AndroidEntryPoint
class CardDialogItem(
    private val data: Basic.CardAddResponse,
) :
    BottomSheetDialogFragment() {
    private val adapter = CardItemAdapter()
    private val binding by viewBinding(CardDialogBottomBinding::bind)
    private val viewModel: CardViewModel by viewModels<CardViewModelImpl>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.card_dialog_bottom, container)
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        dialogBottomItemListCard.adapter = adapter
        dialogBottomItemListCard.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewModel.cardList.observe(viewLifecycleOwner, cardObserver)
        viewModel.getAllItem()
    }

    private val cardObserver = Observer<List<BottomCardModel>> {
        adapter.submitList(it)
    }
}
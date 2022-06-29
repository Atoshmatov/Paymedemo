package uz.gita.paymedemo.presentation.view.main.pager.basic

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.PagerBasicBinding
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.BasicViewModel
import uz.gita.paymedemo.presentation.viewmodel.main.pager.basic.impl.BasicViewModelImpl

@AndroidEntryPoint
class BasicPager : Fragment(R.layout.pager_basic) {
    private val binding by viewBinding(PagerBasicBinding::bind)
    private val viewModel: BasicViewModel by viewModels<BasicViewModelImpl>()
}
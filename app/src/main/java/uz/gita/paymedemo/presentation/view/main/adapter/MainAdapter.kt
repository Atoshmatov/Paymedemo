package uz.gita.paymedemo.presentation.view.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.paymedemo.presentation.view.main.pager.*

class MainAdapter(fm: FragmentManager, lf: Lifecycle) : FragmentStateAdapter(fm, lf) {
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BasicPager()
            1 -> TransferPager()
            2 -> PaymentPager()
            3 -> ServicePager()
            else -> CashFlowPager()
        }
    }
}
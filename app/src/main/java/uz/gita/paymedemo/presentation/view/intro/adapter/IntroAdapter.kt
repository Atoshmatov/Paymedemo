package uz.gita.paymedemo.presentation.view.intro.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.gita.paymedemo.presentation.view.intro.pager.IntroPager1
import uz.gita.paymedemo.presentation.view.intro.pager.IntroPager2
import uz.gita.paymedemo.presentation.view.intro.pager.IntroPager3

class IntroAdapter(fm: FragmentManager, lf: Lifecycle) : FragmentStateAdapter(fm, lf) {
    override fun getItemCount(): Int = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> IntroPager1()
            1 -> IntroPager2()
            else -> IntroPager3()
        }
    }
}
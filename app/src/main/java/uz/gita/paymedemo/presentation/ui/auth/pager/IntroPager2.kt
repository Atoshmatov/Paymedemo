package uz.gita.paymedemo.presentation.ui.auth.pager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.PagerIntro2Binding

class IntroPager2 : Fragment(R.layout.pager_intro2) {
    private val binding by viewBinding(PagerIntro2Binding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        Glide
            .with(intro2Image)
            .load(R.drawable.intro_2)
            .into(intro2Image)
        return@with
    }
}
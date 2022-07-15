package uz.gita.paymedemo.presentation.ui.auth.pager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.PagerIntro3Binding

class IntroPager3 : Fragment(R.layout.pager_intro3) {
    private val binding by viewBinding(PagerIntro3Binding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        Glide
            .with(intro3Image)
            .load(R.drawable.intro_3)
            .into(intro3Image)
        return@with
    }
}
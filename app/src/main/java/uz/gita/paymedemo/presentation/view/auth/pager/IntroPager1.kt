package uz.gita.paymedemo.presentation.view.auth.pager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import uz.gita.paymedemo.R
import uz.gita.paymedemo.databinding.PagerIntro1Binding

class IntroPager1 : Fragment(R.layout.pager_intro1) {
    private val binding by viewBinding(PagerIntro1Binding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        Glide
            .with(intro1Image)
            .load(R.drawable.intro_1)
            .into(intro1Image)
        return@with
    }
}
package uz.gita.paymedemo.presentation.view.auth.screen

import androidx.fragment.app.Fragment
import uz.gita.paymedemo.R

abstract class PincodeBase : Fragment(R.layout.screen_pincode) {
    abstract fun loadView()
    abstract fun clearCode()
}
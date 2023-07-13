package com.jyldyzferr.foodapp.presentation.onboarding_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jyldyzferr.foodapp.R
import com.jyldyzferr.foodapp.databinding.FragmentOnboardingBinding

class FragmentOnboarding : Fragment() {

   private val binding: FragmentOnboardingBinding by lazy {
       FragmentOnboardingBinding.inflate(layoutInflater)
   }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.getStartedButton.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentOnboarding_to_fragmentMain)
        }
    }
}

package com.example.lunchwallet.common.selectType

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentSelectTypeBinding

class SelectTypeFragment : Fragment() {

    private var _binding: FragmentSelectTypeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectTypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleClicks()
    }

    private fun handleClicks() {
        binding.selectTypeFragmentFoodBeneficiaryTv.setOnClickListener {
            findNavController().navigate(R.id.action_selectTypeFragment_to_signUpFragment)
        }
        binding.selectTypeFragmentKitchenStaffTv.setOnClickListener {
            findNavController().navigate(R.id.action_selectTypeFragment_to_kitchenStaffSignUpFragment)
        }
    }
}

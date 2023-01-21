package com.example.lunchwallet.common.resetpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentCheckMailResetPasswordBinding

class CheckMailResetPasswordFragment : Fragment() {
    private var _binding: FragmentCheckMailResetPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckMailResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.checkmailPasswordFragmentButtonFoodBeneficiary.setOnClickListener {
            findNavController().navigate(R.id.action_checkMailResetPasswordFragment_to_createNewPasswordFragment)
        }
        // Resend Instruction_Text Back to Reset_Password_Fragment
        binding.checkmailPasswordFragmentInstructionFoodBeneficiary.setOnClickListener {
            findNavController().navigate(R.id.action_checkMailResetPasswordFragment_to_resetPasswordFragment)
        }
    }
}

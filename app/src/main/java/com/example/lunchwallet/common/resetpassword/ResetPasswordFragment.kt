package com.example.lunchwallet.common.resetpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentResetPasswordBinding
import com.example.lunchwallet.util.ResetPasswordInputValidations.ResetPasswordValidation

class ResetPasswordFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentResetPasswordBinding
    private lateinit var errorMsg: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentResetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        errorMsg = binding.ResetPasswordErrorMsg
        emailFocusListener()

        // Reset_Password To CheckMailPassword
        binding.resetPasswordFragmentButtonFoodBeneficiary.setOnClickListener {
            onClickResetButton()
        }
    }

    private fun emailFocusListener() {
        binding.resetPasswordFragmentETFoodBeneficiary.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.resetPasswordFragmentTiIFoodBeneficiary.helperText =
                    ResetPasswordValidation.validateEmail(binding.resetPasswordFragmentETFoodBeneficiary.text.toString())
        }
    }

    private fun onClickResetButton() {
        binding.resetPasswordFragmentTiIFoodBeneficiary.helperText =
            ResetPasswordValidation.validateEmail(binding.resetPasswordFragmentETFoodBeneficiary.text.toString())

        val validEmailInput = ResetPasswordValidation.validateEmail(binding.resetPasswordFragmentETFoodBeneficiary.text.toString()) == null
        if (validEmailInput){
            findNavController().navigate(R.id.action_resetPasswordFragment_to_checkMailResetPasswordFragment)
        } else {
            binding.resetPasswordFragmentTiIFoodBeneficiary.helperText.toString()
        }
    }

}


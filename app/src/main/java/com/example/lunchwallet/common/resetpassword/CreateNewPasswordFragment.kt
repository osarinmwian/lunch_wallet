package com.example.lunchwallet.common.resetpassword


import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentCreateNewPasswordBinding
import com.example.lunchwallet.util.ResetPasswordInputValidations.CreateNewPasswordValidation



class CreateNewPasswordFragment : Fragment(R.layout.fragment_create_new_password) {

    private lateinit var binding: FragmentCreateNewPasswordBinding
    private lateinit var errorMsg: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout for this fragment
        binding = FragmentCreateNewPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    // initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        errorMsg = binding.ResetErrorMsg
        passwordNewFocusListener()
        passwordConfirmFocusListener()

        binding.createNewPasswordFragmentButtonFoodBeneficiary.setOnClickListener {
            onResetPasswordButtonClick()
            Log.d(
                "TAG",
                "onViewCreated: ${binding.createNewPasswordFragmentNewPasswordEtFoodBeneficiary.text}," +
                        " ${binding.createNewPasswordFragmentConfirmPasswordEtFoodBeneficiary.text}, " +
                        "${binding.createNewPasswordFragmentNewPasswordContainerFoodBeneficiary.helperText}, " +
                        binding.createNewPasswordFragmentConfirmPasswordContainerFoodBeneficiary.helperText.toString()
            )
        }
    }

    private fun passwordNewFocusListener() {
        binding.createNewPasswordFragmentNewPasswordEtFoodBeneficiary.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.createNewPasswordFragmentNewPasswordContainerFoodBeneficiary.helperText =
                    CreateNewPasswordValidation.validatePassword(binding.createNewPasswordFragmentNewPasswordEtFoodBeneficiary.text.toString())
        }
    }

    private fun passwordConfirmFocusListener() {
        binding.createNewPasswordFragmentConfirmPasswordEtFoodBeneficiary.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.createNewPasswordFragmentConfirmPasswordContainerFoodBeneficiary.helperText =
                    CreateNewPasswordValidation.validatePassword(binding.createNewPasswordFragmentConfirmPasswordEtFoodBeneficiary.text.toString())
        }
    }

    private fun onResetPasswordButtonClick() {
        binding.createNewPasswordFragmentNewPasswordContainerFoodBeneficiary.helperText =
            CreateNewPasswordValidation.validatePassword(binding.createNewPasswordFragmentNewPasswordEtFoodBeneficiary.text.toString())
        binding.createNewPasswordFragmentConfirmPasswordContainerFoodBeneficiary.helperText =
            CreateNewPasswordValidation.validateConfirmPassword(
                binding.createNewPasswordFragmentNewPasswordEtFoodBeneficiary.text.toString(),
                binding.createNewPasswordFragmentConfirmPasswordEtFoodBeneficiary.text.toString()
            )

        val validNewPasswordInput =
            CreateNewPasswordValidation.validatePassword(binding.createNewPasswordFragmentNewPasswordEtFoodBeneficiary.text.toString()) == null
        val validConfirmPasswordInput = CreateNewPasswordValidation.validateConfirmPassword(
            binding.createNewPasswordFragmentNewPasswordEtFoodBeneficiary.text.toString(),
            binding.createNewPasswordFragmentConfirmPasswordEtFoodBeneficiary.text.toString()
        ) == null

        if (validNewPasswordInput && validConfirmPasswordInput) {
            findNavController().navigate(R.id.action_createNewPasswordFragment_to_successModalFragment)
        } else {
            invalidCredentials()
        }
    }

    private fun invalidCredentials() {
        var message = ""
        if (binding.createNewPasswordFragmentNewPasswordContainerFoodBeneficiary.helperText != null) {
            message =
                "\n\nEmail: " + binding.createNewPasswordFragmentNewPasswordContainerFoodBeneficiary.helperText
        }

        if (binding.createNewPasswordFragmentConfirmPasswordContainerFoodBeneficiary.helperText != null) {
            message =
                "\n\nEmail: " + binding.createNewPasswordFragmentConfirmPasswordContainerFoodBeneficiary.helperText
        }
    }
}

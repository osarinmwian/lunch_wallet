package com.example.lunchwallet.kitchenstaff.signup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentKitchenStaffSignUpBinding
import com.example.lunchwallet.util.loginvalidation.LoginInputValidation
import com.example.lunchwallet.util.validation.FieldValidations

class KitchenStaffSignUpFragment : Fragment() {
    private lateinit var binding: FragmentKitchenStaffSignUpBinding

    companion object {
        fun newInstance() = KitchenStaffSignUpFragment()
    }

    private lateinit var viewModel: KitchenStaffSignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKitchenStaffSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[KitchenStaffSignUpViewModel::class.java]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameFocusListener()
        emailFocusListener()
        locationDropDown()
        passwordFocusListener()
        confirmPasswordFocusListener()


        binding.signUpBtn.setOnClickListener {
            submitForm()
        }

        binding.signUpToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_kitchenStaffSignUpFragment_to_loginFragment)
        }
    }

    private fun locationDropDown() {
        val location = resources.getStringArray(R.array.location)
        val adapter = ArrayAdapter(requireContext(), R.layout.location_list, location)
        adapter.setNotifyOnChange(true)
        with(binding.signUpLocationDropdown) {
            setAdapter(adapter)
//            setOnItemClickListener { adapterView, view, i, l ->
//
//            }
        }
    }

    private fun nameFocusListener() {
        binding.signUpFullNameTextView.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.fullNameContainer.helperText =
                    FieldValidations.verifyName(binding.signUpFullNameTextView.text.toString())
        }
    }

    private fun emailFocusListener() {
        binding.signUpEmailTextView.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.emailContainer.helperText =
                    LoginInputValidation.validateEmail(binding.signUpEmailTextView.text.toString())
        }
    }

    private fun locationFocusListener() {
        binding.signUpLocationDropdown.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.locationContainer.helperText =
                    FieldValidations.verifyLocation(binding.signUpLocationDropdown.text.toString())
        }
    }

    private fun passwordFocusListener() {
        binding.signUpPasswordTextView.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.passwordContainer.helperText =
                    FieldValidations.verifyPassword(binding.signUpPasswordTextView.text.toString())
        }
    }

    private fun confirmPasswordFocusListener() {
        binding.signUpConfirmPasswordTextView.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.confirmPasswordContainer.helperText =
                    FieldValidations.validateConfirmPassword(
                        binding.signUpPasswordTextView.text.toString(),
                        binding.signUpConfirmPasswordTextView.text.toString()
                    )
        }
    }

    private fun submitForm() {
        binding.fullNameContainer.helperText =
            FieldValidations.verifyName(binding.signUpFullNameTextView.text.toString())
        binding.emailContainer.helperText =
            LoginInputValidation.validateEmail(binding.signUpEmailTextView.text.toString())
        binding.locationContainer.helperText =
            FieldValidations.verifyLocation(binding.signUpLocationDropdown.text.toString())
        binding.passwordContainer.helperText =
            FieldValidations.verifyPassword(binding.signUpPasswordTextView.text.toString())
        binding.confirmPasswordContainer.helperText = FieldValidations.validateConfirmPassword(
            binding.signUpPasswordTextView.text.toString(),
            binding.signUpConfirmPasswordTextView.text.toString()
        )

        val validName = binding.fullNameContainer.helperText == null
        val validEmail = binding.emailContainer.helperText == null
        val validLocation = binding.locationContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null
        val validConfirmPassword = binding.confirmPasswordContainer.helperText == null

        if (validEmail && validName && validLocation && validPassword && validConfirmPassword) {
            findNavController().navigate(R.id.checkMailFragment)
        } else { invalidForm() }
    }

    private fun invalidForm() {
        var message = ""
        if (binding.fullNameContainer.helperText != null)
            message = "\n\nName: " + binding.emailContainer.helperText
        if (binding.emailContainer.helperText != null)
            message += "\n\nEmail: " + binding.emailContainer.helperText
        if (binding.locationContainer.helperText != null)
            message += "\n\nLocation: " + binding.locationContainer.helperText
        if (binding.passwordContainer.helperText != null)
            message += "\n\nPassword: " + binding.passwordContainer.helperText
        if (binding.fullNameContainer.helperText != null)
            message += "\n\nName: " + binding.confirmPasswordContainer.helperText
    }

}
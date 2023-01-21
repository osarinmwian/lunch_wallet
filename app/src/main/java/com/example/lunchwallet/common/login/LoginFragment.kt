package com.example.lunchwallet.common.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentLoginBinding
import com.example.lunchwallet.util.loginvalidation.LoginInputValidation

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var errorMsg: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    // initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        errorMsg = binding.LoginErrorMsg
        emailFocusListener()
        passwordFocusListener()

        // LOGIN BUTTON
        binding.loginFragmentButton.setOnClickListener {
            onClickLoginButton()
        }
        // Forgot Password
        binding.loginFragmentForgotpasswordTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
        // SIGN-UP
        binding.loginFragmentSignupTv.setOnClickListener {
             findNavController().navigate(R.id.action_loginFragment_to_selectTypeFragment)
        }
    }

    private fun emailFocusListener() {
        binding.loginFragmentEmailEt.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.loginFragmentEmailTil.helperText =
                    LoginInputValidation.validateEmail(binding.loginFragmentEmailEt.text.toString())
        }
    }

    private fun passwordFocusListener() {
        binding.loginFragmentPasswordEt.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.loginFragmentPasswordTil.helperText =
                    LoginInputValidation.validatePassword(binding.loginFragmentPasswordEt.text.toString())
        }
    }

    private fun onClickLoginButton() {
        binding.loginFragmentEmailTil.helperText = LoginInputValidation.validateEmail(binding.loginFragmentEmailEt.text.toString())

        binding.loginFragmentPasswordTil.helperText = LoginInputValidation.validatePassword(binding.loginFragmentPasswordEt.text.toString())

        val validEmailInput = LoginInputValidation.validateEmail(binding.loginFragmentEmailEt.text.toString()) == null
        val validPasswordInput = LoginInputValidation.validatePassword(binding.loginFragmentPasswordEt.text.toString()) == null

        if (validEmailInput && validPasswordInput) {
            if (binding.loginFragmentPasswordEt.text.toString() == "Beneficiary@123")
            findNavController().navigate(R.id.action_loginFragment_to_foodBeneficiaryDashboardFragment)
            if (binding.loginFragmentPasswordEt.text.toString() == "Kitchenstaff@123"){
                findNavController().navigate(R.id.action_loginFragment_to_kitchenStaffDashBoardFragment2)
            }
            if (binding.loginFragmentPasswordEt.text.toString() == "Admin@123"){
                findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
            }
        } else {
            invalidCredentials()
        }
    }

    private fun invalidCredentials() {
        var message = ""
        if (binding.loginFragmentEmailTil.helperText != null) {
            message = "\n\nEmail: " + binding.loginFragmentEmailTil.helperText
        }
        if (binding.loginFragmentPasswordTil.helperText != null) {
            message = "\n\nEmail: " + binding.loginFragmentPasswordTil.helperText
        }
    }
}

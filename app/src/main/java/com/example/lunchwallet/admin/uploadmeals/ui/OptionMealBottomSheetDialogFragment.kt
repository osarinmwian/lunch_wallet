package com.example.lunchwallet.admin.uploadmeals.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentOptionMealBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OptionMealBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentOptionMealBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOptionMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        kitchenDropDown()
        namedMealFocusListener()
        serveTimeFocusListener()
        kitchenFocusListener()
        binding.optionMealFragmentAddMealButton.setOnClickListener {
            findNavController().navigate(R.id.action_optionMealFragment_to_messageAlertFragment)
        }
    }

    private fun kitchenDropDown() {
        val kitchen = resources.getStringArray(R.array.kitchen)
        val adapter = ArrayAdapter(requireContext(), R.layout.kitchen_menu_list, kitchen)
        with(binding.kitchenAutoView) {
            setAdapter(adapter)
        }
    }

    private fun namedMealFocusListener() {
        binding.uploadMealFragmentTitleOfMealET.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.uploadMealFragmentTitleOfMealContainer.helperText
        }
    }

    private fun serveTimeFocusListener() {
        binding.optionMealFragmentAddTimeET.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.optionMealFragmentAddTimeContainer.helperText
        }
    }
    private fun kitchenFocusListener() {
        binding.kitchenAutoView.setOnFocusChangeListener { _, focused ->
            if (!focused)
                binding.optionMealFragmentSelectContainer.helperText
        }
    }
}

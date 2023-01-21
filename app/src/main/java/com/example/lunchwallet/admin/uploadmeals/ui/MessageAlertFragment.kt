package com.example.lunchwallet.admin.uploadmeals.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lunchwallet.databinding.FragmentMessageAlertBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MessageAlertFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMessageAlertBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMessageAlertBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Done Button
        binding.messageAlertFragmentDoneButton.setOnClickListener {
//            findNavController().navigate(R.id.action_messageAlertFragment_to_accountLunchWalletFragment2)
        }
    }
}

package com.example.lunchwallet.common.resetpassword

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.lunchwallet.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.IllegalStateException



class SuccessModalFragment : DialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_success_modal, container, false)
    }
}

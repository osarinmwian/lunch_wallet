package com.example.lunchwallet.common.onboarding.ui.landingpage

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchwallet.MainActivity
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.FragmentLandingPageBinding
import com.example.lunchwallet.common.onboarding.ui.landingpage.adapter.LandingPageMealsPagerAdapter

class LandingPageFragment : Fragment() {
    private lateinit var binding: FragmentLandingPageBinding
    private lateinit var landingPageMealsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLandingPageBinding.inflate(layoutInflater)

        landingPageMealsRecyclerView = binding.landingPageMealsRecyclerView
        landingPageMealsRecyclerView.layoutManager = LinearLayoutManager(container?.context, LinearLayoutManager.HORIZONTAL, false)

        landingPageMealsRecyclerView.adapter = LandingPageMealsPagerAdapter()

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).apply {
            setStatusBarColor(Color.WHITE)
        }

        binding.landingPageTopButtonGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_landingPageFragment_to_loginFragment)
        }

        binding.landingPageCenterButtonGetStarted.setOnClickListener {
            findNavController().navigate(R.id.action_landingPageFragment_to_loginFragment)
        }
    }
}

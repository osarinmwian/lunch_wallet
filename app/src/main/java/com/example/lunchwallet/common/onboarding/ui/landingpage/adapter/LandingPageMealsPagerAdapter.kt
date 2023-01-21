package com.example.lunchwallet.common.onboarding.ui.landingpage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchwallet.R
import com.example.lunchwallet.databinding.LandingPageMealPagerItemBinding

class LandingPageMealsPagerAdapter : RecyclerView.Adapter<LandingPageMealsPagerViewHolder>() {
    private lateinit var landingPageMealPagerItemImage: ImageView
    private lateinit var container: ViewGroup
    private lateinit var binding: LandingPageMealPagerItemBinding

    private val images = intArrayOf(
        R.drawable.landing_page_dish_1,
        R.drawable.landing_page_dish_2,
        R.drawable.landing_page_dish_3,
        R.drawable.landing_page_dish_4
    )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LandingPageMealsPagerViewHolder {
        binding = LandingPageMealPagerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        landingPageMealPagerItemImage = binding.landingPageMealPagerItemImage
        container = binding.container
        return LandingPageMealsPagerViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: LandingPageMealsPagerViewHolder, position: Int) {
        if (position == 0) (container.layoutParams as ViewGroup.MarginLayoutParams).leftMargin = 40

        if (position == itemCount - 1) (container.layoutParams as ViewGroup.MarginLayoutParams).rightMargin = 40

        landingPageMealPagerItemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int = images.size
}

class LandingPageMealsPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
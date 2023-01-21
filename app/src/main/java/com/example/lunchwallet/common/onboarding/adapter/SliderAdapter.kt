package com.example.lunchwallet.common.onboarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.lunchwallet.R
import com.example.lunchwallet.common.onboarding.model.OnBoardingData

class SliderAdapter(private val context: Context, private val onBoardingDataList: List<OnBoardingData>): PagerAdapter() {
    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.slides_layout, null)
        val imageView: ImageView = view.findViewById(R.id.my_image)
        val title: TextView = view.findViewById(R.id.my_title)
        val desc: TextView = view.findViewById(R.id.my_desc)

        imageView.setImageResource(onBoardingDataList[position].image)
        title.text = onBoardingDataList[position].title
        desc.text = onBoardingDataList[position].desc

        container.addView(view)
        return view
    }
}
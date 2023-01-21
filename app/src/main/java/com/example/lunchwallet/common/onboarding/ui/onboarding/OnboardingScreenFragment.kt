package com.example.lunchwallet.common.onboarding.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.lunchwallet.R
import com.example.lunchwallet.common.onboarding.adapter.SliderAdapter
import com.example.lunchwallet.common.onboarding.model.OnBoardingData

class OnboardingScreenFragment : Fragment() {

    private lateinit var onBoardingAdapter: SliderAdapter
    var onBoardingViewPager: ViewPager? = null
    private var onBoardingData: MutableList<OnBoardingData> = ArrayList()
    private lateinit var nextButton: Button
    private lateinit var skipButton: Button
    private lateinit var viewPager: ViewPager
    var position = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.statusBarColor = resources.getColor(R.color.bg_color_onboarding)

        nextButton = view.findViewById(R.id.next_button)
        skipButton = view.findViewById(R.id.skip_button)
        viewPager = view.findViewById(R.id.viewPager)

        onBoardingData.add(
            OnBoardingData(
                "Choose Food",
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas laboriosam dolore quam?",
                R.drawable.onboarding_screen_one
            )
        )
        onBoardingData.add(
            OnBoardingData(
                "Scan QR Code",
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas laboriosam dolore quam?",
                R.drawable.onboarding_screen_two
            )
        )
        onBoardingData.add(
            OnBoardingData(
                "Enjoy Your Meal",
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. Quas laboriosam dolore quam?",
                R.drawable.onboarding_screen_three
            )
        )

        setOnboardingViewPagerAdapter(onBoardingData)

        position = onBoardingViewPager!!.currentItem

        changeTextOnButtonClick()
        changeTextOnViewPagerSwipe()
    }
    private fun changeTextOnButtonClick() {
        skipButton.setOnClickListener {
            if (position == onBoardingAdapter.count - 3) {
                onBoardingViewPager!!.currentItem = onBoardingData.size - 1
                nextButton.text = "Explore"
                skipButton.text = ""
            }
        }

        nextButton.setOnClickListener {
            if (position < onBoardingAdapter.count - 1) {
                position++
                onBoardingViewPager!!.currentItem = position
            }

            if (position == onBoardingAdapter.count - 1) {
                nextButton.text = "Explore"
                skipButton.text = ""
            }

            if (nextButton.text == "Explore") {
                findNavController().navigate(R.id.action_onboardingScreenFragment_to_landingPageFragment)
            }
        }
    }

    private fun changeTextOnViewPagerSwipe() {
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position < onBoardingAdapter.count - 1) {
                    nextButton.text = "Next"
                    skipButton.text = "Skip"
                } else {
                    nextButton.text = "Explore"
                    skipButton.text = ""
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    private fun setOnboardingViewPagerAdapter(onBoardingData: List<OnBoardingData>) {
        onBoardingViewPager = view?.findViewById(R.id.viewPager)
        onBoardingAdapter = SliderAdapter(requireActivity(), onBoardingData)

        onBoardingViewPager!!.adapter = onBoardingAdapter
    }
}

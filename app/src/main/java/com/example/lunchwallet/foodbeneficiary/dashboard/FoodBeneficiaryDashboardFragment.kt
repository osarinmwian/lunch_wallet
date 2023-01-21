package com.example.lunchwallet.foodbeneficiary.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lunchwallet.MainActivity
import com.example.lunchwallet.databinding.FragmentFoodBeneficiaryDashboardBinding
import com.example.lunchwallet.util.adapter.CalenderAdapter
import com.example.lunchwallet.util.daysInWeekArray
import com.example.lunchwallet.util.monthYearFromDate
import java.time.LocalDate

class FoodBeneficiaryDashboardFragment : Fragment() {
    private lateinit var binding: FragmentFoodBeneficiaryDashboardBinding
    private lateinit var selectedDate: LocalDate

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFoodBeneficiaryDashboardBinding.inflate(layoutInflater)

        selectedDate = LocalDate.now()
        (requireActivity() as MainActivity).apply {
            setStatusBarColor(Color.WHITE)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWeekView()
    }

    private fun setWeekView() {
        binding.monthYearTV.text = monthYearFromDate(selectedDate)
        // val daysInMonth = daysInMonthArray(selectedDate)
        val daysInWeek = daysInWeekArray(selectedDate)
        val calendarAdapter = CalenderAdapter(daysInWeek)
        val layoutManager = GridLayoutManager(context, 7)
        binding.calendarRecyclerView.layoutManager = layoutManager
        binding.calendarRecyclerView.adapter = calendarAdapter
    }

    fun previousWeekAction(view: View?) {
        selectedDate = selectedDate.minusWeeks(1)
        setWeekView()
    }

    fun nextWeekAction(view: View) {
        selectedDate = selectedDate.plusWeeks(1)
        setWeekView()
    }
}

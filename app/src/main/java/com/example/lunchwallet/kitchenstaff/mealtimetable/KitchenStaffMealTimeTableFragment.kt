package com.example.lunchwallet.kitchenstaff.mealtimetable

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lunchwallet.MainActivity
import com.example.lunchwallet.databinding.FragmentKitchenStaffMealTimeTableBinding
import com.example.lunchwallet.util.adapter.CalenderAdapter
import com.example.lunchwallet.util.daysInWeekArray
import com.example.lunchwallet.util.monthYearFromDate
import java.time.LocalDate

class KitchenStaffMealTimeTableFragment : Fragment() {
    private lateinit var binding: FragmentKitchenStaffMealTimeTableBinding
    private lateinit var selectedDate: LocalDate

    companion object {
        fun newInstance() = KitchenStaffMealTimeTableFragment()
    }

    private lateinit var viewModel: KitchenStaffDashBoardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKitchenStaffMealTimeTableBinding.inflate(layoutInflater)

        selectedDate = LocalDate.now()
        (requireActivity() as MainActivity).apply {
            setStatusBarColor(Color.WHITE)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[KitchenStaffDashBoardViewModel::class.java]
        // TODO: Use the ViewModel
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
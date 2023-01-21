package com.example.lunchwallet.admin.mealtimetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lunchwallet.databinding.FragmentMealTimeTableBinding
import com.example.lunchwallet.util.adapter.CalenderAdapter
import com.example.lunchwallet.util.adapter.OnItemListener
import com.example.lunchwallet.util.daysInWeekArray
import com.example.lunchwallet.util.monthYearFromDate
import java.time.LocalDate

class MealTimeTableFragment : Fragment(), OnItemListener {

    private lateinit var binding: FragmentMealTimeTableBinding
    private lateinit var selectedDate: LocalDate



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMealTimeTableBinding.inflate(layoutInflater)
        selectedDate = LocalDate.now()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setWeekView()
        previousWeekAction(view)
        nextWeekAction(view)
    }

    private fun setWeekView() {
        binding.monthYearTV.text = monthYearFromDate(selectedDate)
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

    override fun onItemClick(position: Int, date: LocalDate) {
        selectedDate = date
        setWeekView()
    }
}

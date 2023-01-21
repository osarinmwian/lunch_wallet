package com.example.lunchwallet.util.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchwallet.R
import com.example.lunchwallet.util.selectedDate
import java.time.LocalDate

class CalenderAdapter(private val days: ArrayList<LocalDate>) : RecyclerView.Adapter<CalenderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.calender_cell, parent, false)
        val layoutParams = ViewGroup.LayoutParams(view.layoutParams)

        if (days.size > 15) {
            layoutParams.height = (parent.height * 1.666).toInt()
        } else {
            layoutParams.height = parent.height
        }
        return CalenderViewHolder(view)
    }

    override fun onBindViewHolder(holder: CalenderViewHolder, position: Int) {
        selectedDate = LocalDate.now()
        val currentDate = days[position]
        holder.dayOfMonth.text = currentDate.dayOfMonth.toString()

        if (currentDate == selectedDate) {
            holder.dayOfMonth.setBackgroundResource(R.drawable.current_day_background)
            holder.dayOfMonth.setTextColor(Color.WHITE)
        }
    }

    override fun getItemCount(): Int = days.size
}

class CalenderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var parentView: LinearLayoutCompat = itemView.findViewById(R.id.calender_cell_parent_view)
    var dayOfMonth: TextView = itemView.findViewById(R.id.cellDayText)
}

interface OnItemListener {
    fun onItemClick(position: Int, date: LocalDate)
}

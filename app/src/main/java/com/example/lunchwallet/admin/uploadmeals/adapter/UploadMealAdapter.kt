package com.example.lunchwallet.admin.uploadmeals.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchwallet.R
import com.example.lunchwallet.admin.uploadmeals.model.Meals
import com.squareup.picasso.Picasso

class UploadMealAdapter(private val meal: ArrayList<Meals>) : RecyclerView.Adapter<UploadMealAdapter.UploadMealViewHolder>() {

    inner class UploadMealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mealImage: ImageView = itemView.findViewById(R.id.upload_meals_rv_meal_iv)
        val mealName: TextView = itemView.findViewById(R.id.upload_meals_rv_meal_name_tv)
        val timeServing: TextView = itemView.findViewById(R.id.upload_meals_rv_meal_serving_time_tv)
        val kitchen: TextView = itemView.findViewById(R.id.upload_meals_rv_kitchen_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UploadMealViewHolder {
        val view = LayoutInflater.from(
            parent.context
        ).inflate(
            R.layout.fragment_admin_upload_meal_recycler_view,
            parent, false
        )
        return UploadMealViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: UploadMealViewHolder, position: Int) {
        val current = meal[position]
        holder.apply {
            Picasso.get().load(current.image).into(mealImage)
            mealName.text = current.name
            timeServing.text = current.timeServing
            kitchen.text = current.kitchen
        }
    }

    override fun getItemCount(): Int {
        return meal.size
    }
}

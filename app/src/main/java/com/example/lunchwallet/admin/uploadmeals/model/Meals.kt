package com.example.lunchwallet.admin.uploadmeals.model
import androidx.annotation.DrawableRes
import com.example.lunchwallet.R

data class Meals(
    @DrawableRes val image: Int,
    val name: String,
    val timeServing: String,
    val kitchen: String,
) {
    companion object {
        val listOfMeals = arrayListOf<Meals>(

        )
    }
}

package com.example.lunchwallet.admin.uploadmeals.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lunchwallet.R
import com.example.lunchwallet.admin.uploadmeals.adapter.UploadMealAdapter
import com.example.lunchwallet.admin.uploadmeals.model.Meals
import com.google.android.material.button.MaterialButton

class UploadMealFragment : Fragment() {

    private lateinit var uploadMealAdapter: UploadMealAdapter
    private lateinit var uploadMealsRV: RecyclerView
    private lateinit var uploadMealFilledLayout: LinearLayout
    private lateinit var uploadMealEmptyLayout: LinearLayout
    private lateinit var addMealButtonForEmptyLayout: MaterialButton
    private lateinit var addMealButtonForFilledLayout: MaterialButton

//    private var _binding: FragmentUploadMealBinding? = null
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        _binding = FragmentUploadMealBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_admin_upload_meal, container, false)
    }

    // Initialising Binding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        uploadMealEmptyLayout = requireView().findViewById(R.id.admin_meal_screen_empty)
        uploadMealFilledLayout = requireView().findViewById(R.id.admin_upload_meal_screen_filled)
        addMealButtonForEmptyLayout = requireView().findViewById(R.id.uploadMealFragment_add_meal_Button)
        addMealButtonForFilledLayout = requireView().findViewById(R.id.uploadMealFragment_Add_meal_button_Filled)

        uploadMealAdapter = UploadMealAdapter(Meals.listOfMeals)
        uploadMealsRV = requireView().findViewById(R.id.uploadMealFragment_recyclerView)
        uploadMealsRV.adapter = uploadMealAdapter
        uploadMealsRV.layoutManager = LinearLayoutManager(requireContext())

        if (uploadMealAdapter.itemCount > 0) {
            uploadMealEmptyLayout.visibility = View.GONE
            uploadMealFilledLayout.visibility = View.VISIBLE
        } else {
            uploadMealEmptyLayout.visibility = View.VISIBLE
            uploadMealFilledLayout.visibility = View.GONE
        }

        addMealButtonForEmptyLayout.setOnClickListener {
            findNavController().navigate(R.id.action_uploadMealFragment_to_optionMealFragment)
        }

        addMealButtonForFilledLayout.setOnClickListener {
            findNavController().navigate(R.id.action_uploadMealFragment_to_optionMealFragment)
        }
        // Add Meal Button
//        binding.uploadMealFragmentAddMealButton.setOnClickListener {
//            findNavController().navigate(R.id.action_uploadMealFragment_to_optionMealFragment)
//        }
    }
}

package com.example.recipeapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import com.example.recipeapp.R


class CategoryListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_category_list, container, false)


        val breakfastButton = view.findViewById<ImageButton>(R.id.sniadanie_button)
        val lunchButton = view.findViewById<ImageButton>(R.id.obiad_button)
        val dinnerButton = view.findViewById<ImageButton>(R.id.kolacja_button)
        val plusButton = view.findViewById<ImageButton>(R.id.plus_button)

        breakfastButton.setOnClickListener {
            val action =
                CategoryListFragmentDirections.actionCategoryListFragmentToMealListFragment("sniadanie")
            view.findNavController().navigate(action)
        }

        lunchButton.setOnClickListener {
            val action =
                CategoryListFragmentDirections.actionCategoryListFragmentToMealListFragment("obiad")
            view.findNavController().navigate(action)
        }

        dinnerButton.setOnClickListener {
            val action =
                CategoryListFragmentDirections.actionCategoryListFragmentToMealListFragment("kolacja")
            view.findNavController().navigate(action)
        }

        plusButton.setOnClickListener {
            val action =
                CategoryListFragmentDirections.actionCategoryListFragmentToAddRecipeFragment()
            view.findNavController().navigate(action)
        }

        return view
    }

}
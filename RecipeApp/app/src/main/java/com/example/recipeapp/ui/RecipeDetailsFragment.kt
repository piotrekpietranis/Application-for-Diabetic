package com.example.recipeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.recipeapp.R

class RecipeDetailsFragment : Fragment() {

    private val args by navArgs<RecipeDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_show_recipe_details, container, false)

        val recipe = args.recipe

        var textViewName = view.findViewById<TextView>(R.id.text_view_name)
        var textViewPreparation = view.findViewById<TextView>(R.id.text_view_preparation)


        textViewName.setText(recipe.name)
        textViewPreparation.setText(recipe.preparation)


        return view
    }

}
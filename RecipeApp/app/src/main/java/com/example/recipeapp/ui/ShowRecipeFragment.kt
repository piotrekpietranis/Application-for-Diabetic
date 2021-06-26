package com.example.recipeapp.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import com.example.recipeapp.R


class ShowRecipeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_show_recipe, container, false)

        val buttonShowDetails = view.findViewById<ImageButton>(R.id.show_recipe)

        buttonShowDetails.setOnClickListener {
            val action =
                ShowRecipeFragmentDirections.actionShowRecipeFragmentToRecipeDetailsFragment()
            view.findNavController().navigate(action)
        }




        return view
    }

}
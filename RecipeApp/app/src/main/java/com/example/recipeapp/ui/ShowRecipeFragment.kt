package com.example.recipeapp.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.recipeapp.R


class ShowRecipeFragment : Fragment() {

    private val args by navArgs<ShowRecipeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_show_recipe, container, false)

        val recipe = args.recipe
        var textViewName = view.findViewById<TextView>(R.id.text_view_recipe_name)
        var textViewB = view.findViewById<TextView>(R.id.edit_b)
        var textViewW = view.findViewById<TextView>(R.id.edit_w)
        var textViewT = view.findViewById<TextView>(R.id.edit_t)
        var textViewKcal = view.findViewById<TextView>(R.id.edit_kcal)

        textViewName.setText(recipe.name)
        textViewB.setText(recipe.P.toString())
        textViewW.setText(recipe.C.toString())
        textViewT.setText(recipe.F.toString())
        textViewKcal.setText(recipe.kcal.toString())

        val buttonShowDetails = view.findViewById<ImageButton>(R.id.show_recipe)
        buttonShowDetails.setOnClickListener {
            val action =
                ShowRecipeFragmentDirections.actionShowRecipeFragmentToRecipeDetailsFragment(recipe)
            view.findNavController().navigate(action)
        }
        return view
    }


}
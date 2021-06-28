package com.example.recipeapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.R
import com.example.recipeapp.data.RecipeasViewModel
import com.example.recipeapp.data.Recipes


class AddRecipeFragment : Fragment() {

    companion object {
        val DIFFICULTY_LIST = arrayListOf("łatwy", "sredni", "trudny")
        val CATEGORY_LIST = arrayListOf("Sniadanie", "Obiad", "Kolacja")
    }
    lateinit var mRecipeasModel:RecipeasViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_add_recipe, container, false)

        val spinner = view.findViewById<Spinner>(R.id.spinner1)
        val spinner2 = view.findViewById<Spinner>(R.id.spinner2)
        val addrecipe = view.findViewById<Button>(R.id.addRecipe)
        addrecipe.setOnClickListener {
            addRecipe()
        }

        val spinnerAdapter : ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), R.layout.list_item_difficulty_spinner , DIFFICULTY_LIST)

        val spinnerAdapter2 : ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), R.layout.list_item_difficulty_spinner , CATEGORY_LIST)

        spinner.adapter = spinnerAdapter
        spinner2.adapter = spinnerAdapter2


        return view
    }

    private fun addRecipe() {
        println("Recipe adding")

        val name = view?.findViewById<TextView>(R.id.name)
        val category = view?.findViewById<Spinner>(R.id.spinner2)
        val preparation = view?.findViewById<TextView>(R.id.preparation)
        val dificulty = view?.findViewById<Spinner>(R.id.spinner1)



        var recipes = Recipes(0, name?.text.toString(), preparation?.text.toString(),
            dificulty?.selectedItem.toString(),category?.selectedItem.toString(), 3F,3F,3F,132F)
        mRecipeasModel.addRecipeas(recipes)
         println("Recipe Added")
    }
}
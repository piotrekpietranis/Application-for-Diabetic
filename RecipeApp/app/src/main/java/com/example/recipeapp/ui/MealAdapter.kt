package com.example.recipeapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.recipeapp.R
import com.example.recipeapp.data.Recipes

class MealAdapter(context: Context, recipeList : ArrayList<Recipes>, private val recipeClickedListener: RecipeClickedListener)
    : ArrayAdapter<Recipes>(context, 0, recipeList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var recipe = getItem(position)
        var view : View? = convertView

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_meal, parent, false);
        }

        var textView = view?.findViewById<TextView>(R.id.meal_button)
        textView?.setText(recipe?.name)

        view?.setOnClickListener {
            recipeClickedListener.onRecipeClicked(recipe!!)
        }

        return view!!
    }

    interface RecipeClickedListener {
        fun onRecipeClicked(recipe : Recipes)
    }
}
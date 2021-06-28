package com.example.recipeapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.recipeapp.R


class AddRecipeFragment : Fragment() {

    companion object {
        val DIFFICULTY_LIST = arrayListOf("łatwy", "sredni", "trudny")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_add_recipe, container, false)

        val spinner = view.findViewById<Spinner>(R.id.spinner1)

        val spinnerAdapter : ArrayAdapter<String> =
            ArrayAdapter<String>(requireContext(), R.layout.list_item_difficulty_spinner , DIFFICULTY_LIST)

        spinner.adapter = spinnerAdapter


        return view
    }
}
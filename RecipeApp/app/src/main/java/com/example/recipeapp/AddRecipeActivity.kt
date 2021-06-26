package com.example.recipeapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.recipeapp.data.RecipeasViewModel
import com.example.recipeapp.data.Recipes

class AddRecipeActivity: AppCompatActivity() {
    private var _binding: AddRecipeActivity? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val button = findViewById<Button>(R.id.addRecipe)
//        button.setOnClickListener {
//            addRecipe()
//        }
    }
//     fun addRecipe(){
//         val recipes = Recipes(0,"tex","test","4","Kolacja", 1F,4F,6F,6F)
//         mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)
////         mRecipeasModel.addRecipeas(recipes)
////         Toast.makeText(this,"dodano",Toast.LENGTH_LONG).show()
//         //mRecipeasModel.getAlldinner.observe(this, Observer { recipes->
//           //  Toast.makeText(this,"xxxx",Toast.LENGTH_LONG).show()
//            //})
//     }
}
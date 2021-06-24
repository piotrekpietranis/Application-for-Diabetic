package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.recipeapp.data.RecipeasViewModel
import com.example.recipeapp.data.Recipes

public lateinit var mRecipeasModel:RecipeasViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.SSTheme)
        setContentView(R.layout.add_your_recipe)
        val toolbar = findViewById(R.id.myToolbar) as Toolbar?
        setSupportActionBar(toolbar)
        mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)
//        val button = findViewById<ImageButton>(R.id.plus_button)
//        val textview = findViewById<TextView>(R.id.textView)
//        button.setOnClickListener {
//            Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
//            textview.text = "jakis napis"
//            val recipes = Recipes(0,"tex","test","4","zxc", 1F,4F,6F,6F)
//        mRecipeasModel =  ViewModelProvider(this).get(RecipeasViewModel::class.java)
//        mRecipeasModel.addRecipeas(recipes)
//            mRecipeasModel.readAllData.observe(this, Observer { recipes->
//                Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
//            })
//        }
        ///////////////////////////////////////////////////////////////////////////////////////
//        val addButton = findViewById<Button>(R.id.addRecipe)
//        addButton.setOnClickListener{insertDataToDatabase()}

        val getAll = findViewById<Button>(R.id.getAll)
        getAll.setOnClickListener{
            getAll()}
//        val getKolacja = findViewById<Button>(R.id.getKolacja)
//        getKolacja.setOnClickListener{getKolacja()}
//        val getObiad = findViewById<Button>(R.id.getObiad)
//        getObiad.setOnClickListener{getObiad()}
//        val getSniadanie = findViewById<Button>(R.id.getSniadanie)
//        getSniadanie.setOnClickListener{getSniadanie()}
    }

     fun insertDataToDatabase() {
//         val name = findViewById<EditText>(R.id.name)
//        val recipes = Recipes(0,name.text.toString(),"test","4","Obiad", 1F,4F,6F,6F)
//        mRecipeasModel.addRecipeas(recipes)
//         print("Recipe Added")
    }
    fun getKolacja(){
//        print("kolacja")
//
//        mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)
//                 mRecipeasModel.getAlldinner.observe(this, Observer { recipes->
//             var iterator = recipes.iterator()
//             iterator.forEach {
//                 print(it.id)
//                 print(" ")
//                 print(it.name)
//                 print(" ")
//                 println(it.category)
//             }
//         })
    }
//    fun getObiad(){
//        print("obiad")
//        mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)
//        mRecipeasModel.getAllLunch.observe(this, Observer { recipes->
//            var iterator = recipes.iterator()
//            iterator.forEach {
//                print(it.id)
//                print(" ")
//                print(it.name)
//                print(" ")
//                println(it.category)
//            }
//        })
//    }
//    fun getSniadanie(){
//        print("sniadanie")
    // przykład z subskrybcją i obserowaniem

//        mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)
//        mRecipeasModel.getAllbreakfast.observe(this, Observer { recipes->
//            var iterator = recipes.iterator()
//            iterator.forEach {
//                print(it.id)
//                print(" ")
//                print(it.name)
//                print(" ")
//                println(it.category)
//            }
//        })
   // }
    fun getAll() {
//        mRecipeasModel.readAllData.removeObserver()
//        print(mRecipeasModel.readAllData.value.size)
        val obs = Observer<List<Recipes>>{ recipes ->
            var iterator = recipes.iterator()
            iterator.forEach {
                print(it.id)
                print(" ")
                print(it.name)
                print(" ")
                println(it.category)
            }
        }

        mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)
        mRecipeasModel.readAllData.observe(this, obs)
        mRecipeasModel.readAllData.removeObserver(obs)

    }
}
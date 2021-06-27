package com.example.recipeapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.recipeapp.R
import com.example.recipeapp.data.RecipeasViewModel
import com.example.recipeapp.data.Recipes


class MealListFragment : Fragment() {

    companion object {
        private const val TAG = "MealListFragment"
    }

    lateinit var mRecipeasModel:RecipeasViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_meal_list, container, false)

        mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)


        Log.i(TAG, "onCreateView: " + mRecipeasModel.getDummyData()[0].name)


//        val getAll = view.findViewById<Button>(R.id.getAll)
//        getAll.setOnClickListener{
//            getAll()}


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


//        val getKolacja = findViewById<Button>(R.id.getKolacja)
//        getKolacja.setOnClickListener{getKolacja()}
//        val getObiad = findViewById<Button>(R.id.getObiad)
//        getObiad.setOnClickListener{getObiad()}
//        val getSniadanie = findViewById<Button>(R.id.getSniadanie)
//        getSniadanie.setOnClickListener{getSniadanie()}



        val breakfastButton = view.findViewById<ImageButton>(R.id.sniadanie_button)
        val lunchButton = view.findViewById<ImageButton>(R.id.obiad_button)
        val dinnerButton = view.findViewById<ImageButton>(R.id.kolacja_button)
        val plusButton = view.findViewById<ImageButton>(R.id.plus_button)

        breakfastButton.setOnClickListener {
            val action =
                MealListFragmentDirections.actionMealListFragmentToShowRecipeFragment(mRecipeasModel.getDummyData()[0])
            view.findNavController().navigate(action)
        }

        lunchButton.setOnClickListener {
            val action =
                MealListFragmentDirections.actionMealListFragmentToShowRecipeFragment(mRecipeasModel.getDummyData()[1])
            view.findNavController().navigate(action)
        }

        dinnerButton.setOnClickListener {
            val action =
                MealListFragmentDirections.actionMealListFragmentToShowRecipeFragment(mRecipeasModel.getDummyData()[2])
            view.findNavController().navigate(action)
        }

        plusButton.setOnClickListener {
            val action =
                MealListFragmentDirections.actionMealListFragmentToAddRecipeFragment()
            view.findNavController().navigate(action)
        }




        return view
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

//        mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)
//        mRecipeasModel.readAllData.observe(this, obs)
//        mRecipeasModel.readAllData.removeObserver(obs)

    }
}
package com.example.recipeapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.recipeapp.R
import com.example.recipeapp.data.RecipeasViewModel
import com.example.recipeapp.data.Recipes


class MealListFragment : Fragment(), MealAdapter.RecipeClickedListener {

    companion object {
        private const val TAG = "MealListFragment"
    }

    private val args by navArgs<MealListFragmentArgs>()

    lateinit var mRecipeasModel:RecipeasViewModel
    lateinit var rootView : View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rootView = inflater.inflate(R.layout.fragment_meal_list, container, false)
        mRecipeasModel = ViewModelProvider(this).get(RecipeasViewModel::class.java)

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



        val plusButton = rootView!!.findViewById<ImageButton>(R.id.plus_button)

        var list = arrayListOf<Recipes>()

        if (args.category == "sniadanie") list = mRecipeasModel.getDummyDataBreakfast()
        if (args.category == "obiad") list = mRecipeasModel.getDummyDataLunch()
        if (args.category == "kolacja") list = mRecipeasModel.getDummyDataDinner()

        plusButton.setOnClickListener {
            val action =
                MealListFragmentDirections.actionMealListFragmentToAddRecipeFragment()
            rootView!!.findNavController().navigate(action)
        }

        var listView = rootView?.findViewById<ListView>(R.id.list_view)
        listView.adapter = MealAdapter(
            requireContext(),
            list,
            this)

        return rootView
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

    override fun onRecipeClicked(recipe: Recipes) {

        val action = MealListFragmentDirections.actionMealListFragmentToShowRecipeFragment(recipe)
        rootView?.findNavController().navigate(action)


    }
}
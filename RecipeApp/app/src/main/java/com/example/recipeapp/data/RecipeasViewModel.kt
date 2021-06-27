package com.example.recipeapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers

class RecipeasViewModel(aplication:Application):AndroidViewModel(aplication) {
    public  val readAllData : LiveData<List<Recipes>>
    public  val getAlldinner : LiveData<List<Recipes>>
    public  val getAllLunch : LiveData<List<Recipes>>
    public  val getAllbreakfast : LiveData<List<Recipes>>
    public  val repository : RecipeasRepository

    init {
        val recipesDAO = RecipeasDatabase.getDatabase(aplication).recipeasDao()
        repository = RecipeasRepository(recipesDAO)
        readAllData = repository.readAllData
        getAlldinner = repository.getAlldinner
        getAllbreakfast = repository.getAllbreakfast
        getAllLunch = repository.getAllLunch
    }
    public fun addRecipeas(recipeas:Recipes){
        viewModelScope.launch(Dispatchers.Main){
            repository.addRecipeas(recipeas)
        }
    }

    fun getDummyData() : ArrayList<Recipes> {
        var dummyRecipes = arrayListOf<Recipes>()

        dummyRecipes.add(Recipes(1,"sniadanko", "opis przyrzadzenia sniadanka", "łatwe", "sniadanie", 100f,400f,300f,666f))
        dummyRecipes.add(Recipes(1,"obiadek", "opis przyrzadzenia obiadku", "srednie", "obiad", 200f,500f,200f,200f))
        dummyRecipes.add(Recipes(1,"kolacyjka", "opis przyrzadzenia kolacyjki", "trudne", "kolacje", 300f,400f,500f,100f))

        return dummyRecipes
    }

}
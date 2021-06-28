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

    fun getDummyDataBreakfast() : ArrayList<Recipes> {
        var dummyRecipes = arrayListOf<Recipes>()

        dummyRecipes.add(Recipes(1,"Sniadanie pierwsze", "opis przyrzadzenia sniadania 1", "łatwe", "sniadanie", 100f,400f,300f,666f))
        dummyRecipes.add(Recipes(2,"Sniadanie drugie", "opis przyrzadzenia sniadania 2", "srednie", "sniadanie", 200f,500f,200f,200f))
        dummyRecipes.add(Recipes(3,"Sniadanie trzecie", "opis przyrzadzenia sniadania 3", "trudne", "sniadanie", 300f,400f,500f,100f))

        return dummyRecipes
    }

    fun getDummyDataLunch() : ArrayList<Recipes> {
        var dummyRecipes = arrayListOf<Recipes>()

        dummyRecipes.add(Recipes(1,"Obiad pierwszy", "opis przyrzadzenia obiadu 1", "łatwe", "obiad", 100f,400f,300f,666f))
        dummyRecipes.add(Recipes(2,"Obiad drugi", "opis przyrzadzenia obiadu 2", "srednie", "obiad", 200f,500f,200f,200f))
        dummyRecipes.add(Recipes(3,"Obiad trzeci", "opis przyrzadzenia obiadu 3", "trudne", "obiad", 300f,400f,500f,100f))

        return dummyRecipes
    }

    fun getDummyDataDinner() : ArrayList<Recipes> {
        var dummyRecipes = arrayListOf<Recipes>()

        dummyRecipes.add(Recipes(1,"Kolacja pierwsza", "opis przyrzadzenia kolacji 1", "łatwe", "kolacje", 100f,400f,300f,666f))
        dummyRecipes.add(Recipes(2,"Kolacja druga", "opis przyrzadzenia kolacji 2", "srednie", "kolacje", 200f,500f,200f,200f))
        dummyRecipes.add(Recipes(3,"Kolacja trzecia", "opis przyrzadzenia kolacji 3", "trudne", "kolacje", 300f,400f,500f,100f))

        return dummyRecipes
    }

}
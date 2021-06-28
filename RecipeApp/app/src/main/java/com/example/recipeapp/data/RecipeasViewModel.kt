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

        dummyRecipes.add(Recipes(1,"Nalesniki", "opis przyrzadzenia nalesnikow", "łatwe", "sniadanie", 100f,400f,300f,666f))
        dummyRecipes.add(Recipes(2,"Jajecznica", "opis przyrzadzenia jajecznicy", "srednie", "sniadanie", 200f,500f,200f,200f))
        dummyRecipes.add(Recipes(3,"Gofry", "opis przyrzadzenia goferów", "trudne", "sniadanie", 300f,400f,500f,100f))

        return dummyRecipes
    }

    fun getDummyDataLunch() : ArrayList<Recipes> {
        var dummyRecipes = arrayListOf<Recipes>()

        dummyRecipes.add(Recipes(1,"Łosoś", "opis przyrzadzenia lososia", "łatwe", "obiad", 100f,400f,300f,666f))
        dummyRecipes.add(Recipes(2,"Schabowy", "opis przyrzadzenia schabowego", "srednie", "obiad", 200f,500f,200f,200f))
        dummyRecipes.add(Recipes(3,"Chleb smarowany nożem", "opis przyrzadzenia chleba", "trudne", "obiad", 300f,400f,500f,100f))

        return dummyRecipes
    }

    fun getDummyDataDinner() : ArrayList<Recipes> {
        var dummyRecipes = arrayListOf<Recipes>()

        dummyRecipes.add(Recipes(1,"Kiełba z gryla", "opis przyrzadzenia kiełby", "łatwe", "kolacje", 100f,400f,300f,666f))
        dummyRecipes.add(Recipes(2,"Piwo i chipsy", "opis przyrzadzenia piwa i chipsów", "srednie", "kolacje", 200f,500f,200f,200f))
        dummyRecipes.add(Recipes(3,"Pizza z wczoraj", "opis przyrzadzenia pizzy z wczoraj", "trudne", "kolacje", 300f,400f,500f,100f))

        return dummyRecipes
    }

}
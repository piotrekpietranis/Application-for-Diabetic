package com.example.recipeapp.data

import androidx.lifecycle.LiveData

class RecipeasRepository(public val recipeasDAO: RecipeasDAO) {
    val readAllData: LiveData<List<Recipes>> = recipeasDAO.readAllData()
    val getAlldinner: LiveData<List<Recipes>> = recipeasDAO.getAlldinner()
    val getAllbreakfast: LiveData<List<Recipes>> = recipeasDAO.getAllbreakfast()
    val getAllLunch: LiveData<List<Recipes>> = recipeasDAO.getAllLunch()

    suspend fun addRecipeas(recipeas:Recipes){
        recipeasDAO.addRecipeas(recipeas)
    }
}
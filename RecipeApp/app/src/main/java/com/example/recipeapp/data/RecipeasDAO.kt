package com.example.recipeapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecipeasDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipeas(recipeas: Recipes)

    @Query("SELECT * FROM recipeas_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Recipes>>

    @Query("SELECT * FROM recipeas_table WHERE category='Sniadanie'")
    fun getAllbreakfast(): LiveData<List<Recipes>>

    @Query("SELECT * FROM recipeas_table WHERE category='Obiad'")
    fun getAllLunch(): LiveData<List<Recipes>>

    @Query("SELECT * FROM recipeas_table WHERE category='Kolacja'")
    fun getAlldinner(): LiveData<List<Recipes>>
}
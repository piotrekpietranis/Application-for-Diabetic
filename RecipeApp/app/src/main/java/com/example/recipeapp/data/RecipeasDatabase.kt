package com.example.recipeapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Recipes::class], version = 1, exportSchema = false)
abstract class RecipeasDatabase: RoomDatabase() {

    abstract fun recipeasDao(): RecipeasDAO

    companion object {
        @Volatile
        public var INSTANCE: RecipeasDatabase? = null

        fun getDatabase(context: Context): RecipeasDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
        synchronized(this){
            val instance = Room.databaseBuilder(
                context.applicationContext,
                RecipeasDatabase::class.java,
                "recipeas_database"
            ).build()
            INSTANCE = instance
            return instance
        }
        }
    }
}
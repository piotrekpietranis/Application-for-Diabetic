package com.example.recipeapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "recipeas_table")
data class Recipes (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val preparation: String,
    val difficulty: String,
    val category: String,
    val P: Float,
    val C: Float,
    val F: Float,
    val kcal: Float
    ) : Parcelable
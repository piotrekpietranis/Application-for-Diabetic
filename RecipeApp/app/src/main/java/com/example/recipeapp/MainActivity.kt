package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.SSTheme)
        setContentView(R.layout.add_your_recipe)
        val toolbar = findViewById(R.id.myToolbar) as Toolbar?
        setSupportActionBar(toolbar)

    }
}
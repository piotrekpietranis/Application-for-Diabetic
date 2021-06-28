package com.example.recipeapp.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.recipeapp.R


class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)

        Handler(Looper.getMainLooper()).postDelayed({
            val action =
                SplashScreenFragmentDirections.actionSplashScreenFragmentToCategoryListFragment()
            view.findNavController().navigate(action)

        }, 2000)

        return view
    }

}
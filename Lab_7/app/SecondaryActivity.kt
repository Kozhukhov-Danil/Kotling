package com.lab_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.lab_7.R

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_secondary) as NavHostFragment
        val navController = navHostFragment.navController

        // Использование второго навигационного графа
        navController.setGraph(R.navigation.nav_graph_secondary)
    }
}

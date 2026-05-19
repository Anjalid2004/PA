package com.example.myapplicationpa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationpa.navigation.MainNavigation
import com.example.myapplicationpa.ui.theme.MyApplicationPATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationPATheme {
                val navController = rememberNavController()
                MainNavigation(navController = navController)
            }
        }
    }
}

package com.example.myapplicationpa.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Security
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object TreeRegister : Screen("tree_register")
    object TreeDetails : Screen("tree_details/{treeId}") {
        fun createRoute(treeId: String) = "tree_details/$treeId"
    }
    object GrowthTracker : Screen("growth_tracker")
    object SecurityAlerts : Screen("security_alerts")
    object MaturityCalculator : Screen("maturity_calculator")
    object Profile : Screen("profile")
}

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val bottomNavItems = listOf(
    BottomNavItem("Home", Icons.Default.Home, Screen.Home.route),
    BottomNavItem("Security", Icons.Default.Security, Screen.SecurityAlerts.route),
    BottomNavItem("Calc", Icons.Default.Calculate, Screen.MaturityCalculator.route),
    BottomNavItem("Profile", Icons.Default.Person, Screen.Profile.route)
)

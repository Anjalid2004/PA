package com.example.myapplicationpa.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.myapplicationpa.ui.screens.*

@Composable
fun MainNavigation(navController: NavHostController) {
    var showBottomBar by remember { mutableStateOf(false) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    showBottomBar = currentRoute in bottomNavItems.map { it.route }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    bottomNavItems.forEach { item ->
                        NavigationBarItem(
                            icon = { Icon(item.icon, contentDescription = item.label) },
                            label = { Text(item.label) },
                            selected = currentRoute == item.route,
                            onClick = {
                                if (currentRoute != item.route) {
                                    navController.navigate(item.route) {
                                        popUpTo(Screen.Home.route) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            }
            composable(Screen.Home.route) {
                HomeScreen(
                    onAddTreeClick = { navController.navigate(Screen.TreeRegister.route) },
                    onTreeClick = { treeId -> navController.navigate(Screen.TreeDetails.createRoute(treeId)) }
                )
            }
            composable(Screen.TreeRegister.route) {
                TreeRegisterScreen(onBack = { navController.popBackStack() })
            }
            composable(Screen.TreeDetails.route) { backStackEntry ->
                val treeId = backStackEntry.arguments?.getString("treeId")
                TreeDetailsScreen(
                    treeId = treeId,
                    onBack = { navController.popBackStack() },
                    onViewGrowthClick = { navController.navigate(Screen.GrowthTracker.route) }
                )
            }
            composable(Screen.GrowthTracker.route) {
                GrowthTrackerScreen()
            }
            composable(Screen.SecurityAlerts.route) {
                SecurityAlertScreen()
            }
            composable(Screen.MaturityCalculator.route) {
                MaturityCalculatorScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

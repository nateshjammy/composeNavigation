package com.android.composeuidesigon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.android.composeuidesigon.screen.DetailScreen
import com.android.composeuidesigon.screen.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {


    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY_NAME) {
                    type = NavType.StringType

                }, navArgument(DETAIL_ARGUMENT_KEY_PHONE) {
                    type = NavType.LongType
                },
                navArgument(DETAIL_ARGUMENT_KEY_EMAIL) {
                    type = NavType.StringType

                }
            )) {
            val name = it.arguments?.getString(DETAIL_ARGUMENT_KEY_NAME)
            val phone = it.arguments?.getLong(DETAIL_ARGUMENT_KEY_PHONE)
            val email = it.arguments?.getString(DETAIL_ARGUMENT_KEY_EMAIL)
            DetailScreen(navController, name = name, phone = phone ?: 0, email = email?:"")
        }
    }
}
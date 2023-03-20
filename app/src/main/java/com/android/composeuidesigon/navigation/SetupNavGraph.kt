package com.android.composeuidesigon.navigation

import android.app.Person
import android.app.SharedElementCallback
import android.util.Log
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.android.composeuidesigon.data.PersonInfo
import com.android.composeuidesigon.screen.DetailScreen
import com.android.composeuidesigon.screen.HomeScreen
import com.android.composeuidesigon.screen.ViewPersonInfoScreen
import com.android.composeuidesigon.viewModel.SharedViewModel

@Composable
fun SetupNavGraph(navController: NavHostController) {

    val sharedViewModel:SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController,sharedViewModel)
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

        composable(route = Screen.Info.route) {
            LaunchedEffect(key1 = Unit ){

                /*
                *
                * First approach to send Parcelize data one screen to another
                * */

              /*  val result =  navController.previousBackStackEntry?.savedStateHandle?.get<PersonInfo>("person")
                Log.d("SetupNavGraph : Name","${result?.name}")
                Log.d("SetupNavGraph : Email","${result?.email}")
                Log.d("SetupNavGraph : Phone","${result?.phone}")*/
            }
            ViewPersonInfoScreen(sharedViewModel)
        }
    }
}
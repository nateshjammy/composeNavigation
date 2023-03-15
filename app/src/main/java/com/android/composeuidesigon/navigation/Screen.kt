package com.android.composeuidesigon.navigation

sealed class Screen(val route: String) {

    companion object {
        const val HOME = "Home_screen"
        const val DETAIL = "Detail_Screen"
    }


    object Home : Screen(route = HOME)
    object Detail : Screen(route = DETAIL)


}

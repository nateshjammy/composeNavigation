package com.android.composeuidesigon.navigation


const val DETAIL_ARGUMENT_KEY_NAME = "name"
const val DETAIL_ARGUMENT_KEY_PHONE = "phone"
const val DETAIL_ARGUMENT_KEY_EMAIL = "email"
const val DETAIL = "Detail_Screen"
const val HOME = "Home_screen"
const val INFO = "Info_screen"
const val LAZYCOLUMN = "LazyColumn_Screen"

sealed class Screen(val route: String) {

    object Home:Screen(route = HOME)
    /*
    * /{argument value} ---> Required argument eg: /{name}
    * ?argument value={value} ---> Optional Argument  eg: ?name={name}
    * */
    object Detail:Screen(route = "$DETAIL/{$DETAIL_ARGUMENT_KEY_NAME}/{$DETAIL_ARGUMENT_KEY_PHONE}/{$DETAIL_ARGUMENT_KEY_EMAIL}"){
        fun passData(
            name:String,
            phone: Long,
            email:String
        ):String{
            return "$DETAIL/$name/$phone/$email"
        }
    }


    object Info:Screen(route = INFO)


    object LazyColumn:Screen(route = LAZYCOLUMN)


}

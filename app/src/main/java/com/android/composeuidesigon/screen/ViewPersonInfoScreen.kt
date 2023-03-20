package com.android.composeuidesigon.screen

import android.util.Log
import androidx.compose.runtime.Composable
import com.android.composeuidesigon.viewModel.SharedViewModel

@Composable
fun ViewPersonInfoScreen(sharedViewModel: SharedViewModel) {

    val personInfo = sharedViewModel.personInfo

    Log.d("ViewPersonInfoScreen  Name :  ", "${personInfo?.name}")
    Log.d("ViewPersonInfoScreen  Email :  ", "${personInfo?.email}")
    Log.d("ViewPersonInfoScreen  Phone :  ", "${personInfo?.phone}")

}
package com.android.composeuidesigon.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.composeuidesigon.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize(), Alignment.Center
    ) {

        Text(
            modifier = Modifier
                .clickable {
                           navController.navigate(route = Screen.Detail.passData(
                               name = "Harshi",
                               phone = 123456789,
                               email = "harshi@gmail.com"
                           ))
                },
            text = "Home",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .clickable {
                           navController.navigate(route = Screen.Detail.passData(
                               name = "Harshi",
                               phone = 123456789,
                               email = "harshi@gmail.com"
                           ))
                },
            text = "Home",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )

    }
}


@Composable
@Preview(showBackground = true )
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}

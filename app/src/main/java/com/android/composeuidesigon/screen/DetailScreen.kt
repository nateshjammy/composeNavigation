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
fun DetailScreen(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Text(
            modifier = Modifier
                .clickable {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                },
            text = "Detail",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h1.fontSize
        )

    }
}

@Composable
@Preview
fun DetailScreenPreview() {
    DetailScreen(navController = rememberNavController())
}
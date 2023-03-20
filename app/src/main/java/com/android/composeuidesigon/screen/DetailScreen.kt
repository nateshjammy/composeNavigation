package com.android.composeuidesigon.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetailScreen(
    navController: NavController,
    name: String?,
    phone: Long,
    email: String
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        Arrangement.Top
    ) {

        Text(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .align(CenterHorizontally), text = "Detail Screen",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp
        )

        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ) {

            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                text = "Name :",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
            )

            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(), text = name ?: "",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )


        }


        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ) {

            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                text = "Phone:",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
            )

            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                text = phone.toString(),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )


        }


        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ) {

            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(),
                text = "Email:",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
            )

            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth(), text = email,
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
    }
}

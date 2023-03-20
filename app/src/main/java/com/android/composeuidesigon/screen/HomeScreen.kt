package com.android.composeuidesigon.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.composeuidesigon.data.PersonInfo
import com.android.composeuidesigon.navigation.Screen
import com.android.composeuidesigon.viewModel.SharedViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .clickable {
                    navController.navigate(
                        route = Screen.Detail.passData(
                            name = "Harshi",
                            phone = 123456789,
                            email = "harshi@gmail.com"
                        )
                    )
                },
            text = "Send Intent Data",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h3.fontSize,
            fontWeight = FontWeight.Bold
        )


        Button(
            // below line is use to add onclick
            // parameter for our button onclick
            onClick = {
                // when user is clicking the button
                // we are displaying a toast message.

                val person = PersonInfo(
                    name = "balaji",
                    email = "balaji@gmail.com", phone = 123456
                )
                /*
               * Second  approach  with vieModel to send Parcelize data one screen to another
               *
               * */

                sharedViewModel.addPerson(person)


                /*
                *
                * First approach to send Parcelize data one screen to another
                * */

                //  navController.currentBackStackEntry?.savedStateHandle?.set("person",person)

                /*
                * Remove Home Screen From Backstack using popBackStack
                *
                * If you  are Remove BackStack sharedView Model used to get data
                * */

                navController.popBackStack()
                navController.navigate(Screen.Info.route)

            },
            // in below line we are using modifier
            // which is use to add padding to our button
            modifier = Modifier
                .padding(all = Dp(10F)),

            // below line is use to set or
            // button as enable or disable.
            enabled = true,


            // below line is use to
            // add border to our button.
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),

            // below line is use to add shape for our button.
            shape = MaterialTheme.shapes.medium,
        )
        // below line is use to
        // add text on our button
        {
            Text(text = "Click To Send Parcelize Data ", color = Color.White)
        }


    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController(), sharedViewModel = SharedViewModel())
}

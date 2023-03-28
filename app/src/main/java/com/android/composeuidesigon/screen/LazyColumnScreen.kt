package com.android.composeuidesigon.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.composeuidesigon.R
import com.android.composeuidesigon.data.PersonInfo
import com.android.composeuidesigon.viewModel.LazyColumnScreenViewModel

@Composable
fun LazyColumnScreen(viewModel: LazyColumnScreenViewModel) {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    LazyColumn {
        items(viewModel.personInfoData.value) { item ->
            // Display each item in a composable
            ItemView(item)

        }
    }


}


@Composable
fun ItemView(personInfo: PersonInfo) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {

        Row() {
            Row {
                PuppyImage()
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .clickable {
                            Toast
                                .makeText(context, "${personInfo.name}", Toast.LENGTH_SHORT)
                                .show()
                        }
                ) {
                    Text(text = personInfo.name.toString(), style = typography.h6)
                    Text(text = personInfo.email.toString(), style = typography.caption)

                }
            }
        }
    }
}

@Composable
private fun PuppyImage() {

   Image(
        painter = painterResource(id = R.drawable.img_bg_footer),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}
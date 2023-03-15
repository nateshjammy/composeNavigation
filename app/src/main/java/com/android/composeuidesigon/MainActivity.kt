package com.android.composeuidesigon


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.composeuidesigon.navigation.SetupNavGraph

class MainActivity : ComponentActivity() {

    lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            navHostController = rememberNavController()
            SetupNavGraph(navController = navHostController)
        }
    }
}

@Composable
fun Home() {


    Image(
        painter = painterResource(id = R.drawable.img_bg_footer), contentDescription = null,
        modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds
    )


    // TopLeftBar()

    // TopItemBar()


    //SideBarLeftBar()

    //VoiceView()

    /* Column(
         modifier = Modifier
             .fillMaxSize()
         ) {

         FirstRow()

         SecondRow()

         FirstRow()

     }*/


    //DrawSeekBar()
    //InstagramIcon()
    DrawSeekBar()
}


@Composable
fun DrawSeekBar() {
    val instagramColors = listOf(Color.Yellow, Color.Red, Color.Magenta)


    Row(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth(),
    ) {
        val vector = ImageVector.vectorResource(id = R.drawable.img_plus_selectable)
        val painter = rememberVectorPainter(image = vector)
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            with(painter) {
                draw(painter.intrinsicSize)
            }

            drawCircle(

                brush = Brush.linearGradient(colors = instagramColors),
                radius = 13f,
                center = Offset(this.size.width * .80f, this.size.height * 0.20f),

                )


        }


    }


}


@Composable
fun InstagramIcon() {

    val instagramColors = listOf(Color.Yellow, Color.Red, Color.Magenta)

    Canvas(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
    ) {

        drawRoundRect(
            brush = Brush.linearGradient(colors = instagramColors),
            cornerRadius = CornerRadius(60f, 60f),
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

        drawCircle(

            brush = Brush.linearGradient(colors = instagramColors),
            radius = 45f,
            style = Stroke(width = 15f, cap = StrokeCap.Round)
        )

        drawCircle(

            brush = Brush.linearGradient(colors = instagramColors),
            radius = 13f,
            center = Offset(this.size.width * .80f, this.size.height * 0.20f),

            )

    }


}

@Composable
fun CarView() {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_car_top_view),
            contentDescription = "Car", modifier = Modifier.align(alignment = End)
        )
        Image(
            painter = painterResource(id = R.drawable.img_left_arrow_selected),
            contentDescription = "Car", modifier = Modifier.align(alignment = End)
        )


    }
}


@Composable
fun PointerView() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        ConstraintLayout(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
        ) {

            val (centerPointer, right, left, up, down) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.img_pointer),
                contentDescription = "car",
                modifier = Modifier.constrainAs(centerPointer) {

                    top.linkTo(up.bottom)
                    start.linkTo(left.end)
                    bottom.linkTo(down.top)
                    end.linkTo(right.start)
                }
            )
            Image(
                painter = painterResource(id = R.drawable.img_left_arrow_selected),
                contentDescription = "car",
                modifier = Modifier.constrainAs(left) {
                    start.linkTo(parent.start)
                    top.linkTo(centerPointer.top)
                    bottom.linkTo(centerPointer.bottom)
                }

            )
            Image(
                painter = painterResource(id = R.drawable.img_right_arrow_selected),
                contentDescription = "car",
                modifier = Modifier.constrainAs(right) {
                    start.linkTo(centerPointer.end)
                    top.linkTo(centerPointer.top)
                    bottom.linkTo(centerPointer.bottom)
                }
            )
            Image(
                painter = painterResource(id = R.drawable.img_up_arrow_selected),
                contentDescription = "car",
                modifier = Modifier.constrainAs(up) {
                    start.linkTo(left.end)
                    end.linkTo(right.start)
                    top.linkTo(parent.top)
                }

            )
            Image(
                painter = painterResource(id = R.drawable.img_down_arrow_selected),
                contentDescription = "car",
                modifier = Modifier.constrainAs(down) {

                    start.linkTo(left.end)
                    end.linkTo(right.start)
                    top.linkTo(centerPointer.bottom)
                }

            )
        }

    }
}


@Composable
fun TopItemBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(30.dp),
        verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.End

    ) {

        Image(
            modifier = Modifier
                .wrapContentWidth(),
            painter = painterResource(id = R.drawable.img_alexa_logo),
            contentDescription = "close",
            contentScale = ContentScale.FillBounds,
        )


    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 150.dp, top = 37.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ) {


        Text(
            text = "GAYDON",
            modifier = Modifier,
            fontSize = 42.sp,
            color = Color.White
        )

        Text(
            text = "Today 20th March",
            modifier = Modifier,
            fontSize = 38.sp,
            color = Color.White
        )

    }



    Row(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(start = 260.dp, bottom = 240.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_sunny_big),
            contentDescription = "sunny",
        )

        Text(
            text = "24\u00B0",
            modifier = Modifier
                .padding(start = 40.dp),
            fontSize = 240.sp,
            color = Color.White
        )

        Image(
            painter = painterResource(id = R.drawable.img_seperator_line),
            modifier = Modifier.padding(start = 166.dp),
            contentDescription = "line"
        )


        Column(
            modifier = Modifier.padding(start = 70.dp),
            verticalArrangement = Arrangement.spacedBy(45.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Image(
                painter = painterResource(id = R.drawable.baseline_north_24),
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                contentDescription = "line"
            )


            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_downward_24),
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                contentDescription = "line"
            )

        }

        Column(
            modifier = Modifier.padding(start = 70.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(
                text = "24\u00B0",
                modifier = Modifier,
                fontSize = 60.sp,
                color = Color.White
            )

            Text(
                text = "10\u00B0",
                modifier = Modifier,
                fontSize = 60.sp,
                color = Color.White
            )

        }


    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 212.dp, top = 300.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        ItemView()
        ItemView()
        ItemView()
        ItemView()
        ItemView()
    }


}


@Composable
fun ItemView() {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_sunny_big),
            contentDescription = "sunny",
            modifier = Modifier
                .height(100.dp)
                .width(130.dp)
        )

        Text(
            text = "Sat",
            modifier = Modifier,
            fontSize = 42.sp,
            color = Color.White
        )

        Text(
            text = "10°/8°",
            modifier = Modifier,
            fontSize = 42.sp,
            color = Color.White
        )

    }
}

@Composable
fun TopLeftBar() {


    Column(
        modifier = Modifier
            .wrapContentWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
    ) {


        Image(
            modifier = Modifier
                .wrapContentWidth(),
            painter = painterResource(id = R.drawable.img_close_btn_with_touch),
            contentDescription = "close",
            contentScale = ContentScale.FillBounds,
        )

    }
}

@Composable
fun VoiceView() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White.copy(alpha = 0.1f)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = ("Message for: Brett Sinclair"),
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            fontSize = 42.sp,
            color = Color.White
        )

/*
        Text(
            modifier = Modifier
                .height(330.dp)
                .width(330.dp),
            painter = painterResource(id = R.drawable.grp_btn_voice),
            contentDescription = "back",
            contentScale = ContentScale.FillBounds,
        )
*/

        Text(
            text = ("Message for: Brett Sinclair"),
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(),
            fontSize = 42.sp,
            color = Color.White
        )


    }

}

@Composable
fun SideBarLeftBar() {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentWidth()
            .background(Color.White.copy(alpha = 0.1f)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth(),
            contentAlignment = Alignment.Center
        ) {


            Image(
                modifier = Modifier
                    .wrapContentWidth(),
                painter = painterResource(id = R.drawable.grp_back_panel),
                contentDescription = "back",
                contentScale = ContentScale.FillBounds,
            )


            Image(
                modifier = Modifier
                    .wrapContentWidth(),
                painter = painterResource(id = R.drawable.grp_close_panel),
                contentDescription = "close",
                contentScale = ContentScale.FillBounds,
            )



            Image(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(alignment = Alignment.BottomCenter),
                painter = painterResource(id = R.drawable.img_close_btn_with_touch),
                contentDescription = "close",
                contentScale = ContentScale.FillBounds,
            )

            Image(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(alignment = Alignment.TopCenter),
                painter = painterResource(id = R.drawable.back_btn_icon),
                contentDescription = "close",
                contentScale = ContentScale.FillBounds,
            )


        }
    }
}


/*@Composable
fun FirstRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 110.dp, end = 20.dp, top = 90.dp),
        horizontalArrangement = Arrangement.spacedBy(34.dp),
        verticalAlignment = Alignment.Top,


        ) {


        AndroidAlien(R.drawable.ic_launcher_background)
        AndroidAlien(R.drawable.ic_launcher_background)
        AndroidAlien(R.drawable.ic_launcher_background)
        AndroidAlien(R.drawable.ic_launcher_background)
        AndroidAlien(R.drawable.ic_launcher_background)
        AndroidAlien(R.drawable.ic_launcher_background)
        AndroidAlien(R.drawable.ic_launcher_background)
    }
}

@Composable
fun SecondRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 110.dp, end = 20.dp, top = 90.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp),
        verticalAlignment = Alignment.Top,


        ) {


        AndroidAlien(R.drawable.ic_launcher_background)
        AndroidAlien(R.drawable.ic_launcher_background)
        SeekBar()
        AndroidAlien(R.drawable.ic_launcher_background)
        AndroidAlien(R.drawable.ic_launcher_background)
    }
}





@Composable
fun SeekBar() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f,
        modifier = Modifier
            .width(450.dp)
            .padding(8.dp),
        colors = SliderDefaults.colors(
            thumbColor = Color.Blue,
            activeTrackColor = Color.Blue,
            inactiveTrackColor = Color.LightGray
        )
    )
}






@Composable
fun AndroidAlien(@DrawableRes id: Int) {


    Image(
        painter = painterResource(id = id),
        contentDescription = "image",

        modifier = Modifier
            .height(120.dp)
            .width(120.dp)
            .clickable {

            }

    )
}*/


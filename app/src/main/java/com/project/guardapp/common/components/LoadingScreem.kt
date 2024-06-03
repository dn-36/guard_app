package com.project.guardapp.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.guardapp.R

@Preview
@Composable
fun PreviewLoadingScreem(){
    LoadingScreen(
        visibility = true,
        icon = R.drawable.care_advice_two,
        text = "ksmlvkmds dsmkvds..."
    )
}


@Composable
fun LoadingScreen(
    visibility:Boolean,
    text:String,
    icon:Int
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .alpha(if (visibility) 1f else 0f)
        .background(Color(0xFF03142C))) {

        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold, // указываем жирное начертание
                fontSize = 20.sp // размер шрифта для примера
            ),
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 60.dp)


        )

        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(bottom = 40.dp)
            .height(100.dp)

            , verticalArrangement = Arrangement.Bottom
            , horizontalAlignment = Alignment.CenterHorizontally) {

            LinearProgressIndicator(
                modifier = Modifier
                    .padding(bottom = 15.dp)
                    .height(3.dp)
                    .width(220.dp),
                color = Color(0xFF03142C)
            )
            Text(
                text = "loading...",
                fontSize = 28.sp,
                color = Color(0xFF52647C),
                modifier = Modifier
            )


        }
        Box(modifier = Modifier
            .padding(bottom = 90.dp)
            .size(180.dp)
            .align(Alignment.Center)
        ){
        Image(painter = painterResource(id = R.drawable.img_13), contentDescription =null,
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.Center)
               )
            Image(painter = painterResource(id = icon), contentDescription =null,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
            )
    }}
}
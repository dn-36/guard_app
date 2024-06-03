package com.project.guardapp.screens.file_optimization.component

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.common.navigate.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



@Composable
fun EndCleanMemory(
    navController: NavController,
    backToMenu:()->Unit,
    contiinue:()->Unit
){
    var startAnimation by remember {
        mutableStateOf(false)
    }
    var isVisibilityText by remember {
        mutableStateOf(false)
    }

    var colorText by remember {
        mutableStateOf(Color.White)
    }

    var text1 by remember {
        mutableStateOf("Возможно освободить памяти на ${com.project.guardapp.common.ChangeDataApp.clearMegabyte} mb")
    }

    var text2 by remember {
        mutableStateOf("Освоюодить")
    }

    var fontSize by remember {
        mutableStateOf(15)
    }

    var isFinishFreeUpMemory by remember {
        mutableStateOf(false)
    }

 
    val progress by animateFloatAsState(
        targetValue = if (startAnimation)  1F else 0.1F ,
        animationSpec = tween(
            durationMillis = 12000
        )
    )

    val alphaText by animateFloatAsState(
        targetValue = if (isVisibilityText)  0F else 1F ,
        animationSpec = tween(
            durationMillis = 500
        )
)

    val paddingText by animateIntAsState(
        targetValue = if (isVisibilityText)  100 else 150 ,
        animationSpec = tween(
            durationMillis = 500
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF03142C))
    ) {

        LinearProgressIndicator(progress = progress
            , modifier = Modifier
                .padding(top = 135.dp)
                .fillMaxWidth(0.8f)
                .height(50.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter)
            , color = Color(0xFF53A6F1),
            trackColor = Color(0xFF0F2036)
        )

        Text(
            text = text1,
            color = colorText,
            fontSize = fontSize.sp ,
            modifier = Modifier
                .padding(bottom = paddingText.dp)
                .alpha(alphaText)
                .align(Alignment.BottomCenter)
            )

        Row(modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 140.dp)
            .fillMaxWidth(0.7f)
            .height(40.dp)
            , horizontalArrangement = Arrangement.SpaceAround
            , verticalAlignment = Alignment.CenterVertically) {

            Image(painter = painterResource(id = R.drawable.lightning), contentDescription = null,
                modifier = Modifier.size(20.dp))
            Text(text = "Устройство улучшено на", color = Color.White)
            Text(text = "${(progress*100F).toInt()} %",
                color = Color.White)
        }

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_button),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        backToMenu()
                    }
            )
            Text(
                text = "  освободить память", color = Color.White,
                fontSize = 20.sp
            )
        }
        Row(modifier = Modifier
            .padding(top = 100.dp)
            .fillMaxWidth(0.7f)
            .align(Alignment.TopCenter)) {
         /*   Text(
                text = "Память оптимизирована!",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                )*/
        }
        Image(painter = painterResource(id = R.drawable.clean_two), contentDescription = null,
        modifier = Modifier
            .align(Alignment.Center)
            .padding(bottom = 70.dp)
            .size(110.dp)
        )


        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(30.dp)
            .height(130.dp)
            , verticalArrangement = Arrangement.SpaceAround
            , horizontalAlignment = Alignment.CenterHorizontally) {
 //           Text(text = "1 шага до конца!", fontSize = 23.sp, color = Color(0xFF86C6FE))

            Box(modifier = Modifier
                .width(250.dp)
                .height(50.dp)) {

                Image(painter = painterResource(id = R.drawable.empty_button),
                    contentDescription = null,
                    modifier = Modifier
                        .width(250.dp)
                        .height(50.dp)
                        .alpha(alphaText)
                        .clickable {
                            startAnimation = true
                            isVisibilityText = true

                            if(isFinishFreeUpMemory) {
                                navController.navigate(Screen.Menu.route)
                            }else{
                                contiinue()
                            }

                            CoroutineScope(Dispatchers.IO).launch {

                                delay(8000)
                                isVisibilityText = false
                                fontSize = 22
                                colorText = Color(0xFF53A6F1)
                                text1 = "Освобожденно ${com.project.guardapp.common.ChangeDataApp.clearMegabyte} MB!"
                                text2 = "Завершить"
                                isFinishFreeUpMemory = true
                            }



                        }
                )
                Text(
                    text = text2,
                    color = Color.White,

                    modifier = Modifier
                        .align(Alignment.Center)
                        .alpha(alphaText)
                    )
            }
        }
    }
}
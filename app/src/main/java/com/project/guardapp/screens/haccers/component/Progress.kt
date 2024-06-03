package com.project.guardapp.screens.haccers.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.guardapp.R
import kotlinx.coroutines.delay

@Preview
@Composable
fun PreviewProgressCleanMemory(){
    Progress{}
}


@Composable
fun Progress(
    clickBack:()->Unit
){
    var rotationState = remember { mutableStateOf(0f) }
    var number = remember { mutableStateOf(0f) }

    val animatedTekst = animateFloatAsState(
        targetValue = number.value,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(Unit) {

        (0..5).forEach { step ->
            delay(600) // Делим общий период (3000мс) на количество шагов (5)
            number.value = step * 0.2f // 0.2f - это шаг в 20% для нашего ProgressBar
        }
        // vm.processIntent(LoadingIntent.MoveMenuScreen)
    }

    LaunchedEffect(Unit) {
        delay(300L)
        while (true) {
            for (angle in 0..359) {
                rotationState.value = angle.toFloat()
                delay(2L)
            }
            if (animatedTekst.value * 100 == 100f) {
                break
            }
        }

    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF03142C))
    ) {
        Row(modifier = Modifier
            .fillMaxHeight(0.9f)
            .padding(top = 40.dp,start=20.dp),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_button), contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                   .clickable { clickBack() }
            )
            Text(
                text = "  Защита от хакеров", color = Color.White,
                fontSize = 18.sp, modifier = Modifier.padding(start=10.dp)
            )
        }
        Text(text = "Проверка в базе данных...",
            color = Color.White, fontSize = 20.sp
            , textAlign = TextAlign.Center
            , modifier = Modifier
              //  .fillMaxWidth(0.8f)
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp))
        Column(modifier = Modifier.align(Alignment.Center)
            , verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.protection_progress), contentDescription = null,
                modifier = Modifier.size(150.dp))
            Text(text = "${(animatedTekst.value * 100).toInt()}", modifier = Modifier.padding(bottom = 17.dp, top = 20.dp)
                , color = Color.White,
                fontSize = 40.sp)
         //   Text(text = "ШАГ 1 ИЗ 3", color = Color(0xFF52647C))
        }
        Image(painter = painterResource(id = R.drawable.a_circle), contentDescription =null,
            modifier = Modifier
                .padding(bottom = 90.dp)
                .size(180.dp)
                .align(Alignment.Center)
                .graphicsLayer(
                    rotationZ = rotationState.value
                ))
    }
}
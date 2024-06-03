package com.project.guardapp.screens.progress.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.common.navigate.Screen
import com.project.guardapp.screens.progress.viewmodel.ViewModelProgress
import kotlinx.coroutines.delay



    @Composable
    fun ScreenProgress(
        viewModel: ViewModelProgress = hiltViewModel(),
        navController: NavController
    ){
       // viewModel.processIntent(IntentProgress.SetField)

        var rotationState = remember {  mutableStateOf(0f) }
        var number = remember { mutableStateOf(0f) }
       // var text = remember { mutableStateOf(0f) }
        LaunchedEffect(Unit) {
                delay(300L)
                while (true) {
                    for (angle in 0..359) {
                        rotationState.value = angle.toFloat()
                        delay(2L)
                    }
                    if(number.value==100f){
                        break
                    }
            }

        }
        LaunchedEffect(Unit) {
            delay(300L)
            while (true) {
                for (angle in 0..100) {
                    number.value = angle.toFloat()
                    delay(30L)
                }
                break
            }

            delay(3500L)
            navController.navigate(Screen.CongratulateClearApps.route)

        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF03142C))) {
Row(modifier = Modifier
    .padding(top = 20.dp,start=20.dp),
verticalAlignment = Alignment.CenterVertically) {
    Image(
        painter = painterResource(id = R.drawable.back_button), contentDescription = null,
        modifier = Modifier
            .size(30.dp)
            .clickable {
                // viewModel.processIntent(IntentProgress.PressBack)
            }
    )
    Text(
        text = "  ${viewModel.progressState.choice}", color = Color.White,
        fontSize = 18.sp, modifier = Modifier.padding(start=10.dp)
    )
}
            Text(text = "${viewModel.progressState.text}",
            color = Color.White, fontSize = 20.sp
                , textAlign = TextAlign.Center
            , modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.TopCenter)
                    .padding(top = 120.dp))
            Column(modifier = Modifier.align(Alignment.Center)
                , verticalArrangement = Arrangement.Center
            , horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = viewModel.progressState.img), contentDescription = null,
                modifier = Modifier.size(150.dp))
                Text(text = "${number.value.toInt()}", modifier = Modifier.padding(top = 20.dp)
                    , color = Color.White,
                fontSize = 40.sp)
                Text(text = "ШАГ 1 ИЗ 3", color = Color(0xFF52647C))
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


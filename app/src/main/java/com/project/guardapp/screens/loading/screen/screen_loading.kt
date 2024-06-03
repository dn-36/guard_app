package com.project.guardapp.screens.loading.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.screens.loading.viewmodel.IntentLoading
import com.project.guardapp.screens.loading.viewmodel.ViewModelLoading
import kotlinx.coroutines.CoroutineScope


@Composable
    fun ScreenLoading(
    viewModel: ViewModelLoading = hiltViewModel(),
    navController: NavController
    ){
        val configuration = LocalConfiguration.current
        val coroutine = rememberCoroutineScope()
        com.project.guardapp.common.ChangeDataApp.screenHeight = configuration.screenHeightDp.toDouble()
        com.project.guardapp.common.ChangeDataApp.screenWidth = configuration.screenWidthDp.toDouble()
        val Height = (com.project.guardapp.common.ChangeDataApp.screenHeight/6.0).toInt()
        val Weidht =  (com.project.guardapp.common.ChangeDataApp.screenWidth/5.5).toInt()
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF03142C))){
   Image(
       painter = painterResource(id = R.drawable.img_10),
       contentDescription =null,
   modifier = Modifier
       .padding(bottom = Weidht.dp)
       .align(Alignment.Center)
       .fillMaxWidth(0.7f)
       .fillMaxHeight(0.7f))

            Column(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = Height.dp)
                .padding(top = 100.dp)
                ) {
                LinearProgressIndicator(
                    color = Color(0xFF03142C)
                )
                Text(text = "Loading...",
                    fontSize = 25.sp,
                    color =Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 20.dp)
                )

            }

        }

        viewModel.processIntent(IntentLoading.MoveMenuScreen(navController,coroutine))
    }

package com.project.guardapp.screens.take_care_advice.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.common.components.LoadingScreen
import com.project.guardapp.screens.take_care_advice.components.AppPermissionItem
import com.project.guardapp.screens.take_care_advice.viewmodel.TakingCareIntent
import com.project.guardapp.screens.take_care_advice.viewmodel.ViewModelTakingCare
import com.project.guardapp.utils.GetProcentOptimization

import module.domain.utils.toBitmap


object TakingCareScreen {

    @Composable
    fun Content(

        navController:NavController,
        viewModel: ViewModelTakingCare = hiltViewModel()
    ) {
        val coroutineScope = rememberCoroutineScope()

        viewModel.processIntent(TakingCareIntent.SetScreen(coroutineScope))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF03142C))
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(0.8f),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_button),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { viewModel.processIntent(TakingCareIntent.GoBackMenu(navController)) }
                )
                Text(
                    text = "Забота об устройстве", color = Color.White,
                    fontSize = 20.sp
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 80.dp)
                    .fillMaxWidth(0.8f)
                //.height(180.dp),
                , horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img), contentDescription = null,
                    modifier = Modifier.size(60.dp)
                )
                Text(
                    text = "Мы нашли "+"${
                        viewModel
                            .takingCareState
                            .listAppPermission.size} " +
                            "приложения, которые имеют доступ к камере, микрофону и др. " +
                            "Вы доверяете этим приложениям?",
                    fontSize = 15.sp,
                    color = Color(0xFF52647C),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 15.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
     
                }
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxHeight(0.77f)
                ){
                                    items(viewModel.takingCareState.listAppPermission.size) {
                                        indexListPermission ->

                                        AppPermissionItem(
                                            icon = viewModel.takingCareState.listAppPermission[indexListPermission].appIcon.toBitmap()!!,
                                            title = viewModel.takingCareState.listAppPermission[indexListPermission].appName,
                                            listPermission = viewModel.takingCareState.listAppPermission[indexListPermission].listPermssion
                                        )
                                    }
                                }
                            }




                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .fillMaxHeight(0.2f)
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFF03142C),
                                    Color.Transparent
                                ), startY = 100.0f,
                                endY = 0.0f
                            )
                        )
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 30.dp)
                        .fillMaxWidth(0.9f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_1),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth()
                            .height(50.dp)
                            .clickable {

                                com.project.guardapp.common.ChangeDataApp.isDoneApplicationСare = true
                                com.project.guardapp.common.ChangeDataApp.procentOptimizationData =
                                    GetProcentOptimization.excecute()

                                viewModel.processIntent(TakingCareIntent.GoBackMenu(navController))
                            }
                    )
                    Text(
                        text = "изменить разрешения",
                        fontSize = 18.sp,
                        color = Color(0xFF86C6FE)  ,
                        modifier = Modifier.clickable {
                            com.project.guardapp.common.ChangeDataApp.isDoneApplicationСare = true

                            viewModel
                            .processIntent(
                                TakingCareIntent.ShowSettingsPermission
                            ) },

                        )
                }

            }
        LoadingScreen(visibility = !viewModel.takingCareState.isSucsessData,
            icon = R.drawable.care_advice_two,
            text = "Анализ разрешений ваших приложений...")
        }
    }


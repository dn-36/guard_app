package com.project.guardapp.screens.select_messengers.screen

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.common.components.LoadingScreen
import com.project.guardapp.screens.select_messengers.components.MessengerItem
import com.project.guardapp.screens.select_messengers.viewmodel.SelectMessengerIntent
import com.project.guardapp.screens.select_messengers.viewmodel.ViewModelSelectMessenger

/*
@Preview
@Composable
fun PreviewSelectMessengerScreen(){
    SelectMessengerScreen()
}
*/

@Composable
fun SelectMessengerScreen(
    navController: NavController,
    viewModel : ViewModelSelectMessenger = hiltViewModel(),
){
  val coroutineScope = rememberCoroutineScope()
  viewModel.processIntent(SelectMessengerIntent.SetScreen(coroutineScope))

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF03142C))) {
        Row(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.back_button), contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        com.project.guardapp.common.intent.GoBackMenuIntent.excecute(
                            navController
                        )
                    }

            )
            Text(
                text = "Очиститель мессенджеров", color = Color.White,
                fontSize = 17.sp
            )
        }
        Box(modifier = Modifier
            .padding(bottom = 70.dp)
            .align(Alignment.Center)
            .wrapContentSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 120.dp)
                // .height(120.dp)
                ,
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    "${viewModel.installedAppsState.countAppClear.toString()} MB",
                    color = Color.White,
                    fontSize = 35.sp
                )
                Text(
                    text = "Общий размерр медиа файлов",
                    color = Color(0xFF52647C),
                )

                LazyColumn(
                    modifier = Modifier

                        .wrapContentHeight()
                        .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
                )
                {


                    items(
                        viewModel.installedAppsState.listInstalledApps.size
                    ) { index ->
                        MessengerItem(
                            title = viewModel.installedAppsState.listInstalledApps[index].title,
                            icon = viewModel.installedAppsState.listInstalledApps[index].icon,
                            appSize = viewModel.installedAppsState.listInstalledApps[index].sizeApp,
                            actionClick = {
                                viewModel
                                    .processIntent(
                                        SelectMessengerIntent
                                            .ChooseClearAppIntent(index,navController)
                                    )
                            }
                        )
                    }
                }

                Text(
                    text = "Выбирите приложение",
                    color = Color(0xFF52647C),
                )

            }
        }
    }
   LoadingScreen(
        !viewModel.installedAppsState.isSucsessData,
        "Анализ мессенджеров...",
        R.drawable.messenger_clean_two,
    )
}

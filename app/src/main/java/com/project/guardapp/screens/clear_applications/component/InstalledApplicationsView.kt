package com.project.guardapp.screens.clear_applications.component

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.common.components.LoadingScreen
import com.project.guardapp.screens.clear_applications.viewmodel.InstalledAppsPresentation
import module.domain.utils.toBitmap



@Composable
fun InstalledApplicationView(
    goBack:(NavController)->Unit,
    setScreen:()->Unit,
    chooseClearApp:(Int)->Unit,
    clearApp:(NavController)->Unit,
    countAppClear:String,
    listInstalledApps:List<InstalledAppsPresentation>,
    isSucsessData:Boolean,
    navController: NavController,
){
    // installedAppsViewModel.processIntent(InstalledAppsIntent.SetScreen)
    setScreen()

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
                        goBack(navController) //GoBackMenuIntent.excecute(navController)
                    }
            )
            Text(
                text = "Установленные приложения", color = Color.White,
                fontSize = 17.sp
            )
        }
        Column( modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 120.dp)
            // .height(120.dp)
            , verticalArrangement = Arrangement.SpaceAround
            , horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = countAppClear,
                //ViewModelInstalledApps.installedAppsState.countAppClear.toString(),
                color = Color.White,
                fontSize = 45.sp
            )
            Text(
                text = "Колличество выбранных вами приложений",
                color = Color(0xFF52647C),
            )

            LazyColumn(
                modifier = Modifier
                    .height(430.dp)
                    .wrapContentHeight()
                    .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally)
            {


                items(
                    listInstalledApps.size
                ) { index ->
                    ApplicationItem(
                        title = listInstalledApps[index].title,
                        icon =  listInstalledApps[index].icon.toBitmap()!!,
                        isPressed = listInstalledApps[index].isPressed,
                        actionClick = {
                            /*
                            installedAppsViewModel
                                .processIntent(
                                    InstalledAppsIntent
                                        .ChooseClearAppIntent(index))
                            */
                            chooseClearApp(index)
                        }
                    )
                }
            }

            Text(
                text = "Выбирите приложение удаления",
                color = Color(0xFF52647C),
            )

        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Image(
                painter = painterResource(id = R.drawable.img_20),
                contentDescription = null,
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
                    .clickable {

                        clearApp(navController)

                    })
        }
    }
    LoadingScreen(
        !isSucsessData,
        "Анализ приложений...",
        R.drawable.photo_duplicates_two
    )
}

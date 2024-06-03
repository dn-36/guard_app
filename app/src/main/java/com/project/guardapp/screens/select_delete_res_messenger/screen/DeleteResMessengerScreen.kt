package com.project.guardapp.screens.select_delete_res_messenger.screen

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.common.components.LoadingScreen
import com.project.guardapp.screens.select_delete_res_messenger.components.AllowDeleteScreen
import com.project.guardapp.screens.select_delete_res_messenger.components.PackageResItem
import com.project.guardapp.screens.select_delete_res_messenger.viewmodel.DeleteResMessengerIntent
import com.project.guardapp.screens.select_delete_res_messenger.viewmodel.ViewModelDeleteResMessenger

@Preview
@Composable
fun PreviewDeleteResMessengerScreen() {

}

@Composable
fun DeleteResMessengerScreen(
    navController: NavController,
    viewModel : ViewModelDeleteResMessenger = hiltViewModel()
){
    viewModel.processIntent(DeleteResMessengerIntent.SetScreen)

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
                modifier = Modifier.size(30.dp)
                    .clickable { com.project.guardapp.common.intent.GoBackMenuIntent.excecute(navController) }

            )
            Text(
                text = "Очиститель мессенджеров", color = Color.White,
                fontSize = 17.sp
            )
        }
        Box(modifier = Modifier
            .padding(bottom = 70.dp)
            .align(Alignment.TopCenter)
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
                    "${ viewModel.deleteResAppsState.titleApp}",
                    color = Color.White,
                    fontSize = 35.sp
                )

                Text(
                    style = MaterialTheme.typography.titleSmall,
                    text = "${ viewModel.deleteResAppsState.countAppClear} MB которое ты можешь очистить",
                    color = Color(0xFF52647C),
                )

                LazyColumn(
                    modifier = Modifier

                        .wrapContentHeight()
                        .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally
                )
                {

                    items(
                        viewModel.deleteResAppsState.listInstalledApps.size
                    ) { index ->
                        val title =  viewModel.deleteResAppsState.listInstalledApps[index].title
                        val sizeApp =  viewModel.deleteResAppsState.listInstalledApps[index].sizeApp
                        PackageResItem(
                            title = title,
                            appSize = sizeApp,
                            actionClick = {
                               viewModel
                                    .processIntent(
                                        DeleteResMessengerIntent
                                            .ChooseClearAppIntent(title)
                                    )
                            }
                        )
                    }
                }

                Text(
                    text = "Выбирите медиа ресурс",
                    color = Color(0xFFFFFFFF),
                )

            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
Box(
    modifier = Modifier
        .width(300.dp)
        .height(50.dp)

) {
    Image(
        painter = painterResource(id = R.drawable.empty_button),
        contentDescription = null,
        modifier = Modifier
            .width(300.dp)
            .height(50.dp)
            .clickable {
                      viewModel
                    .processIntent(
                        DeleteResMessengerIntent.ClearChoosedSelectMessengerIntent(navController)
                    )
            }
    )


    Text(
        text = "Завершить оптимизацию",
        modifier = Modifier
            .align(Alignment.Center),
        color = Color(0xFFFFFFFF),
    )
}
        }
    }
    viewModel.deleteResAppsState.apply{
        AllowDeleteScreen(
            text = allowDeleteText,
            visibility = allowDeleteToastVisibility,
            click_yes = { allowDeleteClickYes() },
            click_no = {  allowDeleteClickNo() }
        )
    }

    LoadingScreen(
        viewModel.deleteResAppsState.isVisibilityLoading,
        "Удаление медиа ресурса...",
        R.drawable.messenger_clean_two,
    )
}

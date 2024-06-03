package com.project.guardapp.screens.menu.screen

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.screens.menu.components.MenuItem
import com.project.guardapp.screens.menu.viewmodel.IntentMenu
import com.project.guardapp.screens.menu.viewmodel.ViewModelMenu

@Composable
fun ScreenMenu(
    navController: NavController,
    isAgreementToReadContacts: Boolean,
    isAgreementToDeletePackage: Boolean,
    viewModel: ViewModelMenu = hiltViewModel()
) {

    viewModel.processIntent(IntentMenu.setScreen)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF03142C))
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f),
            RoundedCornerShape(20),
            colors = CardDefaults.cardColors(Color(0xFF1C2B41))
        ) {
        }
        LinearProgressIndicator(
            progress = (viewModel.menuState
                .procentOptimizationData.toFloat() / 100F), modifier = Modifier
                .padding(top = 140.dp)
                .fillMaxWidth(0.8f)
                .height(40.dp)
                .clip(CircleShape)
                .align(Alignment.TopCenter), color = Color(0xFF53A6F1),
            trackColor = Color(0xFF0F2036)
        )
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 140.dp)
                .fillMaxWidth(0.7f)
                .height(40.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.lightning), contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(text = "Устройство улучшено на", color = Color.White)
            Text(
                text = "${viewModel.menuState.procentOptimizationData}%",
                color = Color.White
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.15f)
                .background(Color(0xFF1C2B41))
        ) {
            Image(
                painter = painterResource(id = R.drawable.guard_app), contentDescription = null,
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .width(120.dp)
                    .height(90.dp)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 40.dp, end = 20.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                Column() {
                    Text(
                        text = viewModel.menuState.modelPhone,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                    Text(text = "SM-234   ", color = Color(0xFF607085), fontSize = 15.sp)
                }
                Image(
                    painter = painterResource(id = R.drawable.phone), contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(30.dp)
                )
            }

        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.73f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.personal_recommendations),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.08f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.25f), horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(modifier = Modifier.size(100.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.free_up_memory),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    viewModel.processIntent(
                                        IntentMenu.FreeUpMemory(
                                            navController
                                        )
                                    )
                                }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.img_18),
                            modifier = Modifier
                                .padding(bottom = 25.dp)
                                .align(Alignment.Center)
                                .alpha(
                                    if (viewModel.menuState.isDoneOptimizationMemory
                                    ) 1F else 0F
                                )
                                .size(45.dp),
                            contentDescription = null,
                        )
                    }
                    Text(
                        text = "до ${viewModel.menuState.clearMegabyte} GB",
                        modifier = Modifier.alpha(
                            if (
                                !viewModel
                                    .menuState
                                    .isDoneOptimizationMemory
                            ) 1F else 0F
                        ),
                        color = Color(0xFF86C6FE)
                    )

                }
                Box(modifier = Modifier.size(120.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.taking_care_of_the_device),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clickable {
                                viewModel.processIntent(
                                    IntentMenu.TakingCareAdvice(
                                        navController
                                    )
                                )
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.img_18),
                        modifier = Modifier
                            .padding(bottom = 45.dp)
                            .align(Alignment.Center)
                            .size(45.dp)
                            .alpha(
                                if (viewModel
                                        .menuState.isDoneApplicationСare
                                ) 1F else 0F
                            ),
                        contentDescription = null,
                    )
                }
                Box(modifier = Modifier.size(100.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.protection_from_hackers),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                viewModel.processIntent(
                                    IntentMenu.ProtectionHackers(
                                        navController
                                    )
                                )
                            }
                    )

                    Image(
                        painter = painterResource(id = R.drawable.img_18),
                        modifier = Modifier
                            .padding(bottom = 25.dp)
                            .align(Alignment.Center)
                            .size(45.dp)
                            .alpha(
                                if (viewModel
                                        .menuState.isDoneHackerProtection
                                ) 1F else 0F
                            ),
                        contentDescription = null,
                    )

                }
            }

            Image(
                painter = painterResource(id = R.drawable.additional_functions),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f)
            )

            Box(
                modifier = Modifier
                    .width(250.dp)
                    .height(70.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.contacts),
                    contentDescription = null,
                    modifier = Modifier
                        .width(250.dp)
                        .height(70.dp)
                        .clickable {
                            viewModel.processIntent(
                                IntentMenu.GoContacts(
                                    navController,
                                    isAgreementToReadContacts
                                )
                            )
                        },
                    contentScale = ContentScale.FillBounds
                )

                Image(
                    painter = painterResource(id = R.drawable.img_18),
                    modifier = Modifier
                        .padding(start = 9.dp)
                        .align(Alignment.CenterStart)
                        .size(49.dp)
                        .alpha(
                            if (viewModel.menuState.isDoneContacts) 1F else 0F
                        ),
                    contentDescription = null,
                )

            }

            MenuItem(
                R.drawable.messenger_cleaner,
                "Очистить месенджеры",
                "Оптимизация медиа ресурсов мессенджеров",
                Modifier
                    .width(280.dp)
                    .height(70.dp),
                isDone = viewModel.menuState.isDoneClearMessengers
            ) {
                viewModel.processIntent(
                    IntentMenu.DeletePackage(
                        navController,
                        isAgreementToDeletePackage
                    )
                )
            }

            MenuItem(
                icon = R.drawable.remove_duplicates,
                title = "Менеджер приложений",
                description = "оптимизация памяти, с помощью удаления\n не нужных приложений",
                modifier = Modifier
                    .width(330.dp)
                    .height(70.dp),
                isDone = viewModel.menuState.isDoneApplicationManager
            ) {
                viewModel.processIntent(
                    IntentMenu.ShowCleanApp(
                        navController
                    )
                )
            }
        }

    }
}
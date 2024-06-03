package com.project.guardapp.screens.contact.screen

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.screens.contact.viewmodel.IntentContact
import com.project.guardapp.screens.contact.viewmodel.ViewModelContacts

@Composable
fun contacts_screen(
    viewModel: ViewModelContacts = hiltViewModel(),
    navController: NavController
){

    viewModel.processIntent(IntentContact.SetScreenContact)

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF03142C))) {
        Row(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.back_button),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable { com.project.guardapp.common.intent.GoBackMenuIntent.excecute(navController) }
            )
            Text(
                text = "Контакты", color = Color.White,
                fontSize = 20.sp
            )
        }
        Column( modifier = Modifier
            .align(Alignment.TopCenter)
            .padding(top = 120.dp)
            // .height(120.dp)
            , verticalArrangement = Arrangement.SpaceAround
            , horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Найдено котактов ",
                color = Color.White, fontSize = 20.sp
            )
            Text(
                "${viewModel.stateContacts.allUnnecessaryContacts}",
                color = Color.White,
                fontSize = 35.sp
            )
            Text(
                text = "2 можно освободить немедленно",
                color = Color(0xFF52647C),
            )
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .height(100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.empty_contacts),
                    contentDescription = null,
                    modifier = Modifier
                        .width(300.dp)
                        .height(100.dp)
                )

                Text(
                    text = "0/${viewModel.stateContacts.emptyContacts} выбрано",
                    color = Color(0xFF52647C),
                    modifier = Modifier
                        .padding(
                            top = 52.dp,
                            start = 72.dp)
                )

            }
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .height(100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.duplicates),
                    contentDescription = null,
                    modifier = Modifier
                        .width(300.dp)
                        .height(100.dp)
                )

                Text(text = "0/${viewModel.stateContacts.duplicatesContacts} выбрано",
                    color = Color(0xFF52647C),
                    modifier = Modifier
                        .padding(
                            top = 52.dp,
                            start = 72.dp)
                )

            }
        }

        Image(
            painter = painterResource(id = R.drawable.clear_contacts_button),
            contentDescription = null,
            modifier = Modifier
                .width(300.dp)
                .height(100.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
                .clickable {
                    viewModel
                        .processIntent(IntentContact.ShowDuplicateContacts(navController))
                }
        )

    }

}
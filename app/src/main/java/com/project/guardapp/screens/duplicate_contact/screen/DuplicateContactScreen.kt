package com.project.guardapp.screens.duplicate_contact.screen

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.screens.duplicate_contact.component.ContactItem
import com.project.guardapp.screens.duplicate_contact.viewmodel.IntentDuplicate
import com.project.guardapp.screens.duplicate_contact.viewmodel.ViewModelDuplicateContacts

@Composable
 fun DuplicateContactScreen(
    navController: NavController,
    viewModel: ViewModelDuplicateContacts = hiltViewModel()
 ){

     viewModel.processIntent(IntentDuplicate.SetScreenContact)

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
                text = "Найдены дубликаты ",
                color = Color.White, fontSize = 20.sp
            )
            Text(
                "${viewModel.stateContacts.duplicatesContacts}",
                color = Color.White,
                fontSize = 35.sp
            )
            Text(
                text = "${viewModel.stateContacts.duplicatesContacts} можно освободить немедленно",
                color = Color(0xFF52647C),
            )

            LazyColumn(
                modifier = Modifier
                    .height(410.dp)
                    .wrapContentHeight()
                    .padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally)
            {


  items(
      viewModel.stateContacts.listContact.size
 ) { index ->
     ContactItem(
         name = viewModel.stateContacts.listContact[index].name,
         numper = viewModel.stateContacts.listContact[index].number,
         isPressed = viewModel.stateContacts.listContact[index].isPressed,
         actionClick = {
             viewModel
             .processIntent(IntentDuplicate.ChoseClearDuplicateContacts(index))}
     )
 }
}


}
Column(
modifier = Modifier
    .align(Alignment.BottomCenter)
    .padding(bottom = 30.dp), horizontalAlignment = Alignment.CenterHorizontally
) {
Image(
 painter = painterResource(id = R.drawable.first_select_contacts), contentDescription = null,
 modifier = Modifier
     .width(230.dp)
     .height(40.dp)
)
Image(
 painter = painterResource(id = R.drawable.clear_contacts_button),
 contentDescription = null,
 modifier = Modifier
     .width(300.dp)
     .height(50.dp)
     .clickable {
         viewModel.processIntent(IntentDuplicate.ClearContact(navController = navController ))
     }
)

}
}
}

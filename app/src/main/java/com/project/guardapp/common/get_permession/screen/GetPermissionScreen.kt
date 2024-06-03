package com.project.guardapp.common.get_permession.screen

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.guardapp.R
import com.project.guardapp.common.activity.MainActivity
import com.project.guardapp.common.get_permession.viewmodel.GetPermissionIntents
import com.project.guardapp.common.get_permession.viewmodel.ViewModelAgreementToReadContacts


@Preview
@Composable
fun PreviewScreenContacts(){
    AgreementScreen(
        true,
       // ViewModelAgreementToReadContacts(BackContactsIntent(), GetPermissionIntent()),
        NavController(MainActivity()),
        "Чтобы удалить дубликаты и пустые записи нам требуется разрешение",
        arrayOf(""),
        com.project.guardapp.common.ConstDataApp.REQUEST_CODE_READ_CONTACTS
        )
}

    @Composable
    fun AgreementScreen(
        isAgreementToDeletePackage:Boolean,

        navController: NavController,
        text:String,
        permissionList:Array<String>,
        request_code : Int,
        viewModelContacts: ViewModelAgreementToReadContacts = hiltViewModel(),
        ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF03142C))
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp,start=20.dp)
                ,verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back_button),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            viewModelContacts.processIntent(
                                GetPermissionIntents.PressBack(navController)
                            )
                        }
                )
                Text(
                    text = "   Контакты", color = Color.White,
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
                Text(
                    text = "Всё хорошо!",
                    fontSize = 30.sp,
                    color = Color.White,
                   // modifier = Modifier.padding(top = 80.dp)
                )
                Text(
                    text = text
                    , fontSize = 18.sp
                    , color = Color.White
                , textAlign = TextAlign.Center
                ,modifier = Modifier.padding(top = 15.dp)
                )
                Image(painter = painterResource(id = R.drawable.save), contentDescription =null,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .size(220.dp))
            }
                Image(painter = painterResource(id = R.drawable.allow_access), contentDescription =null,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(30.dp)
                        .fillMaxWidth(0.8f)
                        .height(60.dp)
                        .clickable {

                            //   MainActivity().setAllowAcessIntent()

                            viewModelContacts
                                .processIntent(
                                    GetPermissionIntents
                                        .PressAllowAccess(
                                            isAgreementToDeletePackage,
                                            navController,
                                            permissionList,
                                            request_code
                                        )
                                )
                        })
        }
    }

package com.project.guardapp.screens.select_delete_res_messenger.components

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.guardapp.R
@Preview
@Composable
fun PreviewScreenContacts(){
    AllowDeleteScreen(
        text = "Вы уверены что хотите удалить медиа ресурс?",
        visibility = true,
        click_yes = {},
        click_no = {}
        )
}

    @Composable
    fun AllowDeleteScreen(
        text:String,
        visibility:Boolean,
        click_yes:()->Unit,
        click_no:()->Unit
        ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
               // .background(Color(0xFF03142C))
                .alpha(if(visibility) 1F else 0F)
        ) {
            Image(painter = painterResource(id = R.drawable.two_stange),
                contentDescription =null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Image(painter = painterResource(id = R.drawable.img_17),
                contentDescription =null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 15.dp)
                    .size(350.dp))
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 70.dp)
                    .wrapContentHeight()

               , horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = text,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .width(250.dp)
                        .padding(bottom = 50.dp)
                    ,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
                Box(

                    modifier = Modifier
                        .width(250.dp)
                        .height(45.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.empty_button),
                        modifier = Modifier
                            .width(250.dp)
                            .height(45.dp)
                            .clickable { click_yes() },
                        contentDescription = null
                    )
                    Text(
                        text = "Да уверен",
                        fontSize = 18.sp,
                        modifier = Modifier
                            .width(250.dp)
                            .padding(top = 10.dp),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                    )
                }
                Text(
                    text = "Нет уверен",
                    fontSize = 18.sp,
                    modifier = Modifier
                        .width(250.dp)
                        .padding(top = 10.dp)
                        .clickable { click_no() },
                    textAlign = TextAlign.Center,
                    color = Color(0xFF83D6F7),
                )
            }
        }
    }

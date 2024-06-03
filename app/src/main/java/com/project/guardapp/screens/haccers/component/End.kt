package com.project.guardapp.screens.haccers.component

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
import com.project.guardapp.R

@Preview
@Composable
fun PreviewEnd(){
   // com.project.guardapp.presentation.screen.memory_screen.component.End {}
}

@Composable
fun End(
    contiinue:()->Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF03142C))
    ) {
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_button),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                    contiinue()
                }
            )
            Text(
                text = "  Защита от хакеров", color = Color.White,
                fontSize = 20.sp
            )
        }
        Row(modifier = Modifier
            .padding(top = 100.dp)
            .fillMaxWidth(0.7f)
            .align(Alignment.TopCenter)) {
            Text(
                text = "Утечек не обнаружено",
                fontSize = 30.sp,
                color = Color.White,
                textAlign = TextAlign.Center,

                )
        }
        Image(painter = painterResource(id = R.drawable.protection_hackers_two), contentDescription = null,
        modifier = Modifier.align(Alignment.Center).size(110.dp))
        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .padding(30.dp)
            .height(130.dp)
            , verticalArrangement = Arrangement.SpaceAround
            , horizontalAlignment = Alignment.CenterHorizontally) {
 //           Text(text = "1 шага до конца!", fontSize = 23.sp, color = Color(0xFF86C6FE))
            Image(painter = painterResource(id = R.drawable.resume), contentDescription =null,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(50.dp)
                    .clickable {
                        contiinue()
                    }
            )
        }
    }
}
package com.project.guardapp.screens.file_optimization.component

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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.guardapp.R

@Preview
@Composable
fun PreviewCleanMemoryFunction(){
    PermissionCleanMemory({},{})
}

@Composable
fun PermissionCleanMemory(
    clickOk:  () -> Unit,
    clickCancel: () -> Unit,

    ){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF020E1F))
    ) {
        Row(modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.back_button), contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = "  Освободить память", color = Color.White,
                fontSize = 20.sp
            )
        }
        Text(text = "Анализ файловой системы...",
            color = Color.White, fontSize = 20.sp
            , modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 120.dp))

        Box(modifier = Modifier
            .fillMaxSize()
            .alpha(0.25f)
            .background(Color.Black)
        )
    }
    Box(modifier = Modifier.fillMaxSize()
        ,
        contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.two_stange), contentDescription = null,
            modifier = Modifier.size(350.dp)  )
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(250.dp)
                .height(280.dp),
            verticalArrangement = Arrangement.SpaceAround) {
            Image(painter = painterResource(id = R.drawable.clean_two), contentDescription = null,
                modifier = Modifier.size(60.dp))
           // Text(text = "Разрешить .",
           //     color= Color.White, fontSize = 18.sp, textAlign = TextAlign.Center)
            Text(text = "Запустить полную проверку?",
                color= Color.White, fontSize = 15.sp)
            Image(painter = painterResource(id = R.drawable.ok), contentDescription =null,
                modifier = Modifier.clickable {
                    clickOk() })
            Image(painter = painterResource(id = R.drawable.cancellation), contentDescription =null,
                modifier = Modifier.clickable {
                    clickCancel()
                })
        }
    }
}
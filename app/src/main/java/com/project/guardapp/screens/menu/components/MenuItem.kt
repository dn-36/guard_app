package com.project.guardapp.screens.menu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.guardapp.R

@Preview
@Composable
fun PreviewMenuItem(){
    MenuItem(
        R.drawable.remove_duplicates,
        isDone = true,
        title = "Очистить месенджеры",
        description = "Оптимизация медиа ресурсов мессенджеров",
        modifier = Modifier
            .width(330.dp)
            .height(70.dp),
        actionClick = {}
    )
}

@Composable
fun MenuItem(icon:Int,title:String,
             description:String,
             modifier:Modifier,
             isDone:Boolean,
             actionClick:()->Unit){
    Box(
        modifier = modifier
    ) {



        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = modifier,
            alignment = Alignment.CenterStart

        )
        Box(
            modifier = Modifier
                .padding(start = 75.dp)
                .width(230.dp)
                .height(70.dp)
                .background(Color(0xFF03142C))
        ){
            Text(
                text = title,
                color = Color(0xFFFFFFFF),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                .padding(start = 5.dp)
            )

            Text(
                text = description,
                color = Color(0xFF607085),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .padding(
                        start = 5.dp,
                        top = 30.dp
                    )
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 75.dp)
                .width(230.dp)
                .height(70.dp)
                .clickable {
                    actionClick()
                })

        Image(
            painter = painterResource(id = R.drawable.img_18),
            modifier = Modifier
                .padding(start = 9.dp)
                .align(Alignment.CenterStart)
                .size(49.dp)
                .alpha(
                    if(isDone) 1F else 0F
                ),
            contentDescription = null,
        )
    }
}
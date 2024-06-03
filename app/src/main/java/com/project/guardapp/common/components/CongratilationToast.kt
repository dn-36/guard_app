package com.project.guardapp.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.guardapp.R

@Preview
@Composable
fun PreviewCongratilationToast(){
    CongratilationToast(
      "tttttt",
        300,
        {}
    )
}

@Composable
fun CongratilationToast(
    textCongratilation:String,
    countOptimized:Int,
    clickButton:()->Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF03142C))
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .height(320.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = R.drawable.messenger_clean_two),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 0.dp)
                    .size(100.dp)

            )
            Text(
                text = "Поздравляем!",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier.padding(top = 80.dp)
            )
            Text(
                text = countOptimized.toString()
                ,fontSize = 30.sp, color = Color.White
            )
            Text(
                text = textCongratilation,
                fontSize = 18.sp, color = Color.White,
                textAlign = TextAlign.Center
            )
        }

        Image(painter = painterResource(id = R.drawable.resume), contentDescription =null,
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxWidth(0.8f)
                .height(50.dp)
                .align(Alignment.BottomCenter)
                .clickable {
                    clickButton()
                }

        )

    }
}
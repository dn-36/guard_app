package com.project.guardapp.screens.clear_applications.component

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.guardapp.R

@Preview
@Composable
fun PreviewApplicationItem(){
    /*ApplicationItem(
        "Telegramm",

            "0.08",
        {}
    )*/
}

@Composable
fun ApplicationItem(
              title:String,
              icon:Bitmap,
              isPressed  : Boolean,
              actionClick:()->Unit,
) {



    Box(
        modifier = Modifier
            .width(320.dp)
            .wrapContentHeight()
            .padding(top = 10.dp)
    ) {



            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(310.dp)
                    .height(80.dp)
                    .align(Alignment.Center)
                    .alpha(if(isPressed)0.7f else 0f)
                    .clickable {
                        actionClick()
                    }
                ,
                colors = CardDefaults.cardColors(Color.White),
            ) {}

        Image(
            painter = painterResource(id = R.drawable.img_8),
            contentDescription = null,
            modifier = Modifier
                .width(300.dp)
                .height(80.dp)
                .align(Alignment.Center)
        )

        Image(
            painter = painterResource(id = R.drawable.img_9),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp)
                .width(50.dp)
                .height(50.dp)

                .align(Alignment.CenterStart)
        )

        Image(
            bitmap = icon.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 28.dp)
                .width(35.dp)
                .height(35.dp)
                .align(Alignment.CenterStart)
        )

        Text(
            text = title,
            fontSize = 17.sp,
            style = MaterialTheme.typography.titleSmall,
            color = Color(0xFFFFFFFF),
            modifier = Modifier
               .padding(
                  /*   top = 18.dp,*/
                    start = 42.dp
                )
                .align(Alignment.Center)
                .width(200.dp)
                .wrapContentHeight()
        )

     /*   Text(
            text = cache + " mb",
            fontSize = 15.sp,
            style = MaterialTheme.typography.titleSmall,
            color = Color(0xFFFFFFFF),
            modifier = Modifier
                .alpha(0.5f)
                .padding(
                    top = 49.dp,
                    bottom = 10.dp,
                    start = 92.dp
                )
        )*/

    }



}
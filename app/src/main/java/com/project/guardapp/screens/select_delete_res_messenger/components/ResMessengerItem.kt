package com.project.guardapp.screens.select_delete_res_messenger.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
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
import java.nio.file.WatchEvent

@Preview
@Composable
fun PreviewPackageItem(){
    PackageResItem(
        "Telegram image",
        "234.2 mb",
        {}
    )
}

@Composable
fun PackageResItem(
              title:String,

              appSize : String,
              actionClick:(String)->Unit,
) {



    Box(
        modifier = Modifier
            .width(320.dp)
            .wrapContentHeight()
            .clickable {
                actionClick("")
            }


    ) {



            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(303.dp)
                    .height(73.dp)
                    .align(Alignment.Center)
                    .alpha(0.0f)
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
                .clickable {
                    actionClick("")
                }
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
            painter = painterResource(id = R.drawable.img_16),
            modifier = Modifier
                .padding(
                    top = 22.dp,
                    start = 28.dp
                )
                .size(35.dp)

            ,
            contentDescription = null)

       Column(
           modifier =
           Modifier
               .wrapContentWidth()
               .padding(start = 65.dp)
               .align(Alignment.CenterStart)
       ){
           Text(
               text = title,
               fontSize = 17.sp,
               style = MaterialTheme.typography.titleSmall,
               color = Color(0xFFFFFFFF),
               modifier = Modifier
                   .padding(
                       start = 20.dp,
                       // bottom = 15.dp
                   )
                   .wrapContentWidth()
                   .wrapContentHeight()
           )
           Text(
               text = appSize,
               fontSize = 12.sp,
               style = MaterialTheme.typography.titleSmall,
               color = Color(0xFFFFFFFF),
               modifier = Modifier
                   .padding(
                       start = 20.dp,
                   )
                   .wrapContentWidth()
                   .alpha(0.5F)
                   .wrapContentHeight()
           )
       }




    }



}
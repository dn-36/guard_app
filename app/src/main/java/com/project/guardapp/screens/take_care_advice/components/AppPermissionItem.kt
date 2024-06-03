package com.project.guardapp.screens.take_care_advice.components

import android.graphics.Bitmap
import android.graphics.Picture
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.guardapp.R
import com.project.guardapp.utils.beginChars
import com.project.guardapp.utils.lastChars

@RequiresApi(Build.VERSION_CODES.P)
@Preview
@Composable
fun PreviewAppPermissionItem() {
    AppPermissionItem(
        icon = Bitmap.createBitmap(Picture()),
        title = "Telegramm",
        listOf("permission1","permission2")

    )
}

@Composable
fun AppPermissionItem(
    icon:Bitmap,
    title:String,
    listPermission:List<String>,

    ) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(170.dp)
        .padding(bottom = 20.dp)
        .clip(shape = RoundedCornerShape(size = 10.dp))
        .background(Color(0xFF1B2B41))
    ) {
        Image(
            bitmap = icon.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 15.dp, top = 10.dp)
                .size(65.dp)
                .align(Alignment.CenterStart)
        )
        Column(
            modifier = Modifier
                .padding(start = 45.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = "${title.beginChars(15)}",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .height(30.dp),
                fontSize = 20.sp,
                color = Color.White)
            LazyColumn(
                modifier = Modifier
                    .padding(start = 10.dp)
            ){
                items(listPermission){
                    Row(modifier = Modifier
                        .padding(top = 5.dp)) {
                        Image(painter = painterResource(id = R.drawable.setting),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .size(20.dp))
                        Text(text ="${it.lastChars(15)}",
                            modifier = Modifier.padding(start = 5.dp),
                            fontSize = 15.sp,
                            color = Color(0xFF52647C))
                    }
                }
            }
            Text(text = "... and other permissions", fontSize = 15.sp, color = Color(0xFF52647C))
        }
    }
}
package com.project.guardapp.screens.duplicate_contact.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun PreviewContactItem(){
    ContactItem(
    "Dima",
          "89963799050",
        true,
        {}
    )
}

@Composable
fun ContactItem(
    name:String,
    numper:String,
    isPressed:Boolean,
    actionClick:()->Unit
    ) {



    Box(
        modifier = Modifier
            .width(320.dp)
            .height(90.dp)
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
                painter = painterResource(id = R.drawable.img_5),
                contentDescription = null,
                modifier = Modifier
                    .width(300.dp)
                    .height(100.dp)
                    .align(Alignment.Center)
            )

            Text(
                text = name,
                fontSize = 20.sp,
                color = Color(0xFFFFFFFF),
                modifier = Modifier
                    .padding(
                        top = 18.dp,
                        start = 72.dp
                    )
            )

            Text(
                text = numper,
                color = Color(0xFF52647C),
                modifier = Modifier
                    .padding(
                        top = 44.dp,
                        start = 72.dp
                    )
            )
        }

}
package com.project.guardapp.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object GetBitmapFromDrawableRes {

    fun excecute(context: Context, drawableRes: Int): Bitmap?{
        val drawable = ContextCompat.getDrawable(context, drawableRes)
        drawable?.let {
            val bitmap =
                Bitmap.createBitmap(it.intrinsicWidth, it.intrinsicHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            it.setBounds(0, 0, canvas.width, canvas.height)
            it.draw(canvas)
            return@let bitmap
        }
        return null
    }


}


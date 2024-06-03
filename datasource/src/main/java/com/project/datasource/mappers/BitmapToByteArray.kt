package com.project.datasource.mappers

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream


fun Bitmap.bitmapToByteArray(format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG, quality: Int = 100): ByteArray {
    val byteArrayOutputStream = ByteArrayOutputStream()
    this.compress(format, quality, byteArrayOutputStream)
    return byteArrayOutputStream.toByteArray()
}


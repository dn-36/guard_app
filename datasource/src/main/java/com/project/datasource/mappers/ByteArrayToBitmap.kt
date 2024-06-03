package module.repository.mappers

import android.graphics.Bitmap
import android.graphics.BitmapFactory

fun ByteArray.byteArrayToBitmap(): Bitmap? {
    return BitmapFactory.decodeByteArray(this, 0, this.size)
}

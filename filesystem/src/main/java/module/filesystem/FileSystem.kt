package module.filesystem

import android.annotation.SuppressLint
import android.os.Environment
import android.util.Log
import java.io.File
import kotlin.math.pow
import kotlin.math.round

class FileSystem {
    companion object {
        private val isVersion10Plus = (getAndroidVersion() > 29)
        private val externalStorageDirectory = Environment.getExternalStorageDirectory().path
        private val WHATS_APP_PATCH_MEDIA_UP_TO_10 = externalStorageDirectory + "/Whatsapp/Media/"
        private val WHATS_APP_PATCH_MUSIC_UP_TO_10 =
            externalStorageDirectory + "/WhatsApp/Media/WhatsApp Audio"
        private val WHATS_APP_PATCH_VIDEO_UP_TO_10 =
            externalStorageDirectory + "/WhatsApp/Media/WhatsApp Video"
        private val WHATS_APP_PATCH_DOCUMENT_UP_TO_10 =
            externalStorageDirectory + "/WhatsApp/Media/WhatsApp Documents"
        private val WHATS_APP_PATCH_IMAGE_UP_TO_10 =
            externalStorageDirectory + "/WhatsApp/Media/WhatsApp Images"
        private val WHATS_APP_PATCH_VOICE_UP_TO_10 =
            externalStorageDirectory + "/WhatsApp/Media/WhatsApp Voice Notes"

        private val WHATS_APP_PATCH_MEDIA_SDK_10_PLUS =
            externalStorageDirectory + "/Android/media/com.whatsapp/Whatsapp/Media/"
        private val WHATS_APP_PATCH_MUSIC_SDK_10_PLUS =
            externalStorageDirectory + "/Android/media/com.whatsapp/WhatsApp/Media/WhatsApp Audio"
        private val WHATS_APP_PATCH_VIDEO_SDK_10_PLUS =
            externalStorageDirectory + "/Android/media/com.whatsapp/WhatsApp/Media/WhatsApp Video"
        private val WHATS_APP_PATCH_DOCUMENT_SDK_10_PLUS =
            externalStorageDirectory + "/Android/media/com.whatsapp/WhatsApp/Media/WhatsApp Documents"
        private val WHATS_APP_PATCH_IMAGE_SDK_10_PLUS =
            externalStorageDirectory + "/Android/media/com.whatsapp/WhatsApp/Media/WhatsApp Images"
        private val WHATS_APP_PATCH_VOICE_SDK_10_PLUS =
            externalStorageDirectory + "/Android/media/com.whatsapp/WhatsApp/Media/WhatsApp Voice Notes"


        val WHATS_APP_PATCH_MEDIA =
            if (isVersion10Plus) WHATS_APP_PATCH_MEDIA_SDK_10_PLUS else WHATS_APP_PATCH_MEDIA_UP_TO_10
        val WHATS_APP_PATCH_MUSIC =
            if (isVersion10Plus) WHATS_APP_PATCH_MUSIC_SDK_10_PLUS else WHATS_APP_PATCH_MUSIC_UP_TO_10
        val WHATS_APP_PATCH_VIDEO =
            if (isVersion10Plus) WHATS_APP_PATCH_VIDEO_SDK_10_PLUS else WHATS_APP_PATCH_VIDEO_UP_TO_10
        val WHATS_APP_PATCH_DOCUMENT =
            if (isVersion10Plus) WHATS_APP_PATCH_DOCUMENT_SDK_10_PLUS else WHATS_APP_PATCH_DOCUMENT_UP_TO_10
        val WHATS_APP_PATCH_IMAGE =
            if (isVersion10Plus) WHATS_APP_PATCH_IMAGE_SDK_10_PLUS else WHATS_APP_PATCH_IMAGE_UP_TO_10
        val WHATS_APP_PATCH_VOICE =
            if (isVersion10Plus) WHATS_APP_PATCH_VOICE_SDK_10_PLUS else WHATS_APP_PATCH_VOICE_UP_TO_10


        val TELEGRAM_DOCUMENTS_PATCH = externalStorageDirectory + "/Download/Telegram/"
        val TELEGRAM_VIDEO_PATCH = externalStorageDirectory + "/Movies/Telegram/"
        val TELEGRAM_IMAGE_PATCH = externalStorageDirectory + "/Pictures/Telegram/"
        val TELEGRAM_MUSIC_PATCH = externalStorageDirectory + "/Music/Telegram/"

        private fun getAndroidVersion(): Int {
            return android.os.Build.VERSION.SDK_INT
        }
    }

     fun getWhatsAppAllMediaSizeMB(): Float {
        Log.d("test_123", isVersion10Plus.toString())
        return getFileSizeMB(
            if (isVersion10Plus) WHATS_APP_PATCH_MEDIA_SDK_10_PLUS
            else WHATS_APP_PATCH_MEDIA_UP_TO_10
        )
    }

     fun getWhatsAppAudioSizeMB(): Float {
        return getFileSizeMB(
            if (isVersion10Plus) WHATS_APP_PATCH_MUSIC_SDK_10_PLUS
            else WHATS_APP_PATCH_MUSIC_UP_TO_10
        )
    }

     fun getWhatsAppDocumentsSizeMB(): Float {
        return getFileSizeMB(
            if (isVersion10Plus) WHATS_APP_PATCH_DOCUMENT_SDK_10_PLUS
            else WHATS_APP_PATCH_DOCUMENT_UP_TO_10
        )
    }

     fun getWhatsAppImagesSizeMB(): Float {
        return getFileSizeMB(
            if (isVersion10Plus) WHATS_APP_PATCH_IMAGE_SDK_10_PLUS
            else WHATS_APP_PATCH_IMAGE_UP_TO_10
        )
    }

     fun getWhatsAppVideoSizeMB(): Float {
        return getFileSizeMB(
            if (isVersion10Plus) WHATS_APP_PATCH_VIDEO_SDK_10_PLUS
            else WHATS_APP_PATCH_VIDEO_UP_TO_10
        )
    }

     fun getWhatsAppVoiceSizeMB(): Float {
        return getFileSizeMB(
            if (isVersion10Plus) WHATS_APP_PATCH_VOICE_SDK_10_PLUS
            else WHATS_APP_PATCH_VOICE_UP_TO_10
        )
    }

     fun getTelegramAllMediaSizeMB(): Float {
        val result = getFileSizeMB(TELEGRAM_DOCUMENTS_PATCH) +
                getFileSizeMB(TELEGRAM_IMAGE_PATCH) +
                getFileSizeMB(TELEGRAM_MUSIC_PATCH) +
                getFileSizeMB(TELEGRAM_VIDEO_PATCH)
        return result.limitDecimalPlacesToFloat(2)
    }

     fun getTelegramAudioSizeMB(): Float {
        val result = getFileSizeMB(TELEGRAM_MUSIC_PATCH)
        return result.limitDecimalPlacesToFloat(2)
    }

     fun getTelegramDocumentsSizeMB(): Float {
        val result = getFileSizeMB(TELEGRAM_DOCUMENTS_PATCH)
        return result.limitDecimalPlacesToFloat(2)
    }

    @SuppressLint("SuspiciousIndentation")
     fun getTelegramImagesSizeMB(): Float {
        val result = getFileSizeMB(TELEGRAM_IMAGE_PATCH)
        return result.limitDecimalPlacesToFloat(2)
    }

    @SuppressLint("SuspiciousIndentation")
     fun getTelegramVideoSizeMB(): Float {
        val result = getFileSizeMB(TELEGRAM_VIDEO_PATCH)
        return result.limitDecimalPlacesToFloat(2)
    }


    fun getFileSizeByte(filePath: String): Long {

        val file = File(filePath)
        if (!file.exists()) {

            return -1L
        }
        if (file.isFile) {

            return file.length()
        } else if (file.isDirectory) {
            val sizePackageByte = (file.listFiles()?.sumOf { it ->
                getFileSizeByte(it.path)

            } ?: -2L)
            return sizePackageByte
        }
        return -1L
    }

   private fun deleteDirectory(directory: File, onComplete: () -> Unit): Boolean {
        if (directory.exists()) {
            Log.d("test_121aa","dskjdsk")
            val files = directory.listFiles()
            if (files != null) {
                for (file in files) {
                    if (file.isDirectory) {
                        Log.d("test_12aa","dskjdsk")
                        deleteDirectory(file, {
                            Log.d("test_13aa","dskjdsk")
                            onComplete()
                        })
                    } else {
                        onComplete()
                        file.delete()
                    }
                }
            }
        }
        Log.d("test_12qaa","dskjdsk")
        val result = directory.delete()
        if (result) onComplete() else onComplete()
        return result
    }


    fun deleteResPackageMassenger(titleRes: String,onComplete: (resString:String) -> Unit){
        when (titleRes) {
            "Telegram image" -> deleteDirectory(File(TELEGRAM_IMAGE_PATCH),
                {
                   onComplete(titleRes)
                })
            "Telegram document" -> deleteDirectory(File(TELEGRAM_DOCUMENTS_PATCH),
                {
                    onComplete(titleRes)
                })

            "Telegram video" -> deleteDirectory(File(TELEGRAM_VIDEO_PATCH),
                {
                    onComplete(titleRes)
                })

            "Telegram audio" -> deleteDirectory(File(TELEGRAM_MUSIC_PATCH),
                {
                    onComplete(titleRes)
                })
            "WhatsApp image" -> deleteDirectory(File(WHATS_APP_PATCH_IMAGE),
                {
                    onComplete(titleRes)
                })//openFolderInFileManager(FileSystem.TELEGRAM_IMAGE_PATCH)
            "WhatsApp document" -> deleteDirectory(File(WHATS_APP_PATCH_DOCUMENT),
                {
                    onComplete(titleRes)
                })

            "WhatsApp video" -> deleteDirectory(File(WHATS_APP_PATCH_VIDEO),
                {
                    onComplete(titleRes)
                })

            "WhatsApp audio" -> deleteDirectory(File(WHATS_APP_PATCH_MUSIC),
                {
                    onComplete(titleRes)
                })
            "WhatsApp voice" -> deleteDirectory(File(WHATS_APP_PATCH_VOICE),
                {
                    onComplete(titleRes)
                })
            //  }
        }


    }

    private fun getFileSizeMB(filePatch: String): Float {
        return ((getFileSizeByte(filePatch).toFloat() / 10_000)
            .toInt().toFloat() / 100F)
    }

    private fun Float.limitDecimalPlacesToFloat(count: Int): Float {
        val multiplier = 10.0.pow(count)
        return (round(this * multiplier) / multiplier).toFloat()
    }

}
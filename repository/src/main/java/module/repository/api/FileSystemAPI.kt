package module.repository.api

interface FileSystemAPI {

    fun getTelegramAllMediaSizeMB():Float
    fun getTelegramAudioSizeMB():Float
    fun getTelegramDocumentsSizeMB():Float
    fun getTelegramImagesSizeMB():Float
    fun getTelegramVideoSizeMB():Float
    fun getWhatsAppAllMediaSizeMB():Float
    fun getWhatsAppAudioSizeMB():Float
    fun getWhatsAppDocumentsSizeMB():Float
    fun getWhatsAppImagesSizeMB():Float
    fun getWhatsAppVideoSizeMB():Float
    fun getWhatsAppVoiceSizeMB():Float
    fun deleteResPackageMassenger(titleRes: String,onComplete: (resString:String) -> Unit)
}
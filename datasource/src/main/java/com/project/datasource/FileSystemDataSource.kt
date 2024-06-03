package com.project.datasource

import module.filesystem.FileSystem
import module.repository.api.FileSystemAPI
import javax.inject.Inject

class FileSystemDataSource @Inject constructor(
    val fileSystem: FileSystem
) : FileSystemAPI {
    override fun getTelegramAllMediaSizeMB(): Float {
      return fileSystem.getTelegramAllMediaSizeMB()
    }

    override fun getTelegramAudioSizeMB(): Float {
        return fileSystem.getTelegramAudioSizeMB()
    }

    override fun getTelegramDocumentsSizeMB(): Float {
        return fileSystem.getTelegramDocumentsSizeMB()
    }

    override fun getTelegramImagesSizeMB(): Float {
        return fileSystem.getTelegramImagesSizeMB()
    }

    override fun getTelegramVideoSizeMB(): Float {
        return fileSystem.getTelegramVideoSizeMB()
    }

    override fun getWhatsAppAllMediaSizeMB(): Float {
        return fileSystem.getWhatsAppAllMediaSizeMB()
    }

    override fun getWhatsAppAudioSizeMB(): Float {
        return fileSystem.getWhatsAppAudioSizeMB()
    }

    override fun getWhatsAppDocumentsSizeMB(): Float {
        return fileSystem.getWhatsAppDocumentsSizeMB()
    }

    override fun getWhatsAppImagesSizeMB(): Float {
        return fileSystem.getWhatsAppImagesSizeMB()
    }

    override fun getWhatsAppVideoSizeMB(): Float {
        return fileSystem.getWhatsAppVideoSizeMB()
    }

    override fun getWhatsAppVoiceSizeMB(): Float {
        return fileSystem.getWhatsAppVoiceSizeMB()
    }

    override fun deleteResPackageMassenger(
        titleRes: String,
        onComplete: (resString: String) -> Unit
    ) {
       fileSystem.deleteResPackageMassenger(titleRes,onComplete)
    }
}
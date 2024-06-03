package module.domain.usecases

import module.domain.model.PackageResAppDomain
import module.domain.repository.RepositoryApi
import java.io.File

class PackageResAppUseCase(
    val repository: RepositoryApi
) {
    var listMediaFile = mutableListOf<PackageResAppDomain>()
    fun getInfoPackageSizeMbMessenger(title: String): List<PackageResAppDomain> {

        when (title) {
            "WhatsApp" -> {
                addMediaFileList("WhatsApp image", repository.getWhatsAppImagesSizeMB())
                addMediaFileList("WhatsApp document", repository.getWhatsAppDocumentsSizeMB())
                addMediaFileList("WhatsApp video", repository.getWhatsAppVideoSizeMB())
                addMediaFileList("WhatsApp audio", repository.getWhatsAppAudioSizeMB())
                addMediaFileList("WhatsApp voice", repository.getWhatsAppVoiceSizeMB())
            }

            "Telegram" -> {
                addMediaFileList("Telegram image", repository.getTelegramImageSizeMB())
                addMediaFileList("Telegram document", repository.getTelegramDocumentsSizeMB())
                addMediaFileList("Telegram video", repository.getTelegramVideoSizeMB())
                addMediaFileList("Telegram audio", repository.getTelegramAudioSizeMB())
            }
        }

        return listMediaFile
    }

    private fun addMediaFileList(title: String, sizeFile: Float) {
        listMediaFile.add(
            PackageResAppDomain(
                title = title,
                mediaFileSize = sizeFile
            )
        )
    }

    fun deleteResPackageMassenger(titleRes: String,onComplited:(String)->Unit) {
        repository.deleteDirectoryRecourse(titleRes, onComplited = onComplited)
    }




      /*  when (titleRes) {
            "Telegram image" -> repository.deleteDirectory(File(FileSystem.TELEGRAM_IMAGE_PATCH),
                {
                    deleteResAppsState =
                        deleteResAppsState.copy(isVisibilityLoading = false)
                })//openFolderInFileManager(FileSystem.TELEGRAM_IMAGE_PATCH)
            "Telegram document" -> deleteDirectory(File(FileSystem.TELEGRAM_DOCUMENTS_PATCH),
                {
                    deleteResAppsState =
                        deleteResAppsState.copy(isVisibilityLoading = false)
                })

            "Telegram video" -> deleteDirectory(File(FileSystem.TELEGRAM_VIDEO_PATCH),
                {
                    deleteResAppsState =
                        deleteResAppsState.copy(isVisibilityLoading = false)
                })

            "Telegram audio" -> deleteDirectory(File(FileSystem.TELEGRAM_MUSIC_PATCH),
                {
                    deleteResAppsState =
                        deleteResAppsState.copy(isVisibilityLoading = false)
                })
            "WhatsApp image" -> deleteDirectory(File(FileSystem.WHATS_APP_PATCH_IMAGE),
                {
                    deleteResAppsState =
                        deleteResAppsState.copy(isVisibilityLoading = false)
                })//openFolderInFileManager(FileSystem.TELEGRAM_IMAGE_PATCH)
            "WhatsApp document" -> deleteDirectory(File(FileSystem.WHATS_APP_PATCH_DOCUMENT),
                {
                    deleteResAppsState =
                        deleteResAppsState.copy(isVisibilityLoading = false)
                })

            "WhatsApp video" -> deleteDirectory(File(FileSystem.WHATS_APP_PATCH_VIDEO),
                {
                    deleteResAppsState =
                        deleteResAppsState.copy(isVisibilityLoading = false)
                })

            "WhatsApp audio" -> deleteDirectory(File(FileSystem.WHATS_APP_PATCH_MUSIC),
                {
                    deleteResAppsState =
                        deleteResAppsState.copy(isVisibilityLoading = false)
                })
            "WhatsApp voice" -> deleteDirectory(File(FileSystem.WHATS_APP_PATCH_VOICE),
                {
                    deleteResAppsState =
                        deleteResAppsState.copy(isVisibilityLoading = false)
                })
            //  }
        }
}
}*/


}
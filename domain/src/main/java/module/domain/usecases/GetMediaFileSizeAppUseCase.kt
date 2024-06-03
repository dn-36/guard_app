package module.domain.usecases

import module.domain.model.MediaFileSizeDomain
import module.domain.repository.RepositoryApi

    class GetMediaFileSizeAppUseCase(
        val repository: RepositoryApi
    ) {

        operator fun invoke(): List<MediaFileSizeDomain> = filterListMessenger(repository)


        private fun filterListMessenger(installsApps: RepositoryApi): List<MediaFileSizeDomain> {
            val listMessenger = mutableListOf<MediaFileSizeDomain>()
            for (app in installsApps.getInstalledApps().listAppInfo) {
                when (app.title) {
                    "WhatsApp" -> {
                        listMessenger.add(
                            MediaFileSizeDomain(
                                title = app.title,
                                icon = app.icon,
                                mediaFileSize = installsApps.getWhatsAppAllMediaSizeMB()
                            )
                        )
                    }

                    "Telegram" -> {
                        listMessenger.add(
                            MediaFileSizeDomain(
                                title = app.title,
                                icon = app.icon,
                                mediaFileSize = installsApps.getTelegramAllMediaSizeMB()
                            )
                        )
                    }
                }
            }

            return listMessenger
        }
    }

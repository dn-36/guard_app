package module.domain.usecases

import module.domain.model.InstalledAppsDomain
import module.domain.repository.RepositoryApi

class GetInstalledAppsUseCase (
    val repository: RepositoryApi
) {

    operator fun invoke(): InstalledAppsDomain = repository.getInstalledApps()

}
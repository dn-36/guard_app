package module.domain.usecases

import module.domain.repository.RepositoryApi

class DeleteAppUseCase constructor(
    val repository: RepositoryApi
) {

    operator fun invoke(packageName: String) {
        repository.deleteInstalledApp(packageName)
    }
}
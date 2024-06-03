package module.domain.usecases

import module.domain.repository.RepositoryApi

class GetInfoPermissionUseCase (
    val repository: RepositoryApi
) {

    operator fun invoke() = repository.getInfoPermission()

}
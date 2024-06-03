package module.domain.usecases

import module.domain.repository.RemoteConfigDomain
import module.domain.repository.RepositoryApi

class GetFireBaseInfoUseCase (
    val repository: RepositoryApi
) {
    operator fun invoke(
        onSuccessful: (firebaseRemoteConfig: RemoteConfigDomain) -> Unit,
        onError: () -> Unit
    ) {
        repository.getFireBaseConfig(
            onSuccessful,
            onError
        )

    }
}
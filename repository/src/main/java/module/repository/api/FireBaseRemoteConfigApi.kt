package module.repository.api

import module.domain.repository.RemoteConfigDomain

interface FireBaseRemoteConfigApi {
    fun execute(
        onSuccessful: (remoteConfig: RemoteConfigDomain) -> Unit,
        onError: () -> Unit
    )
}
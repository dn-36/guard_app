package com.project.remoteconfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.project.remoteconfig.FirebaseRemoteConfigRepository
import com.project.remoteconfig.RemoteConfigRepository


class FireBaseConfig {

    operator fun invoke(
        onSuccessful: (remoteConfig: RemoteConfigRepository) -> Unit,
        onError: () -> Unit
    ) {
        val fireBase = FirebaseRemoteConfig.getInstance()
        try {
            fireBase.fetchAndActivate()
                .addOnCompleteListener { fb ->
                    if (fb.isSuccessful) {
                        onSuccessful(FirebaseRemoteConfigRepository(fireBase))
                    } else {
                        onError()
                    }
                }
        } catch (e: Exception) {
            onError()
        }
    }
}


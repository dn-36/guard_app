package com.project.datasource

import module.repository.api.FireBaseRemoteConfigApi
import com.project.remoteconfig.FireBaseConfig
import com.project.remoteconfig.RemoteConfigRepository
import module.domain.repository.RemoteConfigDomain

import javax.inject.Inject

class FireBaseRemoteConfigDataSource @Inject constructor(
    val fireBaseConfig: FireBaseConfig
): FireBaseRemoteConfigApi {

    override fun execute(
        onSuccessful: (remoteConfig: RemoteConfigDomain) -> Unit,
        onError: () -> Unit
    ) {
        fireBaseConfig(
            { onSuccessful(object : RemoteConfigDomain{
                override fun getStringValue(key: String): String = it.getStringValue(key)


                override fun getLongValue(key: String): Long = it.getLongValue(key)

                override fun getBooleanValue(key: String): Boolean = it.getBooleanValue(key)

            })},
            {onError()}
        )
    }

}
package com.project.remoteconfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig

internal class FirebaseRemoteConfigRepository(private val firebaseRemoteConfig: FirebaseRemoteConfig) :
    RemoteConfigRepository {

    override fun getStringValue(key: String): String = firebaseRemoteConfig.getString(key)
    override fun getLongValue(key: String): Long = firebaseRemoteConfig.getLong(key)
    override fun getBooleanValue(key: String): Boolean = firebaseRemoteConfig.getBoolean(key)
}



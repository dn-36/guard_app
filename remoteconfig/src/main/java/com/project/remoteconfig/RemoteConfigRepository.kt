package com.project.remoteconfig   // Domain Layer


interface RemoteConfigRepository {
    fun getStringValue(key: String): String
    fun getLongValue(key: String): Long
    fun getBooleanValue(key: String): Boolean
}

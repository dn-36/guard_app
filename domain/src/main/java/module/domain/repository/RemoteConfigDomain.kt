package module.domain.repository

interface RemoteConfigDomain{
  fun getStringValue(key: String): String
  fun getLongValue(key: String): Long
  fun getBooleanValue(key: String): Boolean
}
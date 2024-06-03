package module.repository.impl

import module.domain.repository.RemoteConfigDomain
import javax.inject.Inject

class RemoteConfigImpl @Inject constructor(
   val data: RemoteConfigDomain
) : RemoteConfigDomain {
    override fun getStringValue(key: String): String = data.getStringValue(key)
    override fun getLongValue(key: String): Long = data.getLongValue(key)
    override fun getBooleanValue(key: String): Boolean = data.getBooleanValue(key)
}
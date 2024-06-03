package module.repository.api

import module.domain.model.InstalledAppsDomain
import module.domain.model.PhoneModelDomain
import module.domain.repository.AppPermissionDomain


interface PhoneInfoAPI {
    fun getModelPhone(): PhoneModelDomain
    fun getInstalledApps(): InstalledAppsDomain
    fun deleteAppByAppName(appName: String)
    fun getInfoPermission():MutableList<AppPermissionDomain>
}
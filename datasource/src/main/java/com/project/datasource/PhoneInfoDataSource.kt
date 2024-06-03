package com.project.datasource

import module.domain.model.InstalledAppsDomain
import module.domain.model.PhoneModelDomain
import module.domain.repository.AppPermissionDomain
import module.repository.api.PhoneInfoAPI
import module.phoneinfo.PhoneInfo
import module.repository.mappers.toInstalledAppsDomain
import com.project.datasource.mappers.toPhoneModelDomain
import javax.inject.Inject


class PhoneInfoDataSource @Inject constructor(
    val phoneInfo : PhoneInfo
) : PhoneInfoAPI {
    override fun getModelPhone(): PhoneModelDomain = phoneInfo.getModelPhone().toPhoneModelDomain()

    override fun getInstalledApps(): InstalledAppsDomain = phoneInfo.getInstalledApps().toInstalledAppsDomain()

    override fun deleteAppByAppName(appName: String) = phoneInfo.deleteAppByAppName(appName)

    override fun getInfoPermission(): MutableList<AppPermissionDomain>{
        val list = mutableListOf<AppPermissionDomain>()
        for(info in phoneInfo.getInfoPermission()){
            list.add(object : AppPermissionDomain{
                override val appName: String
                    get() = info.appName
                override val appIcon: ByteArray
                    get() = info.appIcon
                override val listPermssion: List<String>
                    get() = info.listPermssion

            })
        }
        return  list
    }

}


package module.repository.mappers

import com.project.datasource.mappers.bitmapToByteArray
import module.domain.model.InfoAppDomain
import module.domain.model.InstalledAppsDomain
import module.phoneinfo.model.InstalledAppsData

fun InstalledAppsData.toInstalledAppsDomain(): InstalledAppsDomain {
    val listContactDomain =  arrayListOf<InfoAppDomain>()

    for(app in listAppInfo){
        listContactDomain.add(InfoAppDomain(
            app.name,
            app.icon.bitmapToByteArray(),
            app.bundleApp
        ))
    }
    return InstalledAppsDomain(
        listContactDomain.toList(),
    )
}

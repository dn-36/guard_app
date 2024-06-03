package module.repository.impl

import module.repository.api.AdMobApi
import module.repository.api.ContactManegerApi
import module.repository.api.FileSystemAPI
import module.repository.api.FireBaseRemoteConfigApi
import module.repository.api.PhoneInfoAPI
import com.project.guardapp.data.repository.api.SharedPrefsAPI
import module.domain.model.ContactDomain
import module.repository.api.YandexAppMetricaApi
import module.domain.model.InstalledAppsDomain
import module.domain.repository.AppPermissionDomain
import module.domain.repository.RemoteConfigDomain
import module.domain.repository.RepositoryApi
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    val phoneInfo: PhoneInfoAPI,
    val contactManeger: ContactManegerApi,
    val fileSystem: FileSystemAPI,
    val sharedPrefs: SharedPrefsAPI,
    val fireBaseConfig: FireBaseRemoteConfigApi,
    val adMob: AdMobApi,
    val yandexAppMetrica: YandexAppMetricaApi
) : RepositoryApi {
    override fun getInphoPhoneModel() = phoneInfo.getModelPhone()


    override fun getAllContacts(): List<ContactDomain> = contactManeger.getAllContacts()
    override fun deleteContact(name: String) {
       contactManeger.deleteContact(name)
    }

    override fun getWhatsAppAllMediaSizeMB(): Float {
        return fileSystem.getWhatsAppAllMediaSizeMB()
    }

    override fun getWhatsAppAudioSizeMB(): Float {
        return fileSystem.getWhatsAppAudioSizeMB()
    }

    override fun getWhatsAppDocumentsSizeMB(): Float {
        return fileSystem.getWhatsAppDocumentsSizeMB()
    }

    override fun getWhatsAppImagesSizeMB(): Float {
        return fileSystem.getWhatsAppImagesSizeMB()
    }

    override fun getWhatsAppVideoSizeMB(): Float {
        return fileSystem.getWhatsAppVideoSizeMB()
    }

    override fun getWhatsAppVoiceSizeMB(): Float {
        return fileSystem.getWhatsAppVoiceSizeMB()
    }

    override fun getLastSavedDay(): Int {
        return sharedPrefs.getSavedLastDay()
    }

    override fun setLastSavedDay(day: Int) {
        sharedPrefs.setSavedLastDay(day)
    }

    override fun getTime(): String {
        return sharedPrefs.getTime()
    }

    override fun setTime(string: String) {
        sharedPrefs.setTime(string)
    }

    override fun getFreeMegabytes(): Float {
        return sharedPrefs.getFreeMegabytes()
    }

    override fun setFreeMegabytes(megabytes: Float) {
        sharedPrefs.setFreeMegabytes(megabytes)
    }

    override fun setTakeCareDeviceDone(isDone: Boolean) {
        sharedPrefs.setTakeCareDeviceDone(isDone)
    }

    override fun getTakeCareDeviceDone(): Boolean {
        return sharedPrefs.getTakeCareDeviceDone()
    }

    override fun setOptimizationRememberDone(isDone: Boolean) {
        sharedPrefs.setOptimizationRememberDone(isDone)
    }

    override fun getOptimizationRememberDone(): Boolean {
        return sharedPrefs.getOptimizationRememberDone()
    }

    override fun setHaccersDone(isDone: Boolean) {
        sharedPrefs.setHaccersDone(isDone)
    }

    override fun getHaccersDone(): Boolean {
        return sharedPrefs.getHaccersDone()
    }

    override fun setContactsDone(isDone: Boolean) {
        sharedPrefs.setContactsDone(isDone)
    }

    override fun getContactsDone(): Boolean {
        return sharedPrefs.getContactsDone()
    }

    override fun setMessengersDone(isDone: Boolean) {
        sharedPrefs.setMessengersDone(isDone)
    }

    override fun getMessengersDone(): Boolean {
        return sharedPrefs.getMessengersDone()
    }

    override fun setApplicationDone(isDone: Boolean) {
        sharedPrefs.setApplicationDone(isDone)
    }

    override fun getApplicationDone(): Boolean {
        return sharedPrefs.getApplicationDone()
    }

    override fun setBeginTitleNotification(title: String) {
        sharedPrefs.setBeginTitleNotification(title)
    }

    override fun getBeginTitleNotification(): String {
        return sharedPrefs.getBeginTitleNotification()
    }

    override fun setDescreptionNotification(title: String) {
        sharedPrefs.setDescreptionNotification(title)
    }

    override fun getDescreptionNotification(): String {
        return sharedPrefs.getDescreptionNotification()
    }

    override fun setFormatNotifivation(format: String) {
        sharedPrefs.setFormatNotifivation(format)
    }

    override fun getFormatTitleNotifivation(): String {
        return sharedPrefs.getFormatNotifivation()
    }

    override fun setAftherTitleNotification(title: String) {
        sharedPrefs.setAftherTitleNotification(title)
    }

    override fun getAftrherTitleNotification(): String {
        return sharedPrefs.getAftrherTitleNotification()
    }

    override fun rebootProgressDateBase() {
        sharedPrefs.rebootProgressClearDateBase()
    }

    override fun initYandexMetrica(key: String) {
        yandexAppMetrica.init(key)
    }


    override fun sendEventYandexMetrica(titleEvent: String) {
        yandexAppMetrica.sendEventYandexAppMetrica(titleEvent)
    }

    override fun adMobShowAds(
        actionOnAdClicked:()->Unit,
        actionOnAdShow:()->Unit) {
        adMob.showAds(
        actionOnAdClicked,
        actionOnAdShow
        )
    }


    override fun adMobLoadAds(onAdLoaded: () -> Unit, appId: String) {
       adMob.loadAds(onAdLoaded,appId)
    }

    override fun getFireBaseConfig(
        onSuccessful: (firebaseRemoteConfig: RemoteConfigDomain) -> Unit,
        onError: () -> Unit
    ) {
        fireBaseConfig.execute(
            {fireBase ->onSuccessful(RemoteConfigImpl(fireBase))},
            onError)
    }

    override fun deleteResPackageMassenger(
        titleRes: String,
        onComplete: (resString: String) -> Unit
    ) {
        fileSystem.deleteResPackageMassenger(titleRes,onComplete)
    }


    override fun getTelegramAllMediaSizeMB(): Float {
        return fileSystem.getTelegramAllMediaSizeMB()
    }

    override fun getTelegramAudioSizeMB(): Float = fileSystem.getTelegramAudioSizeMB()


    override fun getTelegramDocumentsSizeMB(): Float = fileSystem.getTelegramDocumentsSizeMB()

    override fun getTelegramImageSizeMB(): Float = fileSystem.getTelegramImagesSizeMB()

    override fun getTelegramVideoSizeMB(): Float = fileSystem.getTelegramVideoSizeMB()


    override fun getInstalledApps(): InstalledAppsDomain =
        phoneInfo.getInstalledApps()

    override fun deleteInstalledApp(packageApp: String) {
        phoneInfo.deleteAppByAppName(packageApp)
    }

    override fun deleteDirectoryRecourse(titleDirectory: String,onComplited:(String)->Unit) {
       fileSystem.deleteResPackageMassenger(titleDirectory,{
           onComplited(it)
       })
    }

    override fun getInfoPermission(): MutableList<AppPermissionDomain> = phoneInfo.getInfoPermission()


}

package module.domain.repository

import module.domain.model.ContactDomain
import module.domain.model.InstalledAppsDomain
import module.domain.model.PhoneModelDomain

interface RepositoryApi {
  fun getInphoPhoneModel(): PhoneModelDomain
  fun getAllContacts(): List<ContactDomain>
  fun deleteContact(name:String)
  fun getInstalledApps(): InstalledAppsDomain
  fun deleteInstalledApp(packageApp:String)
  fun deleteDirectoryRecourse(titleDirectory: String,onComplited:(String)->Unit)
  fun getInfoPermission():MutableList<AppPermissionDomain>
  fun getTelegramAllMediaSizeMB():Float
  fun getTelegramAudioSizeMB():Float
  fun getTelegramDocumentsSizeMB():Float
  fun getTelegramImageSizeMB():Float
  fun getTelegramVideoSizeMB():Float
  fun getWhatsAppAllMediaSizeMB():Float
  fun getWhatsAppAudioSizeMB():Float
  fun getWhatsAppDocumentsSizeMB():Float
  fun getWhatsAppImagesSizeMB():Float
  fun getWhatsAppVideoSizeMB():Float
  fun getWhatsAppVoiceSizeMB():Float
  fun getLastSavedDay():Int
  fun setLastSavedDay(data:Int)
  fun getTime(): String
  fun setTime(string:String)
  fun getFreeMegabytes(): Float
  fun setFreeMegabytes(megabytes:Float)
  fun setTakeCareDeviceDone(isDone:Boolean)
  fun getTakeCareDeviceDone():Boolean
  fun setOptimizationRememberDone(isDone:Boolean)
  fun getOptimizationRememberDone():Boolean
  fun setHaccersDone(isDone:Boolean)
  fun getHaccersDone():Boolean
  fun setContactsDone(isDone:Boolean)
  fun getContactsDone():Boolean
  fun setMessengersDone(isDone:Boolean)
  fun getMessengersDone():Boolean
  fun setApplicationDone(isDone:Boolean)
  fun getApplicationDone():Boolean
  fun setBeginTitleNotification(title:String)
  fun getBeginTitleNotification():String
  fun setDescreptionNotification(title:String)
  fun getDescreptionNotification():String
  fun setFormatNotifivation(format:String)
  fun getFormatTitleNotifivation():String
  fun setAftherTitleNotification(title:String)
  fun getAftrherTitleNotification():String
  fun rebootProgressDateBase()
  fun initYandexMetrica(key:String)
  fun sendEventYandexMetrica(titleEvent:String)
  fun adMobShowAds(
    actionOnAdClicked:()->Unit,
    actionOnAdShow:()->Unit
  )
  fun  adMobLoadAds(onAdLoaded: () -> Unit = {}, appId:String)
  fun  getFireBaseConfig(
      onSuccessful:(
        firebaseRemoteConfig: RemoteConfigDomain
      )->Unit,
      onError:()->Unit
    )
  fun deleteResPackageMassenger(titleRes: String,onComplete: (resString:String) -> Unit)
}
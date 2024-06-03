package module.repository.impl;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b(\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u001e\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\"2\u0006\u0010#\u001a\u00020$H\u0016J$\u0010%\u001a\u00020 2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\"2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020 0\"H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020$H\u0016J$\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020$2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020 0-H\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020$H\u0016J3\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020$2!\u00102\u001a\u001d\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b3\u0012\b\b)\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020 0-H\u0016J\b\u00105\u001a\u00020$H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020807H\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020$H\u0016J\b\u0010<\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020$H\u0016J9\u0010\u0017\u001a\u00020 2!\u0010>\u001a\u001d\u0012\u0013\u0012\u00110?\u00a2\u0006\f\b3\u0012\b\b)\u0012\u0004\b\b(@\u0012\u0004\u0012\u00020 0-2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020 0\"H\u0016J\b\u0010B\u001a\u00020$H\u0016J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020:H\u0016J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020H0GH\u0016J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020:H\u0016J\b\u0010P\u001a\u00020:H\u0016J\b\u0010Q\u001a\u00020:H\u0016J\b\u0010R\u001a\u00020DH\u0016J\b\u0010S\u001a\u00020DH\u0016J\b\u0010T\u001a\u00020DH\u0016J\b\u0010U\u001a\u00020DH\u0016J\b\u0010V\u001a\u00020DH\u0016J\b\u0010W\u001a\u00020$H\u0016J\b\u0010X\u001a\u00020DH\u0016J\b\u0010Y\u001a\u00020DH\u0016J\b\u0010Z\u001a\u00020DH\u0016J\b\u0010[\u001a\u00020DH\u0016J\b\u0010\\\u001a\u00020DH\u0016J\b\u0010]\u001a\u00020DH\u0016J\u0010\u0010^\u001a\u00020 2\u0006\u0010_\u001a\u00020$H\u0016J\b\u0010`\u001a\u00020 H\u0016J\u0010\u0010a\u001a\u00020 2\u0006\u0010b\u001a\u00020$H\u0016J\u0010\u0010c\u001a\u00020 2\u0006\u0010d\u001a\u00020$H\u0016J\u0010\u0010e\u001a\u00020 2\u0006\u0010f\u001a\u00020:H\u0016J\u0010\u0010g\u001a\u00020 2\u0006\u0010d\u001a\u00020$H\u0016J\u0010\u0010h\u001a\u00020 2\u0006\u0010f\u001a\u00020:H\u0016J\u0010\u0010i\u001a\u00020 2\u0006\u0010d\u001a\u00020$H\u0016J\u0010\u0010j\u001a\u00020 2\u0006\u0010k\u001a\u00020$H\u0016J\u0010\u0010l\u001a\u00020 2\u0006\u0010m\u001a\u00020DH\u0016J\u0010\u0010n\u001a\u00020 2\u0006\u0010f\u001a\u00020:H\u0016J\u0010\u0010o\u001a\u00020 2\u0006\u0010p\u001a\u00020NH\u0016J\u0010\u0010q\u001a\u00020 2\u0006\u0010f\u001a\u00020:H\u0016J\u0010\u0010r\u001a\u00020 2\u0006\u0010f\u001a\u00020:H\u0016J\u0010\u0010s\u001a\u00020 2\u0006\u0010f\u001a\u00020:H\u0016J\u0010\u0010t\u001a\u00020 2\u0006\u0010u\u001a\u00020$H\u0016R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006v"}, d2 = {"Lmodule/repository/impl/RepositoryImpl;", "Lmodule/domain/repository/RepositoryApi;", "phoneInfo", "Lmodule/repository/api/PhoneInfoAPI;", "contactManeger", "Lmodule/repository/api/ContactManegerApi;", "fileSystem", "Lmodule/repository/api/FileSystemAPI;", "sharedPrefs", "Lcom/project/guardapp/data/repository/api/SharedPrefsAPI;", "fireBaseConfig", "Lmodule/repository/api/FireBaseRemoteConfigApi;", "adMob", "Lmodule/repository/api/AdMobApi;", "yandexAppMetrica", "Lmodule/repository/api/YandexAppMetricaApi;", "(Lmodule/repository/api/PhoneInfoAPI;Lmodule/repository/api/ContactManegerApi;Lmodule/repository/api/FileSystemAPI;Lcom/project/guardapp/data/repository/api/SharedPrefsAPI;Lmodule/repository/api/FireBaseRemoteConfigApi;Lmodule/repository/api/AdMobApi;Lmodule/repository/api/YandexAppMetricaApi;)V", "getAdMob", "()Lmodule/repository/api/AdMobApi;", "getContactManeger", "()Lmodule/repository/api/ContactManegerApi;", "getFileSystem", "()Lmodule/repository/api/FileSystemAPI;", "getFireBaseConfig", "()Lmodule/repository/api/FireBaseRemoteConfigApi;", "getPhoneInfo", "()Lmodule/repository/api/PhoneInfoAPI;", "getSharedPrefs", "()Lcom/project/guardapp/data/repository/api/SharedPrefsAPI;", "getYandexAppMetrica", "()Lmodule/repository/api/YandexAppMetricaApi;", "adMobLoadAds", "", "onAdLoaded", "Lkotlin/Function0;", "appId", "", "adMobShowAds", "actionOnAdClicked", "actionOnAdShow", "deleteContact", "name", "deleteDirectoryRecourse", "titleDirectory", "onComplited", "Lkotlin/Function1;", "deleteInstalledApp", "packageApp", "deleteResPackageMassenger", "titleRes", "onComplete", "Lkotlin/ParameterName;", "resString", "getAftrherTitleNotification", "getAllContacts", "", "Lmodule/domain/model/ContactDomain;", "getApplicationDone", "", "getBeginTitleNotification", "getContactsDone", "getDescreptionNotification", "onSuccessful", "Lmodule/domain/repository/RemoteConfigDomain;", "firebaseRemoteConfig", "onError", "getFormatTitleNotifivation", "getFreeMegabytes", "", "getHaccersDone", "getInfoPermission", "", "Lmodule/domain/repository/AppPermissionDomain;", "getInphoPhoneModel", "Lmodule/domain/model/PhoneModelDomain;", "getInstalledApps", "Lmodule/domain/model/InstalledAppsDomain;", "getLastSavedDay", "", "getMessengersDone", "getOptimizationRememberDone", "getTakeCareDeviceDone", "getTelegramAllMediaSizeMB", "getTelegramAudioSizeMB", "getTelegramDocumentsSizeMB", "getTelegramImageSizeMB", "getTelegramVideoSizeMB", "getTime", "getWhatsAppAllMediaSizeMB", "getWhatsAppAudioSizeMB", "getWhatsAppDocumentsSizeMB", "getWhatsAppImagesSizeMB", "getWhatsAppVideoSizeMB", "getWhatsAppVoiceSizeMB", "initYandexMetrica", "key", "rebootProgressDateBase", "sendEventYandexMetrica", "titleEvent", "setAftherTitleNotification", "title", "setApplicationDone", "isDone", "setBeginTitleNotification", "setContactsDone", "setDescreptionNotification", "setFormatNotifivation", "format", "setFreeMegabytes", "megabytes", "setHaccersDone", "setLastSavedDay", "day", "setMessengersDone", "setOptimizationRememberDone", "setTakeCareDeviceDone", "setTime", "string", "repository_debug"})
public final class RepositoryImpl implements module.domain.repository.RepositoryApi {
    @org.jetbrains.annotations.NotNull
    private final module.repository.api.PhoneInfoAPI phoneInfo = null;
    @org.jetbrains.annotations.NotNull
    private final module.repository.api.ContactManegerApi contactManeger = null;
    @org.jetbrains.annotations.NotNull
    private final module.repository.api.FileSystemAPI fileSystem = null;
    @org.jetbrains.annotations.NotNull
    private final com.project.guardapp.data.repository.api.SharedPrefsAPI sharedPrefs = null;
    @org.jetbrains.annotations.NotNull
    private final module.repository.api.FireBaseRemoteConfigApi fireBaseConfig = null;
    @org.jetbrains.annotations.NotNull
    private final module.repository.api.AdMobApi adMob = null;
    @org.jetbrains.annotations.NotNull
    private final module.repository.api.YandexAppMetricaApi yandexAppMetrica = null;
    
    @javax.inject.Inject
    public RepositoryImpl(@org.jetbrains.annotations.NotNull
    module.repository.api.PhoneInfoAPI phoneInfo, @org.jetbrains.annotations.NotNull
    module.repository.api.ContactManegerApi contactManeger, @org.jetbrains.annotations.NotNull
    module.repository.api.FileSystemAPI fileSystem, @org.jetbrains.annotations.NotNull
    com.project.guardapp.data.repository.api.SharedPrefsAPI sharedPrefs, @org.jetbrains.annotations.NotNull
    module.repository.api.FireBaseRemoteConfigApi fireBaseConfig, @org.jetbrains.annotations.NotNull
    module.repository.api.AdMobApi adMob, @org.jetbrains.annotations.NotNull
    module.repository.api.YandexAppMetricaApi yandexAppMetrica) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.repository.api.PhoneInfoAPI getPhoneInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.repository.api.ContactManegerApi getContactManeger() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.repository.api.FileSystemAPI getFileSystem() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.guardapp.data.repository.api.SharedPrefsAPI getSharedPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.repository.api.FireBaseRemoteConfigApi getFireBaseConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.repository.api.AdMobApi getAdMob() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.repository.api.YandexAppMetricaApi getYandexAppMetrica() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public module.domain.model.PhoneModelDomain getInphoPhoneModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<module.domain.model.ContactDomain> getAllContacts() {
        return null;
    }
    
    @java.lang.Override
    public void deleteContact(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    @java.lang.Override
    public float getWhatsAppAllMediaSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppAudioSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppDocumentsSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppImagesSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppVideoSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppVoiceSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public int getLastSavedDay() {
        return 0;
    }
    
    @java.lang.Override
    public void setLastSavedDay(int day) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getTime() {
        return null;
    }
    
    @java.lang.Override
    public void setTime(@org.jetbrains.annotations.NotNull
    java.lang.String string) {
    }
    
    @java.lang.Override
    public float getFreeMegabytes() {
        return 0.0F;
    }
    
    @java.lang.Override
    public void setFreeMegabytes(float megabytes) {
    }
    
    @java.lang.Override
    public void setTakeCareDeviceDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getTakeCareDeviceDone() {
        return false;
    }
    
    @java.lang.Override
    public void setOptimizationRememberDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getOptimizationRememberDone() {
        return false;
    }
    
    @java.lang.Override
    public void setHaccersDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getHaccersDone() {
        return false;
    }
    
    @java.lang.Override
    public void setContactsDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getContactsDone() {
        return false;
    }
    
    @java.lang.Override
    public void setMessengersDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getMessengersDone() {
        return false;
    }
    
    @java.lang.Override
    public void setApplicationDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getApplicationDone() {
        return false;
    }
    
    @java.lang.Override
    public void setBeginTitleNotification(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getBeginTitleNotification() {
        return null;
    }
    
    @java.lang.Override
    public void setDescreptionNotification(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getDescreptionNotification() {
        return null;
    }
    
    @java.lang.Override
    public void setFormatNotifivation(@org.jetbrains.annotations.NotNull
    java.lang.String format) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getFormatTitleNotifivation() {
        return null;
    }
    
    @java.lang.Override
    public void setAftherTitleNotification(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getAftrherTitleNotification() {
        return null;
    }
    
    @java.lang.Override
    public void rebootProgressDateBase() {
    }
    
    @java.lang.Override
    public void initYandexMetrica(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
    }
    
    @java.lang.Override
    public void sendEventYandexMetrica(@org.jetbrains.annotations.NotNull
    java.lang.String titleEvent) {
    }
    
    @java.lang.Override
    public void adMobShowAds(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> actionOnAdClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> actionOnAdShow) {
    }
    
    @java.lang.Override
    public void adMobLoadAds(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAdLoaded, @org.jetbrains.annotations.NotNull
    java.lang.String appId) {
    }
    
    @java.lang.Override
    public void getFireBaseConfig(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super module.domain.repository.RemoteConfigDomain, kotlin.Unit> onSuccessful, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onError) {
    }
    
    @java.lang.Override
    public void deleteResPackageMassenger(@org.jetbrains.annotations.NotNull
    java.lang.String titleRes, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onComplete) {
    }
    
    @java.lang.Override
    public float getTelegramAllMediaSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getTelegramAudioSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getTelegramDocumentsSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getTelegramImageSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getTelegramVideoSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public module.domain.model.InstalledAppsDomain getInstalledApps() {
        return null;
    }
    
    @java.lang.Override
    public void deleteInstalledApp(@org.jetbrains.annotations.NotNull
    java.lang.String packageApp) {
    }
    
    @java.lang.Override
    public void deleteDirectoryRecourse(@org.jetbrains.annotations.NotNull
    java.lang.String titleDirectory, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onComplited) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<module.domain.repository.AppPermissionDomain> getInfoPermission() {
        return null;
    }
}
package module.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0013"}, d2 = {"Lmodule/di/DataSourceModule;", "", "()V", "provideAdMob", "Lmodule/admob/AdMob;", "context", "Landroid/content/Context;", "provideContactsManeger", "Lmodule/contactmaneger/ContactManager;", "provideFilleSystem", "Lmodule/filesystem/FileSystem;", "provideFireBaseConfig", "Lcom/project/remoteconfig/FireBaseConfig;", "providePhoneInfo", "Lmodule/phoneinfo/PhoneInfo;", "provideSharedPrefs", "Lmodule/sharedprefs/SharedPrefs;", "provideYandexAppMetrica", "Lmodule/yandexappmetrica/YandexAppMetrica;", "di_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DataSourceModule {
    @org.jetbrains.annotations.NotNull
    public static final module.di.DataSourceModule INSTANCE = null;
    
    private DataSourceModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.project.remoteconfig.FireBaseConfig provideFireBaseConfig() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.sharedprefs.SharedPrefs provideSharedPrefs(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.filesystem.FileSystem provideFilleSystem() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.phoneinfo.PhoneInfo providePhoneInfo(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.contactmaneger.ContactManager provideContactsManeger(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.admob.AdMob provideAdMob(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.yandexappmetrica.YandexAppMetrica provideYandexAppMetrica(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
}
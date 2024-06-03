package module.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\'J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\'J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020!H\'\u00a8\u0006\""}, d2 = {"Lmodule/di/RepositoryModule;", "", "()V", "bindAdMob", "Lmodule/repository/api/AdMobApi;", "adMob", "Lcom/project/datasource/AdMobDataSource;", "bindContactsManeger", "Lmodule/repository/api/ContactManegerApi;", "contacts", "Lcom/project/datasource/ContactManagerDataSource;", "bindFileSystem", "Lmodule/repository/api/FileSystemAPI;", "fileSystem", "Lcom/project/datasource/FileSystemDataSource;", "bindFireBase", "Lmodule/repository/api/FireBaseRemoteConfigApi;", "freBaseRemoteConfig", "Lcom/project/datasource/FireBaseRemoteConfigDataSource;", "bindMyRypository", "Lmodule/domain/repository/RepositoryApi;", "systemDataImpl", "Lmodule/repository/impl/RepositoryImpl;", "bindPhoneInfo", "Lmodule/repository/api/PhoneInfoAPI;", "PhoneInfoImpl", "Lcom/project/datasource/PhoneInfoDataSource;", "bindSharedPrefs", "Lcom/project/guardapp/data/repository/api/SharedPrefsAPI;", "sharedPrefs", "Lcom/project/datasource/SharedPrefsDataSource;", "bindYandexAppMetrica", "Lmodule/repository/api/YandexAppMetricaApi;", "Lcom/project/datasource/YandexAppMetricaDataSource;", "di_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract module.domain.repository.RepositoryApi bindMyRypository(@org.jetbrains.annotations.NotNull
    module.repository.impl.RepositoryImpl systemDataImpl);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract module.repository.api.PhoneInfoAPI bindPhoneInfo(@org.jetbrains.annotations.NotNull
    com.project.datasource.PhoneInfoDataSource PhoneInfoImpl);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract module.repository.api.ContactManegerApi bindContactsManeger(@org.jetbrains.annotations.NotNull
    com.project.datasource.ContactManagerDataSource contacts);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract module.repository.api.FileSystemAPI bindFileSystem(@org.jetbrains.annotations.NotNull
    com.project.datasource.FileSystemDataSource fileSystem);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract com.project.guardapp.data.repository.api.SharedPrefsAPI bindSharedPrefs(@org.jetbrains.annotations.NotNull
    com.project.datasource.SharedPrefsDataSource sharedPrefs);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract module.repository.api.FireBaseRemoteConfigApi bindFireBase(@org.jetbrains.annotations.NotNull
    com.project.datasource.FireBaseRemoteConfigDataSource freBaseRemoteConfig);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract module.repository.api.AdMobApi bindAdMob(@org.jetbrains.annotations.NotNull
    com.project.datasource.AdMobDataSource adMob);
    
    @dagger.Binds
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public abstract module.repository.api.YandexAppMetricaApi bindYandexAppMetrica(@org.jetbrains.annotations.NotNull
    com.project.datasource.YandexAppMetricaDataSource adMob);
}
package module.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u001f"}, d2 = {"Lmodule/di/UseCaseModule;", "", "()V", "provideAdMobUseCase", "Lmodule/domain/usecases/AdMobUseCase;", "repositoryApi", "Lmodule/domain/repository/RepositoryApi;", "provideDeleteAppUseCase", "Lmodule/domain/usecases/DeleteAppUseCase;", "provideGetContactsInfoUseCase", "Lmodule/domain/usecases/ContactsUseCase;", "provideGetFireBaseInfoUseCase", "Lmodule/domain/usecases/GetFireBaseInfoUseCase;", "provideGetInfoPermissionUseCase", "Lmodule/domain/usecases/GetInfoPermissionUseCase;", "provideGetInfoPhoneUseCase", "Lmodule/domain/usecases/GetInfoPhoneUseCase;", "provideGetInstalledAppsUseCase", "Lmodule/domain/usecases/GetInstalledAppsUseCase;", "provideGetMediaFileSizeAppUseCase", "Lmodule/domain/usecases/GetMediaFileSizeAppUseCase;", "provideGetSavedAppInfoUseCase", "Lmodule/domain/usecases/GetSavedAppInfoUseCase;", "providePackageResAppUseCase", "Lmodule/domain/usecases/PackageResAppUseCase;", "provideRebootProgressDateBase", "Lmodule/domain/usecases/RebootProgressDateBase;", "provideSaveAppInfoUseCase", "Lmodule/domain/usecases/SaveAppInfoUseCase;", "provideYandexAppMetricaUseCase", "Lmodule/domain/usecases/YandexAppMetricaUseCase;", "di_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class UseCaseModule {
    @org.jetbrains.annotations.NotNull
    public static final module.di.UseCaseModule INSTANCE = null;
    
    private UseCaseModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.AdMobUseCase provideAdMobUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.DeleteAppUseCase provideDeleteAppUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.ContactsUseCase provideGetContactsInfoUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.GetFireBaseInfoUseCase provideGetFireBaseInfoUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.GetInfoPermissionUseCase provideGetInfoPermissionUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.GetInfoPhoneUseCase provideGetInfoPhoneUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.GetInstalledAppsUseCase provideGetInstalledAppsUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.GetMediaFileSizeAppUseCase provideGetMediaFileSizeAppUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.GetSavedAppInfoUseCase provideGetSavedAppInfoUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.PackageResAppUseCase providePackageResAppUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.RebootProgressDateBase provideRebootProgressDateBase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.SaveAppInfoUseCase provideSaveAppInfoUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final module.domain.usecases.YandexAppMetricaUseCase provideYandexAppMetricaUseCase(@org.jetbrains.annotations.NotNull
    module.domain.repository.RepositoryApi repositoryApi) {
        return null;
    }
}
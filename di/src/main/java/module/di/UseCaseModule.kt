package module.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import module.domain.repository.RepositoryApi
import module.domain.usecases.AdMobUseCase
import module.domain.usecases.DeleteAppUseCase
import module.domain.usecases.ContactsUseCase
import module.domain.usecases.GetFireBaseInfoUseCase
import module.domain.usecases.GetInfoPermissionUseCase
import module.domain.usecases.GetInfoPhoneUseCase
import module.domain.usecases.GetInstalledAppsUseCase
import module.domain.usecases.GetMediaFileSizeAppUseCase
import module.domain.usecases.GetSavedAppInfoUseCase
import module.domain.usecases.PackageResAppUseCase
import module.domain.usecases.RebootProgressDateBase
import module.domain.usecases.SaveAppInfoUseCase
import module.domain.usecases.YandexAppMetricaUseCase

import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideAdMobUseCase(repositoryApi: RepositoryApi): AdMobUseCase {
        return AdMobUseCase(repositoryApi)
    }

    @Provides
    @Singleton
    fun provideDeleteAppUseCase(repositoryApi: RepositoryApi): DeleteAppUseCase {
        return DeleteAppUseCase(repositoryApi)
    }
    @Provides
    @Singleton
    fun provideGetContactsInfoUseCase(repositoryApi: RepositoryApi): ContactsUseCase {
        return ContactsUseCase(repositoryApi)
    }
    @Provides
    @Singleton
    fun provideGetFireBaseInfoUseCase(repositoryApi: RepositoryApi): GetFireBaseInfoUseCase {
        return GetFireBaseInfoUseCase(repositoryApi)
    }

    @Provides
    @Singleton
    fun provideGetInfoPermissionUseCase(repositoryApi: RepositoryApi): GetInfoPermissionUseCase {
        return GetInfoPermissionUseCase(repositoryApi)
    }

    @Provides
    @Singleton
    fun provideGetInfoPhoneUseCase(repositoryApi: RepositoryApi): GetInfoPhoneUseCase {
        return GetInfoPhoneUseCase(repositoryApi)
    }

    @Provides
    @Singleton
    fun provideGetInstalledAppsUseCase(repositoryApi: RepositoryApi): GetInstalledAppsUseCase {
        return GetInstalledAppsUseCase(repositoryApi)
    }

    @Provides
    @Singleton
    fun provideGetMediaFileSizeAppUseCase(repositoryApi: RepositoryApi): GetMediaFileSizeAppUseCase {
        return GetMediaFileSizeAppUseCase(repositoryApi)
    }
//GetSavedAppInfoUseCase
@Provides
@Singleton
fun provideGetSavedAppInfoUseCase(repositoryApi: RepositoryApi): GetSavedAppInfoUseCase {
    return GetSavedAppInfoUseCase(repositoryApi)
}
    @Provides
    @Singleton
    fun providePackageResAppUseCase(repositoryApi: RepositoryApi) = PackageResAppUseCase(repositoryApi)

    @Provides
    @Singleton
    fun provideRebootProgressDateBase(repositoryApi: RepositoryApi) = RebootProgressDateBase(repositoryApi)

    @Provides
    fun  provideSaveAppInfoUseCase(repositoryApi: RepositoryApi): SaveAppInfoUseCase {
        return SaveAppInfoUseCase(repositoryApi)
    }
    @Provides
    fun  provideYandexAppMetricaUseCase(repositoryApi: RepositoryApi): YandexAppMetricaUseCase {
        return YandexAppMetricaUseCase(repositoryApi)
    }



}
package module.di

import com.project.datasource.AdMobDataSource
import com.project.datasource.ContactManagerDataSource
import com.project.datasource.FileSystemDataSource
import com.project.datasource.FireBaseRemoteConfigDataSource
import com.project.datasource.PhoneInfoDataSource
import com.project.datasource.SharedPrefsDataSource
import com.project.datasource.YandexAppMetricaDataSource
import com.project.guardapp.data.repository.api.SharedPrefsAPI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import module.domain.repository.RepositoryApi
import module.repository.api.AdMobApi
import module.repository.api.ContactManegerApi
import module.repository.api.FileSystemAPI
import module.repository.api.FireBaseRemoteConfigApi
import module.repository.api.PhoneInfoAPI
import module.repository.api.YandexAppMetricaApi
import module.repository.impl.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMyRypository(
        systemDataImpl: RepositoryImpl
    ): RepositoryApi


    @Binds
    @Singleton
    abstract fun bindPhoneInfo(
        PhoneInfoImpl: PhoneInfoDataSource
    ): PhoneInfoAPI

    @Binds
    @Singleton
    abstract fun bindContactsManeger(
        contacts: ContactManagerDataSource
    ): ContactManegerApi


    @Binds
    @Singleton
    abstract fun bindFileSystem(
        fileSystem: FileSystemDataSource
    ): FileSystemAPI

    @Binds
    @Singleton
    abstract fun bindSharedPrefs(
        sharedPrefs: SharedPrefsDataSource
    ): SharedPrefsAPI


    @Binds
    @Singleton
    abstract fun bindFireBase(
        freBaseRemoteConfig: FireBaseRemoteConfigDataSource
    ): FireBaseRemoteConfigApi

    @Binds
    @Singleton
    abstract fun bindAdMob(
        adMob: AdMobDataSource
    ): AdMobApi

    @Binds
    @Singleton
    abstract fun bindYandexAppMetrica(
        adMob: YandexAppMetricaDataSource
    ): YandexAppMetricaApi


}
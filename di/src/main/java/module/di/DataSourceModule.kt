package module.di

import android.content.Context
import com.project.remoteconfig.FireBaseConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import module.admob.AdMob
import module.contactmaneger.ContactManager
import module.filesystem.FileSystem
import module.phoneinfo.PhoneInfo
import module.sharedprefs.SharedPrefs
import module.yandexappmetrica.YandexAppMetrica
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {


    @Provides
    @Singleton
    fun provideFireBaseConfig(): FireBaseConfig {
        return FireBaseConfig()
    }

    @Provides
    @Singleton
    fun provideSharedPrefs(
        @ApplicationContext context: Context
    ): SharedPrefs {
        return SharedPrefs(context)
    }

    @Provides
    @Singleton
    fun provideFilleSystem(
    ): FileSystem {
        return FileSystem()
    }

    @Provides
    @Singleton
    fun providePhoneInfo(
        @ApplicationContext context: Context
    ): PhoneInfo {
        return PhoneInfo(context)
    }

    @Provides
    @Singleton
    fun provideContactsManeger(
        @ApplicationContext context: Context
    ): ContactManager {
        return ContactManager(context)
    }


    @Provides
    @Singleton
    fun provideAdMob(@ApplicationContext context: Context): AdMob {
        return AdMob(context)
    }

    @Provides
    @Singleton
    fun provideYandexAppMetrica(@ApplicationContext context: Context): YandexAppMetrica {
        return YandexAppMetrica(context)
    }



}

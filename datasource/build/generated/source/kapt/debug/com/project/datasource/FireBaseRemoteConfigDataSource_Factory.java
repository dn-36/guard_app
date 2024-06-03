// Generated by Dagger (https://dagger.dev).
package com.project.datasource;

import com.project.remoteconfig.FireBaseConfig;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class FireBaseRemoteConfigDataSource_Factory implements Factory<FireBaseRemoteConfigDataSource> {
  private final Provider<FireBaseConfig> fireBaseConfigProvider;

  public FireBaseRemoteConfigDataSource_Factory(Provider<FireBaseConfig> fireBaseConfigProvider) {
    this.fireBaseConfigProvider = fireBaseConfigProvider;
  }

  @Override
  public FireBaseRemoteConfigDataSource get() {
    return newInstance(fireBaseConfigProvider.get());
  }

  public static FireBaseRemoteConfigDataSource_Factory create(
      Provider<FireBaseConfig> fireBaseConfigProvider) {
    return new FireBaseRemoteConfigDataSource_Factory(fireBaseConfigProvider);
  }

  public static FireBaseRemoteConfigDataSource newInstance(FireBaseConfig fireBaseConfig) {
    return new FireBaseRemoteConfigDataSource(fireBaseConfig);
  }
}
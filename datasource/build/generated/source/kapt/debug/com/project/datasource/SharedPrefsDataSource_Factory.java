// Generated by Dagger (https://dagger.dev).
package com.project.datasource;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import module.sharedprefs.SharedPrefs;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class SharedPrefsDataSource_Factory implements Factory<SharedPrefsDataSource> {
  private final Provider<SharedPrefs> sharedPrefsProvider;

  public SharedPrefsDataSource_Factory(Provider<SharedPrefs> sharedPrefsProvider) {
    this.sharedPrefsProvider = sharedPrefsProvider;
  }

  @Override
  public SharedPrefsDataSource get() {
    return newInstance(sharedPrefsProvider.get());
  }

  public static SharedPrefsDataSource_Factory create(Provider<SharedPrefs> sharedPrefsProvider) {
    return new SharedPrefsDataSource_Factory(sharedPrefsProvider);
  }

  public static SharedPrefsDataSource newInstance(SharedPrefs sharedPrefs) {
    return new SharedPrefsDataSource(sharedPrefs);
  }
}
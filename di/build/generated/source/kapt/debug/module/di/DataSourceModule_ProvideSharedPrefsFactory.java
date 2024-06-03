// Generated by Dagger (https://dagger.dev).
package module.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import module.sharedprefs.SharedPrefs;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DataSourceModule_ProvideSharedPrefsFactory implements Factory<SharedPrefs> {
  private final Provider<Context> contextProvider;

  public DataSourceModule_ProvideSharedPrefsFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPrefs get() {
    return provideSharedPrefs(contextProvider.get());
  }

  public static DataSourceModule_ProvideSharedPrefsFactory create(
      Provider<Context> contextProvider) {
    return new DataSourceModule_ProvideSharedPrefsFactory(contextProvider);
  }

  public static SharedPrefs provideSharedPrefs(Context context) {
    return Preconditions.checkNotNullFromProvides(DataSourceModule.INSTANCE.provideSharedPrefs(context));
  }
}
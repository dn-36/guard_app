// Generated by Dagger (https://dagger.dev).
package module.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import module.domain.repository.RepositoryApi;
import module.domain.usecases.GetInstalledAppsUseCase;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class UseCaseModule_ProvideGetInstalledAppsUseCaseFactory implements Factory<GetInstalledAppsUseCase> {
  private final Provider<RepositoryApi> repositoryApiProvider;

  public UseCaseModule_ProvideGetInstalledAppsUseCaseFactory(
      Provider<RepositoryApi> repositoryApiProvider) {
    this.repositoryApiProvider = repositoryApiProvider;
  }

  @Override
  public GetInstalledAppsUseCase get() {
    return provideGetInstalledAppsUseCase(repositoryApiProvider.get());
  }

  public static UseCaseModule_ProvideGetInstalledAppsUseCaseFactory create(
      Provider<RepositoryApi> repositoryApiProvider) {
    return new UseCaseModule_ProvideGetInstalledAppsUseCaseFactory(repositoryApiProvider);
  }

  public static GetInstalledAppsUseCase provideGetInstalledAppsUseCase(
      RepositoryApi repositoryApi) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetInstalledAppsUseCase(repositoryApi));
  }
}

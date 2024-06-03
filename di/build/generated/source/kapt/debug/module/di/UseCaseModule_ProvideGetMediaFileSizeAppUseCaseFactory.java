// Generated by Dagger (https://dagger.dev).
package module.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import module.domain.repository.RepositoryApi;
import module.domain.usecases.GetMediaFileSizeAppUseCase;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class UseCaseModule_ProvideGetMediaFileSizeAppUseCaseFactory implements Factory<GetMediaFileSizeAppUseCase> {
  private final Provider<RepositoryApi> repositoryApiProvider;

  public UseCaseModule_ProvideGetMediaFileSizeAppUseCaseFactory(
      Provider<RepositoryApi> repositoryApiProvider) {
    this.repositoryApiProvider = repositoryApiProvider;
  }

  @Override
  public GetMediaFileSizeAppUseCase get() {
    return provideGetMediaFileSizeAppUseCase(repositoryApiProvider.get());
  }

  public static UseCaseModule_ProvideGetMediaFileSizeAppUseCaseFactory create(
      Provider<RepositoryApi> repositoryApiProvider) {
    return new UseCaseModule_ProvideGetMediaFileSizeAppUseCaseFactory(repositoryApiProvider);
  }

  public static GetMediaFileSizeAppUseCase provideGetMediaFileSizeAppUseCase(
      RepositoryApi repositoryApi) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideGetMediaFileSizeAppUseCase(repositoryApi));
  }
}

// Generated by Dagger (https://dagger.dev).
package module.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import module.domain.repository.RepositoryApi;
import module.domain.usecases.AdMobUseCase;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class UseCaseModule_ProvideAdMobUseCaseFactory implements Factory<AdMobUseCase> {
  private final Provider<RepositoryApi> repositoryApiProvider;

  public UseCaseModule_ProvideAdMobUseCaseFactory(Provider<RepositoryApi> repositoryApiProvider) {
    this.repositoryApiProvider = repositoryApiProvider;
  }

  @Override
  public AdMobUseCase get() {
    return provideAdMobUseCase(repositoryApiProvider.get());
  }

  public static UseCaseModule_ProvideAdMobUseCaseFactory create(
      Provider<RepositoryApi> repositoryApiProvider) {
    return new UseCaseModule_ProvideAdMobUseCaseFactory(repositoryApiProvider);
  }

  public static AdMobUseCase provideAdMobUseCase(RepositoryApi repositoryApi) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.provideAdMobUseCase(repositoryApi));
  }
}

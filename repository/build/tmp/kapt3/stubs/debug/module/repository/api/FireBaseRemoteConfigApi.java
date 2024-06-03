package module.repository.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH&\u00a8\u0006\f"}, d2 = {"Lmodule/repository/api/FireBaseRemoteConfigApi;", "", "execute", "", "onSuccessful", "Lkotlin/Function1;", "Lmodule/domain/repository/RemoteConfigDomain;", "Lkotlin/ParameterName;", "name", "remoteConfig", "onError", "Lkotlin/Function0;", "repository_debug"})
public abstract interface FireBaseRemoteConfigApi {
    
    public abstract void execute(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super module.domain.repository.RemoteConfigDomain, kotlin.Unit> onSuccessful, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onError);
}
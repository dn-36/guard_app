package com.project.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J9\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/project/datasource/FireBaseRemoteConfigDataSource;", "Lmodule/repository/api/FireBaseRemoteConfigApi;", "fireBaseConfig", "Lcom/project/remoteconfig/FireBaseConfig;", "(Lcom/project/remoteconfig/FireBaseConfig;)V", "getFireBaseConfig", "()Lcom/project/remoteconfig/FireBaseConfig;", "execute", "", "onSuccessful", "Lkotlin/Function1;", "Lmodule/domain/repository/RemoteConfigDomain;", "Lkotlin/ParameterName;", "name", "remoteConfig", "onError", "Lkotlin/Function0;", "datasource_debug"})
public final class FireBaseRemoteConfigDataSource implements module.repository.api.FireBaseRemoteConfigApi {
    @org.jetbrains.annotations.NotNull
    private final com.project.remoteconfig.FireBaseConfig fireBaseConfig = null;
    
    @javax.inject.Inject
    public FireBaseRemoteConfigDataSource(@org.jetbrains.annotations.NotNull
    com.project.remoteconfig.FireBaseConfig fireBaseConfig) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.project.remoteconfig.FireBaseConfig getFireBaseConfig() {
        return null;
    }
    
    @java.lang.Override
    public void execute(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super module.domain.repository.RemoteConfigDomain, kotlin.Unit> onSuccessful, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onError) {
    }
}
package module.repository.impl;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lmodule/repository/impl/RemoteConfigImpl;", "Lmodule/domain/repository/RemoteConfigDomain;", "data", "(Lmodule/domain/repository/RemoteConfigDomain;)V", "getData", "()Lmodule/domain/repository/RemoteConfigDomain;", "getBooleanValue", "", "key", "", "getLongValue", "", "getStringValue", "repository_debug"})
public final class RemoteConfigImpl implements module.domain.repository.RemoteConfigDomain {
    @org.jetbrains.annotations.NotNull
    private final module.domain.repository.RemoteConfigDomain data = null;
    
    @javax.inject.Inject
    public RemoteConfigImpl(@org.jetbrains.annotations.NotNull
    module.domain.repository.RemoteConfigDomain data) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.domain.repository.RemoteConfigDomain getData() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getStringValue(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
        return null;
    }
    
    @java.lang.Override
    public long getLongValue(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
        return 0L;
    }
    
    @java.lang.Override
    public boolean getBooleanValue(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
        return false;
    }
}
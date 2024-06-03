package module.repository.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lmodule/repository/api/PhoneInfoAPI;", "", "deleteAppByAppName", "", "appName", "", "getInfoPermission", "", "Lmodule/domain/repository/AppPermissionDomain;", "getInstalledApps", "Lmodule/domain/model/InstalledAppsDomain;", "getModelPhone", "Lmodule/domain/model/PhoneModelDomain;", "repository_debug"})
public abstract interface PhoneInfoAPI {
    
    @org.jetbrains.annotations.NotNull
    public abstract module.domain.model.PhoneModelDomain getModelPhone();
    
    @org.jetbrains.annotations.NotNull
    public abstract module.domain.model.InstalledAppsDomain getInstalledApps();
    
    public abstract void deleteAppByAppName(@org.jetbrains.annotations.NotNull
    java.lang.String appName);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<module.domain.repository.AppPermissionDomain> getInfoPermission();
}
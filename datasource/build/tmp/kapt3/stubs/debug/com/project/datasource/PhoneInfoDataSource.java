package com.project.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/project/datasource/PhoneInfoDataSource;", "Lmodule/repository/api/PhoneInfoAPI;", "phoneInfo", "Lmodule/phoneinfo/PhoneInfo;", "(Lmodule/phoneinfo/PhoneInfo;)V", "getPhoneInfo", "()Lmodule/phoneinfo/PhoneInfo;", "deleteAppByAppName", "", "appName", "", "getInfoPermission", "", "Lmodule/domain/repository/AppPermissionDomain;", "getInstalledApps", "Lmodule/domain/model/InstalledAppsDomain;", "getModelPhone", "Lmodule/domain/model/PhoneModelDomain;", "datasource_debug"})
public final class PhoneInfoDataSource implements module.repository.api.PhoneInfoAPI {
    @org.jetbrains.annotations.NotNull
    private final module.phoneinfo.PhoneInfo phoneInfo = null;
    
    @javax.inject.Inject
    public PhoneInfoDataSource(@org.jetbrains.annotations.NotNull
    module.phoneinfo.PhoneInfo phoneInfo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.phoneinfo.PhoneInfo getPhoneInfo() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public module.domain.model.PhoneModelDomain getModelPhone() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public module.domain.model.InstalledAppsDomain getInstalledApps() {
        return null;
    }
    
    @java.lang.Override
    public void deleteAppByAppName(@org.jetbrains.annotations.NotNull
    java.lang.String appName) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<module.domain.repository.AppPermissionDomain> getInfoPermission() {
        return null;
    }
}
package com.project.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/project/datasource/AdMobDataSource;", "Lmodule/repository/api/AdMobApi;", "adMob", "Lmodule/admob/AdMob;", "(Lmodule/admob/AdMob;)V", "getAdMob", "()Lmodule/admob/AdMob;", "loadAds", "", "onAdLoaded", "Lkotlin/Function0;", "appId", "", "showAds", "actionOnAdClicked", "actionOnAdShow", "datasource_debug"})
public final class AdMobDataSource implements module.repository.api.AdMobApi {
    @org.jetbrains.annotations.NotNull
    private final module.admob.AdMob adMob = null;
    
    @javax.inject.Inject
    public AdMobDataSource(@org.jetbrains.annotations.NotNull
    module.admob.AdMob adMob) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.admob.AdMob getAdMob() {
        return null;
    }
    
    @java.lang.Override
    public void showAds(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> actionOnAdClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> actionOnAdShow) {
    }
    
    @java.lang.Override
    public void loadAds(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAdLoaded, @org.jetbrains.annotations.NotNull
    java.lang.String appId) {
    }
}
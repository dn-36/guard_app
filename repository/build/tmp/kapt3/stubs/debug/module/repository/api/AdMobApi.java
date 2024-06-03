package module.repository.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lmodule/repository/api/AdMobApi;", "", "loadAds", "", "onAdLoaded", "Lkotlin/Function0;", "appId", "", "showAds", "actionOnAdClicked", "actionOnAdShow", "repository_debug"})
public abstract interface AdMobApi {
    
    public abstract void showAds(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> actionOnAdClicked, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> actionOnAdShow);
    
    public abstract void loadAds(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAdLoaded, @org.jetbrains.annotations.NotNull
    java.lang.String appId);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}
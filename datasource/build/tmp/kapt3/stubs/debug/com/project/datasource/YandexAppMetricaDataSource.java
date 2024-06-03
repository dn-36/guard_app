package com.project.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/project/datasource/YandexAppMetricaDataSource;", "Lmodule/repository/api/YandexAppMetricaApi;", "yandexAppMetrica", "Lmodule/yandexappmetrica/YandexAppMetrica;", "(Lmodule/yandexappmetrica/YandexAppMetrica;)V", "init", "", "key", "", "sendEventYandexAppMetrica", "titleEvent", "datasource_debug"})
public final class YandexAppMetricaDataSource implements module.repository.api.YandexAppMetricaApi {
    @org.jetbrains.annotations.NotNull
    private final module.yandexappmetrica.YandexAppMetrica yandexAppMetrica = null;
    
    @javax.inject.Inject
    public YandexAppMetricaDataSource(@org.jetbrains.annotations.NotNull
    module.yandexappmetrica.YandexAppMetrica yandexAppMetrica) {
        super();
    }
    
    @java.lang.Override
    public void init(@org.jetbrains.annotations.NotNull
    java.lang.String key) {
    }
    
    @java.lang.Override
    public void sendEventYandexAppMetrica(@org.jetbrains.annotations.NotNull
    java.lang.String titleEvent) {
    }
}
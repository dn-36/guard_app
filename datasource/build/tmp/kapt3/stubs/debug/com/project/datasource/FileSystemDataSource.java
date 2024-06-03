package com.project.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001c"}, d2 = {"Lcom/project/datasource/FileSystemDataSource;", "Lmodule/repository/api/FileSystemAPI;", "fileSystem", "Lmodule/filesystem/FileSystem;", "(Lmodule/filesystem/FileSystem;)V", "getFileSystem", "()Lmodule/filesystem/FileSystem;", "deleteResPackageMassenger", "", "titleRes", "", "onComplete", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resString", "getTelegramAllMediaSizeMB", "", "getTelegramAudioSizeMB", "getTelegramDocumentsSizeMB", "getTelegramImagesSizeMB", "getTelegramVideoSizeMB", "getWhatsAppAllMediaSizeMB", "getWhatsAppAudioSizeMB", "getWhatsAppDocumentsSizeMB", "getWhatsAppImagesSizeMB", "getWhatsAppVideoSizeMB", "getWhatsAppVoiceSizeMB", "datasource_debug"})
public final class FileSystemDataSource implements module.repository.api.FileSystemAPI {
    @org.jetbrains.annotations.NotNull
    private final module.filesystem.FileSystem fileSystem = null;
    
    @javax.inject.Inject
    public FileSystemDataSource(@org.jetbrains.annotations.NotNull
    module.filesystem.FileSystem fileSystem) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.filesystem.FileSystem getFileSystem() {
        return null;
    }
    
    @java.lang.Override
    public float getTelegramAllMediaSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getTelegramAudioSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getTelegramDocumentsSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getTelegramImagesSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getTelegramVideoSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppAllMediaSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppAudioSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppDocumentsSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppImagesSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppVideoSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public float getWhatsAppVoiceSizeMB() {
        return 0.0F;
    }
    
    @java.lang.Override
    public void deleteResPackageMassenger(@org.jetbrains.annotations.NotNull
    java.lang.String titleRes, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onComplete) {
    }
}
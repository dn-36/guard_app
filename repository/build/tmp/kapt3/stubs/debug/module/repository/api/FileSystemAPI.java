package module.repository.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\fH&J\b\u0010\u0012\u001a\u00020\fH&J\b\u0010\u0013\u001a\u00020\fH&J\b\u0010\u0014\u001a\u00020\fH&J\b\u0010\u0015\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\fH&\u00a8\u0006\u0017"}, d2 = {"Lmodule/repository/api/FileSystemAPI;", "", "deleteResPackageMassenger", "", "titleRes", "", "onComplete", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "resString", "getTelegramAllMediaSizeMB", "", "getTelegramAudioSizeMB", "getTelegramDocumentsSizeMB", "getTelegramImagesSizeMB", "getTelegramVideoSizeMB", "getWhatsAppAllMediaSizeMB", "getWhatsAppAudioSizeMB", "getWhatsAppDocumentsSizeMB", "getWhatsAppImagesSizeMB", "getWhatsAppVideoSizeMB", "getWhatsAppVoiceSizeMB", "repository_debug"})
public abstract interface FileSystemAPI {
    
    public abstract float getTelegramAllMediaSizeMB();
    
    public abstract float getTelegramAudioSizeMB();
    
    public abstract float getTelegramDocumentsSizeMB();
    
    public abstract float getTelegramImagesSizeMB();
    
    public abstract float getTelegramVideoSizeMB();
    
    public abstract float getWhatsAppAllMediaSizeMB();
    
    public abstract float getWhatsAppAudioSizeMB();
    
    public abstract float getWhatsAppDocumentsSizeMB();
    
    public abstract float getWhatsAppImagesSizeMB();
    
    public abstract float getWhatsAppVideoSizeMB();
    
    public abstract float getWhatsAppVoiceSizeMB();
    
    public abstract void deleteResPackageMassenger(@org.jetbrains.annotations.NotNull
    java.lang.String titleRes, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onComplete);
}
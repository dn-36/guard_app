package com.project.guardapp.data.repository.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0005H&J\b\u0010\u0012\u001a\u00020\u0003H&J\b\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0003H&J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000bH&J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0010H&J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005H&J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010\'\u001a\u00020\u0003H&\u00a8\u0006("}, d2 = {"Lcom/project/guardapp/data/repository/api/SharedPrefsAPI;", "", "getAftrherTitleNotification", "", "getApplicationDone", "", "getBeginTitleNotification", "getContactsDone", "getDescreptionNotification", "getFormatNotifivation", "getFreeMegabytes", "", "getHaccersDone", "getMessengersDone", "getOptimizationRememberDone", "getSavedLastDay", "", "getTakeCareDeviceDone", "getTime", "rebootProgressClearDateBase", "", "setAftherTitleNotification", "title", "setApplicationDone", "isDone", "setBeginTitleNotification", "setContactsDone", "setDescreptionNotification", "setFormatNotifivation", "format", "setFreeMegabytes", "megabyte", "setHaccersDone", "setMessengersDone", "setOptimizationRememberDone", "setSavedLastDay", "data", "setTakeCareDeviceDone", "setTime", "string", "repository_debug"})
public abstract interface SharedPrefsAPI {
    
    public abstract int getSavedLastDay();
    
    public abstract void setSavedLastDay(int data);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getTime();
    
    public abstract void setTime(@org.jetbrains.annotations.NotNull
    java.lang.String string);
    
    public abstract float getFreeMegabytes();
    
    public abstract void setFreeMegabytes(float megabyte);
    
    public abstract void setTakeCareDeviceDone(boolean isDone);
    
    public abstract boolean getTakeCareDeviceDone();
    
    public abstract void setOptimizationRememberDone(boolean isDone);
    
    public abstract boolean getOptimizationRememberDone();
    
    public abstract void setHaccersDone(boolean isDone);
    
    public abstract boolean getHaccersDone();
    
    public abstract void setContactsDone(boolean isDone);
    
    public abstract boolean getContactsDone();
    
    public abstract void setMessengersDone(boolean isDone);
    
    public abstract boolean getMessengersDone();
    
    public abstract void setApplicationDone(boolean isDone);
    
    public abstract boolean getApplicationDone();
    
    public abstract void setBeginTitleNotification(@org.jetbrains.annotations.NotNull
    java.lang.String title);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getBeginTitleNotification();
    
    public abstract void setFormatNotifivation(@org.jetbrains.annotations.NotNull
    java.lang.String format);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getFormatNotifivation();
    
    public abstract void setAftherTitleNotification(@org.jetbrains.annotations.NotNull
    java.lang.String title);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getAftrherTitleNotification();
    
    public abstract void setDescreptionNotification(@org.jetbrains.annotations.NotNull
    java.lang.String title);
    
    @org.jetbrains.annotations.NotNull
    public abstract java.lang.String getDescreptionNotification();
    
    public abstract void rebootProgressClearDateBase();
}
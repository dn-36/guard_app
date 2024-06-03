package com.project.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010\'\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0015H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006-"}, d2 = {"Lcom/project/datasource/SharedPrefsDataSource;", "Lcom/project/guardapp/data/repository/api/SharedPrefsAPI;", "sharedPrefs", "Lmodule/sharedprefs/SharedPrefs;", "(Lmodule/sharedprefs/SharedPrefs;)V", "getSharedPrefs", "()Lmodule/sharedprefs/SharedPrefs;", "getAftrherTitleNotification", "", "getApplicationDone", "", "getBeginTitleNotification", "getContactsDone", "getDescreptionNotification", "getFormatNotifivation", "getFreeMegabytes", "", "getHaccersDone", "getMessengersDone", "getOptimizationRememberDone", "getSavedLastDay", "", "getTakeCareDeviceDone", "getTime", "rebootProgressClearDateBase", "", "setAftherTitleNotification", "title", "setApplicationDone", "isDone", "setBeginTitleNotification", "setContactsDone", "setDescreptionNotification", "setFormatNotifivation", "format", "setFreeMegabytes", "megabyte", "setHaccersDone", "setMessengersDone", "setOptimizationRememberDone", "setSavedLastDay", "data", "setTakeCareDeviceDone", "setTime", "string", "datasource_debug"})
public final class SharedPrefsDataSource implements com.project.guardapp.data.repository.api.SharedPrefsAPI {
    @org.jetbrains.annotations.NotNull
    private final module.sharedprefs.SharedPrefs sharedPrefs = null;
    
    @javax.inject.Inject
    public SharedPrefsDataSource(@org.jetbrains.annotations.NotNull
    module.sharedprefs.SharedPrefs sharedPrefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.sharedprefs.SharedPrefs getSharedPrefs() {
        return null;
    }
    
    @java.lang.Override
    public int getSavedLastDay() {
        return 0;
    }
    
    @java.lang.Override
    public void setSavedLastDay(int data) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getTime() {
        return null;
    }
    
    @java.lang.Override
    public void setTime(@org.jetbrains.annotations.NotNull
    java.lang.String string) {
    }
    
    @java.lang.Override
    public float getFreeMegabytes() {
        return 0.0F;
    }
    
    @java.lang.Override
    public void setFreeMegabytes(float megabyte) {
    }
    
    @java.lang.Override
    public void setTakeCareDeviceDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getTakeCareDeviceDone() {
        return false;
    }
    
    @java.lang.Override
    public void setOptimizationRememberDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getOptimizationRememberDone() {
        return false;
    }
    
    @java.lang.Override
    public void setHaccersDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getHaccersDone() {
        return false;
    }
    
    @java.lang.Override
    public void setContactsDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getContactsDone() {
        return false;
    }
    
    @java.lang.Override
    public void setMessengersDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getMessengersDone() {
        return false;
    }
    
    @java.lang.Override
    public void setApplicationDone(boolean isDone) {
    }
    
    @java.lang.Override
    public boolean getApplicationDone() {
        return false;
    }
    
    @java.lang.Override
    public void setBeginTitleNotification(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getBeginTitleNotification() {
        return null;
    }
    
    @java.lang.Override
    public void setFormatNotifivation(@org.jetbrains.annotations.NotNull
    java.lang.String format) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getFormatNotifivation() {
        return null;
    }
    
    @java.lang.Override
    public void setAftherTitleNotification(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getAftrherTitleNotification() {
        return null;
    }
    
    @java.lang.Override
    public void setDescreptionNotification(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getDescreptionNotification() {
        return null;
    }
    
    @java.lang.Override
    public void rebootProgressClearDateBase() {
    }
}
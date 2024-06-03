package com.project.datasource;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/project/datasource/ContactManagerDataSource;", "Lmodule/repository/api/ContactManegerApi;", "contactManager", "Lmodule/contactmaneger/ContactManager;", "(Lmodule/contactmaneger/ContactManager;)V", "getContactManager", "()Lmodule/contactmaneger/ContactManager;", "deleteContact", "", "name", "", "getAllContacts", "", "Lmodule/domain/model/ContactDomain;", "datasource_debug"})
public final class ContactManagerDataSource implements module.repository.api.ContactManegerApi {
    @org.jetbrains.annotations.NotNull
    private final module.contactmaneger.ContactManager contactManager = null;
    
    @javax.inject.Inject
    public ContactManagerDataSource(@org.jetbrains.annotations.NotNull
    module.contactmaneger.ContactManager contactManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final module.contactmaneger.ContactManager getContactManager() {
        return null;
    }
    
    @java.lang.Override
    public void deleteContact(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.util.List<module.domain.model.ContactDomain> getAllContacts() {
        return null;
    }
}
package com.yl.webapp.client.proxies;

import com.yl.model.Role;
import com.yl.webapp.server.locators.RoleLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = Role.class, locator = RoleLocator.class)
public interface RoleProxy extends EntityProxy {

    public static final String ANONYMOUS = "ANONYMOUS";
    public static final String AUTHENTICATED = "AUTHENTICATED";
    public static final String FULLY_AUTHENTICATED = "FULLY_AUTHENTICATED";
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    Long getId();

    String getName();

    String getDescription();

    void setId(Long id);

    void setName(String name);

    void setDescription(String description);

}

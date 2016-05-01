/**
 * 
 */
package com.yl.webapp.client.application;

import java.util.ArrayList;
import java.util.List;

import com.yl.webapp.client.application.base.place.EntitySearchPlace;
import com.yl.webapp.client.application.utils.menu.MenuItem;
import com.yl.webapp.client.proxies.RoleProxy;
import com.yl.webapp.client.proxies.UserProxy;
import com.yl.webapp.client.ui.home.HomePlace;
import com.yl.webapp.client.ui.login.LoginPlace;
import com.yl.webapp.client.ui.logout.LogoutPlace;
import com.yl.webapp.client.ui.reloadOptions.ReloadOptionsPlace;
import com.yl.webapp.client.ui.upload.FileUploadPlace;
import com.yl.webapp.client.ui.users.active.ActiveUsersPlace;
import com.yl.webapp.client.ui.users.editProfile.EditProfilePlace;

import com.google.gwt.core.client.GWT;

/**
 * @author ivangsa
 *
 */
public class ApplicationMenu {

    private static final ApplicationResources i18n = GWT.create(ApplicationResources.class);

    private final MenuItem rootMenu = new MenuItem(null);
    private final MenuItem adminMenu = new MenuItem(i18n.menu_admin(), RoleProxy.ROLE_ADMIN);

    private List<MenuItem> allMenuItems;

    {
        rootMenu.add(new MenuItem(i18n.home_title(), new HomePlace(), RoleProxy.ROLE_USER, RoleProxy.ROLE_ADMIN));
        rootMenu.add(new MenuItem(i18n.menu_user(), new EditProfilePlace(), RoleProxy.ROLE_USER, RoleProxy.ROLE_ADMIN));

        rootMenu.add(adminMenu);
        adminMenu.add(new MenuItem(i18n.menu_admin_users(), new EntitySearchPlace(UserProxy.class), RoleProxy.ROLE_ADMIN));
        adminMenu.add(new MenuItem(i18n.home_activeUsers(), new ActiveUsersPlace(), RoleProxy.ROLE_ADMIN));
        adminMenu.add(new MenuItem(i18n.menu_admin_reload(), new ReloadOptionsPlace(), RoleProxy.ROLE_ADMIN));
        adminMenu.add(new MenuItem(i18n.menu_selectFile(), new FileUploadPlace(), RoleProxy.ROLE_ADMIN));

        rootMenu.add(new MenuItem(i18n.login_title(), new LoginPlace(), RoleProxy.ANONYMOUS));
        rootMenu.add(new MenuItem(i18n.user_logout(), new LogoutPlace(), RoleProxy.AUTHENTICATED));
    }

    public MenuItem getRootMenu() {
        return rootMenu;
    }

    public List<MenuItem> asList() {
        if (allMenuItems == null) {
            allMenuItems = new ArrayList<MenuItem>();
            appendChildrenToList(allMenuItems, rootMenu);
        }
        return allMenuItems;
    }

    protected void appendChildrenToList(final List<MenuItem> menuItems, final MenuItem menuItem) {
        for (final MenuItem childItem : menuItem) {
            menuItems.add(childItem);
            appendChildrenToList(menuItems, childItem);
        }
    }
}

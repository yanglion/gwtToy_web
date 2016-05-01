package com.yl.webapp.client.ui;

import com.yl.webapp.client.application.base.security.LoginEvent;
import com.yl.webapp.client.application.base.security.LogoutEvent;

import org.gwtbootstrap3.client.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;

/**
 * Top level UI for the mobile version of the application.
 */
public class MobileShell extends Shell {

    interface Binder extends UiBinder<Widget, MobileShell> {
    }

    private static final Binder uiBinder = GWT.create(Binder.class);

    // @UiField
    Element title;
    // @UiField
    Button backButton;
    // @UiField
    Element backButtonWrapper;
    // @UiField
    Button editButton;

    public MobileShell() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    /**
     * @return the back button
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     * @return the edit button
     */
    public Button getEditButton() {
        return editButton;
    }

    /**
     * Show or hide the back button.
     *
     * @param visible
     *            true to show the button, false to hide
     */
    public void setBackButtonVisible(final boolean visible) {
        setVisible(backButtonWrapper, visible);
    }

    /**
     * Show or hide the edit button.
     *
     * @param visible
     *            true to show the button, false to hide
     */
    public void setEditButtonVisible(final boolean visible) {
        editButton.setVisible(visible);
    }

    /**
     * Set the title of the app.
     *
     * @param text
     *            the title to display at the top of the app
     */
    public void setTitleText(final String text) {
        title.setInnerText(text);
    }

    @Override
    public void addMessage(final AlertBase alert) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onLoginEvent(final LoginEvent loginEvent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onLogoutEvent(final LogoutEvent logoutEvent) {
        // TODO Auto-generated method stub

    }
}

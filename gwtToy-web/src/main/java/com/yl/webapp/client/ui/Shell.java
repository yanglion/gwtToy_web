/**
 * 
 */
package com.yl.webapp.client.ui;

import com.yl.webapp.client.application.Application;
import com.yl.webapp.client.application.base.security.LoginEvent;
import com.yl.webapp.client.application.base.security.LogoutEvent;

import org.gwtbootstrap3.client.ui.Alert;
import org.gwtbootstrap3.client.ui.constants.AlertType;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.NotificationMole;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author ivangsa
 *
 */
public abstract class Shell extends Composite implements LoginEvent.Handler, LogoutEvent.Handler {

    protected Application application;

    @UiField
    SimplePanel contentsPanel;

    /**
     * Contents Panel
     * 
     * @return
     */
    public SimplePanel getContentsPanel() {
        return contentsPanel;
    }

    public void clearMessages() {
        // TODO Auto-generated method stub
    }

    public void addMessage(AlertType alert) {
        // TODO
    }

    public void addMessage(String html, AlertType alertType) {
        // TODO
    }

    public NotificationMole getMole() {
        return null;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

}

/**
 *
 */
package com.yl.webapp.client.ui.users.updatePassword;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.gwtbootstrap3.client.ui.constants.AlertType;

import com.yl.webapp.client.application.Application;
import com.yl.webapp.client.application.base.activity.AbstractBaseActivity;
import com.yl.webapp.client.proxies.UserProxy;
import com.yl.webapp.client.ui.home.HomePlace;
import com.yl.webapp.client.ui.login.LoginPlace;
import com.yl.webapp.client.ui.users.updatePassword.UpdatePasswordView.UserCredentials;


import com.google.gwt.editor.client.EditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.web.bindery.requestfactory.shared.Receiver;

/**
 * @author ivangsa
 *
 */
public class UpdatePasswordActivity extends AbstractBaseActivity implements UpdatePasswordView.Delegate {

    private final UpdatePasswordView view;

    @Inject
    public UpdatePasswordActivity(final Application application, final UpdatePasswordView view) {
        super(application);
        this.view = view;
        setTitle(i18n.updatePassword_title());
    }

    /**
     * @see com.google.gwt.activity.shared.Activity#start(com.google.gwt.user.client.ui.AcceptsOneWidget,
     *      com.google.gwt.event.shared.EventBus)
     */
    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view.setDelegate(this);
        view.setWaiting(false);
        view.setUserCredentials(((UpdatePasswordPlace) currentPlace).getUserCredentials());
        panel.setWidget(view);
        setDocumentTitleAndBodyAttributtes();
    }

    @Override
    public void onUpdatePasswordClick() {
        final EditorDriver<UserCredentials> editorDriver = view.getEditorDriver();
        final UserCredentials userCredentials = editorDriver.flush();
        final Set<ConstraintViolation<UserCredentials>> violations = getValidator().validate(userCredentials);
        if (!violations.isEmpty()) {
            editorDriver.setConstraintViolations((Set) violations);
            return;
        }

        final boolean isUsingToken = userCredentials.getToken() != null && !"".equals(userCredentials.getToken().trim());

        requests.userRequest().updatePassword(
                userCredentials.getUsername(),
                userCredentials.getToken(),
                userCredentials.getCurrentPassword(),
                userCredentials.getPassword())
                .fire(new Receiver<UserProxy>() {

                    @Override
                    public void onSuccess(final UserProxy response) {
                        if (response == null) {
                            if (isUsingToken) {
                                placeController.goTo(new LoginPlace());
                                shell.addMessage(i18n.updatePassword_invalidToken(), AlertType.DANGER);
                            } else {
                                shell.addMessage(i18n.updatePassword_invalidPassword(), AlertType.DANGER);
                            }
                        } else {
                            placeController.goTo(new HomePlace());
                            shell.addMessage(i18n.updatePassword_success(), AlertType.SUCCESS);
                        }
                    }
                });
    }

    @Override
    public void onCancelClick() {
        placeController.goTo(getBackButtonPlace());
    }
}

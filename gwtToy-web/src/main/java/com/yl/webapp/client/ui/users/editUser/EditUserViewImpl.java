/**
 *
 */
package com.yl.webapp.client.ui.users.editUser;

import java.util.List;

import com.yl.webapp.client.application.ApplicationResources;
import com.yl.webapp.client.application.base.view.ProxyEditView;
import com.yl.webapp.client.proxies.LabelValueProxy;
import com.yl.webapp.client.proxies.RoleProxy;
import com.yl.webapp.client.proxies.UserProxy;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.IntegerBox;
import org.gwtbootstrap3.client.ui.ListBox;
import org.gwtbootstrap3.client.ui.LongBox;
//import org.gwtbootstrap3.client.ui.PasswordTextBox;
import org.gwtbootstrap3.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

/**
 * @author ivangsa
 *
 */
public class EditUserViewImpl extends Composite implements EditUserView {

    interface Binder extends UiBinder<Widget, EditUserViewImpl> {
    }

    private static final Binder BINDER = GWT.create(Binder.class);

    interface Driver extends RequestFactoryEditorDriver<UserProxy, EditUserViewImpl> {
    }

    @UiField(provided = true)
    protected ApplicationResources i18n = GWT.create(ApplicationResources.class);

    private EditUserView.Delegate delegate;

    @UiField
    protected Element subheading;

    @UiField
    LongBox id;
    @UiField
    IntegerBox version;
    @UiField
    TextBox username;
    @UiField
    TextBox password;
    @UiField
    Anchor updatePasswordButton;
    @UiField
    TextBox passwordHint;
    @UiField
    TextBox firstName;
    @UiField
    TextBox lastName;
    @UiField
    TextBox email;
    @UiField
    TextBox phoneNumber;
    @UiField
    TextBox website;

    @UiField
    UIObject addressFieldset;
    @UiField
    @Path("address.address")
    TextBox address;
    @UiField
    @Path("address.city")
    TextBox city;
    @UiField
    @Path("address.province")
    TextBox province;
    @UiField
    @Path("address.country")
    ListBox country;
    @UiField
    @Path("address.postalCode")
    TextBox postalCode;

    @UiField(provided = true)
    protected RolesListBox roles = new RolesListBox();

    @UiField
    protected Widget passwordControlGroup;
    @UiField
    protected Widget updatePasswordControl;
    @UiField
    protected Widget userRoles;// control group for
    @UiField
    protected Widget accountSettings;// control group for

    @UiField
    CheckBox enabled;
    @UiField
    CheckBox accountExpired;
    @UiField
    CheckBox accountLocked;
    @UiField
    CheckBox credentialsExpired;

    @UiField
    Button saveButton;
    @UiField
    protected Button deleteButton;
    @UiField
    Button cancelButton;

    /**
     *
     */
    public EditUserViewImpl() {
        super();
        initWidget(BINDER.createAndBindUi(this));
        passwordControlGroup.setVisible(false);
        updatePasswordControl.setVisible(false);
    }

    @Override
    public <D extends ProxyEditView.Delegate> void setDelegate(D delegate) {
        this.delegate = (Delegate) delegate;
    }

    @Override
    public RequestFactoryEditorDriver<UserProxy, ? extends EditUserView> createEditorDriver() {
        final RequestFactoryEditorDriver<UserProxy, EditUserViewImpl> editorDriver = GWT.create(Driver.class);
        editorDriver.initialize(this);
        return editorDriver;
    }

    @Override
    public void setCountries(final List<LabelValueProxy> countries) {
        for (final LabelValueProxy labelValue : countries) {
            country.addItem(labelValue.getLabel(), labelValue.getValue());
        }
    }

    @Override
    public void setAvailableRoles(final List<RoleProxy> roles) {
        this.roles.setRowData(roles);
    }

    @Override
    public void showErrors(final List<EditorError> errors) {
        if (errors != null && !errors.isEmpty()) {
            final SafeHtmlBuilder b = new SafeHtmlBuilder();
            for (final EditorError error : errors) {
                if (error.getPath() != null && !"".equals(error.getPath())) {
                    final Object userData = error.getUserData();
                    b.appendEscaped(error.getPath()).appendEscaped(": ");
                }
                b.appendEscaped(error.getMessage()).appendEscaped("\n");
            }
            Window.alert(b.toSafeHtml().asString());
        }
    }

    @UiHandler("saveButton")
    public void onSaveButtonClick(final ClickEvent event) {
        delegate.saveClicked();
    }

    @UiHandler("deleteButton")
    public void onDeleteButtonClick(final ClickEvent event) {
        delegate.deleteClicked();
    }

    @UiHandler("cancelButton")
    public void onCancelButtonClick(final ClickEvent event) {
        delegate.cancelClicked();
    }

    @UiHandler("updatePasswordButton")
    public void onUpdatePasswordClick(final ClickEvent event) {
        delegate.updatePasswordClicked();
    }

    @Override
    public void setEnabled(final boolean b) {
        // TODO
    }

}

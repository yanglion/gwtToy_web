package com.yl.webapp.client.ui;

import org.gwtbootstrap3.client.ui.base.HasType;
import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;
import org.gwtbootstrap3.client.ui.constants.AlertType;
import org.gwtbootstrap3.client.ui.gwt.HTMLPanel;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.HasWidgets;
import com.yl.webapp.client.ui.event.CloseEvent;
import com.yl.webapp.client.ui.event.CloseHandler;
import com.yl.webapp.client.ui.event.ClosedEvent;
import com.yl.webapp.client.ui.event.ClosedHandler;
import com.yl.webapp.client.ui.event.HasCloseHandlers;

public abstract class AlertBase extends HtmlWidget implements IsAnimated,
HasCloseHandlers, HasType<AlertType> {

private Close close;

private HTMLPanel closeReplacement = new HTMLPanel("span", "");

private HTMLPanel headingContainer = new HTMLPanel("span", "");

private HTMLPanel container;

private boolean fade;

private boolean hasClose;

/**
* Initializes an Alert with a close icon.
*/
public AlertBase() {
this("", true);
}

/**
* Initializes an Alert with a inner HTML.
* @param html inner HTML
*/
public AlertBase(String html) {
this(html, true);
}

/**
* Initializes an Alert with an optional close icon.
* 
* @param html inner HTML
* @param hasClose
*            whether the Alert should have a close icon.
*/
public AlertBase(String html, boolean hasClose) {
super("div", "");

super.add(closeReplacement);
super.add(headingContainer);
container = new HTMLPanel("span",html);
super.add(container);
super.setStyleName("alert");
setClose(hasClose);
}

/**
* Initializes an Alert of given Type with a close icon.
* 
* @param type
*            of the Alert
*/
public AlertBase(AlertType type) {
this();
setType(type);
}

/**
* Sets whether the Alert has a close icon or not.
* 
* @param hasClose
*            <code>false</code> if you don't want to have a close icon.
*            Default: <code>true</code>
*/
public void setClose(boolean hasClose) {

this.hasClose = hasClose;

if(!isAttached()) {
    return;
}

if (hasClose) {
    if(close == null) {
        close = new Close(DismissType.ALERT);
        getElement().replaceChild(close.getElement(), closeReplacement.getElement());
    }
} else {
    if (close != null) {
        getElement().replaceChild(closeReplacement.getElement(), close.getElement());
        close = null;
    }
}
}

/**
* {@inheritDoc}
*/
@Override
protected void onAttach() {
super.onAttach();
setClose(hasClose);
configure(getElement());
setHandlerFunctions(getElement());
}

/**
* has Close
* @return true:has close false:does not has close
*/
public boolean hasClose() {
return hasClose;
}


/**
* Gets heading's container widget
* @return heading's container
*/
protected HasWidgets getHeadingContainer() {
return headingContainer;
}

/**
* This method is called immediately when the widget's close method is
* executed.
*/
protected void onClose() {
fireEvent(new CloseEvent());
}

/**
* This method is called once the widget is completely closed.
*/
protected void onClosed() {
fireEvent(new ClosedEvent());
}

/**
* Sets the type of the Alert.
* 
* @param type
*/
public void setType(AlertType type) {
formerStyleHelper.changeStyle(this, type, AlertType.class);
}

/**
* Sets the text of an optional heading. The implementation depends on the
* subclass.
* 
* @param text
*            the new heading
*/
public void setHeading(String text) {
headingContainer.clear();
headingContainer.add(new HTMLPanel("span", text));
}

/**
* Sets whether the Alert should be animated.
* 
* @param animated
*            <code>true</code> if the Alert should fade out. Default:
*            <code>false</code>
*/
public void setAnimation(boolean animated) {
this.fade = animated;
setFade();
}

/**
* {@inheritDoc}
*/
public boolean getAnimation() {
return fade;
}

/**
* Delete the whole content of the Alert. This includes text, heading and
* close icon.
*/
@Override
public void clear() {
container.clear();
}

/**
* Sets the classes that define whether the Alert fades or not.
*/
private void setFade() {
if (fade) {
    addStyleName("fade");
    addStyleName("in");
} else {
    removeStyleName("fade");
    removeStyleName("in");
}
}

/**
* {@inheritDoc}
*/
public String getText() {
return container.getElement().getInnerText();
}

/**
* {@inheritDoc}
*/
public void setText(String text) {
setHTML(SafeHtmlUtils.htmlEscape(text));
}

/**
* {@inheritDoc}
*/
public String getHTML() {
return container.getElement().getInnerHTML();
}

public void setHTML(String html) {
container.clear();
container.add(new HTMLPanel("span" , html));
}

/**
* Close this alert.
*/
public void close() {
close(getElement());
}

/**
* {@inheritDoc}
*/
public HandlerRegistration addCloseHandler(CloseHandler handler) {

return addHandler(handler, CloseEvent.getType());
}

/**
* {@inheritDoc}
*/
public HandlerRegistration addClosedHandler(ClosedHandler handler) {
return addHandler(handler, ClosedEvent.getType());
}

//@formatter:off
/**
* Adds the Java functions that fire the Events to document. It is a
* convenience method to have a cleaner code later on.
*/
private native void setHandlerFunctions(Element e) /*-{
var that = this;
$wnd
        .jQuery(e)
        .bind(
                'close',
                function() {
                    that.@com.github.gwtbootstrap.client.ui.base.AlertBase::onClose()();
                });
$wnd
        .jQuery(e)
        .bind(
                'closed',
                function() {
                    that.@com.github.gwtbootstrap.client.ui.base.AlertBase::onClosed()();
                });
}-*/;

private native void configure(Element e) /*-{
$wnd.jQuery(e).alert(e);
}-*/;

private native void close(Element e)/*-{
$wnd.jQuery(e).alert('close');
}-*/;
//@formatter:on

}

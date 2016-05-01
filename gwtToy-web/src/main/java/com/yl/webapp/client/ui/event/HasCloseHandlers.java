package com.yl.webapp.client.ui.event;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasCloseHandlers {


	HandlerRegistration addCloseHandler(CloseHandler handler);

	HandlerRegistration addClosedHandler(ClosedHandler handler);

}
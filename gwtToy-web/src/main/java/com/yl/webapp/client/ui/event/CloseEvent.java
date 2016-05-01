package com.yl.webapp.client.ui.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Represents an event that is fired right before a widget is closed.
 * 
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * 
 * @see ClosedEvent
 * 
 */
public class CloseEvent extends GwtEvent<CloseHandler> {

	private static final Type<CloseHandler> TYPE = new Type<CloseHandler>();

	public static Type<CloseHandler> getType() {
		return TYPE;
	}

	public CloseEvent() {
	}

	@Override
	public final Type<CloseHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(CloseHandler handler) {
		handler.onClose(this);
	}

}

package com.yl.webapp.client.ui.event;


import com.google.gwt.event.shared.EventHandler;


public interface ClosedHandler extends EventHandler {

	/**
	 * This method is called when the has been closed.
	 * 
	 * @param closedEvent
	 */
	void onClosed(ClosedEvent closedEvent);
}

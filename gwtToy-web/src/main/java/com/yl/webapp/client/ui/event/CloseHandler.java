package com.yl.webapp.client.ui.event;

import com.google.gwt.event.shared.EventHandler;

public interface CloseHandler extends EventHandler {

	/**
	 * This method is called immediately before the widget will be closed.
	 * 
	 * @param closeEvent
	 */
	void onClose(CloseEvent closeEvent);
}

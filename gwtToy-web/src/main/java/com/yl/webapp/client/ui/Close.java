package com.yl.webapp.client.ui;

import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.base.HasType;

public class Close extends Anchor implements HasType<DismissType> {

	/**
	 * Creates an icon without behavior.
	 */
	public Close() {
		setStyleName("close");
		setHTML("&times;");
	}

	/**
	 * Creates an icon that closes an associated widget.
	 * 
	 * @param dismiss
	 *            the type of widget to be closed
	 */
	public Close(DismissType dismiss) {
		this();
		setType(dismiss);
	}

	/**
	 * Sets the type of widget to be closed.
	 * 
	 * @param type
	 *            the type of widget to be closed
	 */
	public void setType(DismissType type) {
		getElement().setAttribute("data-dismiss", type.get());
	}

	@Override
	public DismissType getType() {
		// TODO Auto-generated method stub
		return null;
	}
}

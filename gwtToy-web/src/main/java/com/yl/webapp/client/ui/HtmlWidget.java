package com.yl.webapp.client.ui;


import org.gwtbootstrap3.client.ui.base.helper.StyleHelper;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Widget with support for HTML.
 * 
 * <p>
 * When extendind this class, the child class should always expose a constructor
 * with a String argument. This argument is HTML text. The constructor is used
 * by the {@link com.google.gwt.uibinder.elementparsers.HTMLPanelParser
 * HTMLPanelParser} to parse UiBinder XML.
 * </p>
 * <h3>Child Class Constructor Example</h3>
 * 
 * <pre>
 * public ChildPanel extends HtmlWidget {
 *     public ChildPanel(String html) {
 *         super("label", html); //"label" is the HTML tag used for the child class.
 *     }
 * }
 * </pre>
 * 
 * @since 2.0.4.0
 * 
 * @author ohashi keisuke
 */
public class HtmlWidget extends HTMLPanel implements HasStyle, IsResponsive {

	/**
	 * Creates an empty widget.
	 * 
	 * @param tag
	 *            the tag of the root element
	 */
	protected HtmlWidget(String tag) {
		super(tag, "");
	}

	/**
	 * Creates an HTML panel whose root element has the given tag, and with the
	 * specified HTML contents. Any element within this HTML that has a
	 * specified id can contain a child widget.
	 * 
	 * @param tag
	 *            the tag of the root element
	 * @param html
	 *            the panel's HTML
	 */
	public HtmlWidget(String tag, String html) {
		super(tag, html);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setShowOn(Device device) {
		ResponsiveHelper.setShowOn(this, device);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHideOn(Device device) {
		ResponsiveHelper.setHideOn(this, device);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStyle(Style style) {
		StyleHelper.setStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addStyle(Style style) {
		StyleHelper.addStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeStyle(Style style) {
		StyleHelper.removeStyle(this, style);
	}
}

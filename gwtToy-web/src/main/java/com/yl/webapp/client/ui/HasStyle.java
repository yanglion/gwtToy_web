package com.yl.webapp.client.ui;

public interface HasStyle {

	/**
	 * Replaces the widet's style with the provided one.
	 * 
	 * @param style
	 *            the style to be applied to the Widget.
	 */
	void setStyle(Style style);

	/**
	 * Adds the provided style to the widget.
	 * 
	 * @param style
	 *            the style to be added to the Widget.
	 */
	void addStyle(Style style);

	/**
	 * Removes the provided style from the widget.
	 * 
	 * @param style
	 *            the style to be removed from the Widget.
	 */
	void removeStyle(Style style);
}

package com.yl.webapp.client.ui;

public interface IsAnimated {

	/**
	 * Sets whether the Widget should be animated.
	 * 
	 * @param animation
	 *            <code>true</code> if the widget should be animated.
	 */
	void setAnimation(boolean animation);

	/**
	 * Gets whether the widget is animated.
	 * 
	 * @return <code>true</code> if the widget is animated
	 */
	boolean getAnimation();
}

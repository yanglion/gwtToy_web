package com.yl.webapp.client.ui;

public interface IsResponsive {

	/**
	 * Sets the kind of device, this widget is shown on.
	 * 
	 * <p>
	 * The widget is not shown on any other device.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param device
	 * 
	 * @see Configurator#hasResponsiveDesign()
	 * @see #setHideOn(Device)
	 */
	void setShowOn(Device device);

	/**
	 * Sets the kind of device, this widget is hidden on.
	 * 
	 * <p>
	 * The widget is not hidden on any other device.
	 * </p>
	 * 
	 * <p>
	 * <b>Only works if responsive design is turned on!</b>
	 * </p>
	 * 
	 * @param device
	 * 
	 * @see Configurator#hasResponsiveDesign()
	 * @see #setShowOn(Device)
	 */
	void setHideOn(Device device);
}

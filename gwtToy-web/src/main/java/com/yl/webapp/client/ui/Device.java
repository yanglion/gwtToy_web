package com.yl.webapp.client.ui;

public enum Device implements Style {
	/**
	 * In the default configuration these are devices with a screen width of 480
	 * px and below.
	 */
	PHONE("phone"),

	/**
	 * In the default configuration these are devices with a screen width of 767
	 * px and below.
	 */
	TABLET("tablet"),

	/**
	 * In the default configuration these are devices with a screen width of 768
	 * px and above.
	 */
	DESKTOP("desktop");

	private String name;

	private Device(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	public String get() {
		return name;
	}
}
package com.yl.webapp.client.ui;

import org.gwtbootstrap3.client.ui.constants.Type;

public enum DismissType implements Type {

	ALERT("alert"), MODAL("modal");

	private String className;

	private DismissType(String className) {
		this.className = className;
	}

	/**
	 * {@inheritDoc}
	 */
	public String get() {
		return className;
	}
}

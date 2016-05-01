package com.yl.webapp.client.ui;

import com.google.gwt.user.client.ui.UIObject;

public class formerStyleHelper {
	/**
	 * Adds the provided style to the widget.
	 *
	 * @param widget
	 *            the widget to be added style.
	 * @param style
	 *            the style to be added to the Widget.
	 */
	public static <T extends UIObject> void addStyle(T widget, Style style) {
	    
	    if(style == null || style.get().isEmpty()) {
	        return;
	    }
	    
	    widget.addStyleName(style.get());
	}

	/**
	 * Replaces the widget's style with the provided one.
	 *
	 * @param widget
	 *            the widget to be applied style.
	 * @param style
	 *            the style to be applied to the Widget.
	 */
	public static <T extends UIObject> void setStyle(T widget, Style style) {
		widget.setStyleName(style.get());
	}

	/**
	 * Removes the provided style from the widget.
	 *
	 * @param widget
	 *            the widget to be removed style.
	 * @param style
	 *            the style to be removed from the Widget.
	 */
	public static <T extends UIObject> void removeStyle(T widget, Style style) {
		String styleString = style.get();

		if (!styleString.isEmpty()) {
			widget.removeStyleName(styleString);
		}
	}


	public static <S extends Enum<S> & Style> void changeStyle(UIObject widget, S style,Class<S> styleEnums) {
		assert styleEnums != null : "styleEnums should not be null.";

		changeStyle2(widget, style, styleEnums.getEnumConstants());
	}


	public static <S extends Style> void changeStyle2(UIObject widget,S style,S[] otherStyles) {

		assert widget != null && otherStyles != null : "any args should not be null.";

		for(S s : otherStyles) {
			removeStyle(widget, s);
		}

		addStyle(widget, style);
	}
	
}


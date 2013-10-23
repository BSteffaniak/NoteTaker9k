package com.ehs.notetaker9k;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * 
 * 
 * @author	Braden Steffaniak
 * @since	Oct 23, 2013 at 6:14:42 PM
 * @since	v
 * @version	Oct 23, 2013 at 6:14:42 PM
 * @version	v
 */
public class Screen
{
	private static final Dimension screenSize;
	
	static
	{
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public static Dimension getScreenSize()
	{
		return screenSize;
	}
}
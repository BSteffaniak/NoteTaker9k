package com.ehs.notetaker9k;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * 
 * 
 * @author	Braden Steffaniak
 * @since	Oct 23, 2013 at 6:11:00 PM
 * @since	v
 * @version	Oct 23, 2013 at 6:11:00 PM
 * @version	v
 */
public class Sticky
{
	private JDialog	frame;
	
	/**
	 * 
	 */
	public Sticky()
	{
		frame = new JDialog();
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setModalityType(JDialog.ModalityType.MODELESS);
		frame.setAlwaysOnTop(false);
		
		
		
		frame.setVisible(true);
//		frame.transferFocus();
//		frame.setFocusable(false);
//		frame.setFocusableWindowState(false);
		frame.toBack();
	}
	
	public Sticky(int x, int y)
	{
		this();
		
		frame.setLocation(x, y);
	}
}
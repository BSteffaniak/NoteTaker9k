package com.ehs.notetaker9k;

import java.util.ArrayList;

/**
 * 
 * 
 * @author	Braden Steffaniak
 * @since	Oct 23, 2013 at 3:13:38 PM
 * @since	v
 * @version	Oct 23, 2013 at 3:13:38 PM
 * @version	v
 */
public class NoteTaker9k
{
	private ArrayList<Sticky>	stickies;
	
	/**
	 * 
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		NoteTaker9k program = new NoteTaker9k();
	}
	
	/**
	 * 
	 */
	public NoteTaker9k()
	{
		stickies = new ArrayList<Sticky>();
		
		OptionsFrame f = new OptionsFrame(this);
	}
	
	public void addSticky()
	{
		Sticky sticky = new Sticky();
		
		stickies.add(sticky);
	}
}
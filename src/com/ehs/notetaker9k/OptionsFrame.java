package com.ehs.notetaker9k;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class OptionsFrame
{
	private TrayIcon	icon;
	
	private JFrame		frame;
	
	public OptionsFrame(final NoteTaker9k program)
	{
//		frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//		
//		frame.pack();
//		frame.setVisible(true);
		
		SystemTray tray   = SystemTray.getSystemTray();
		
		Image stickyImage = Sticky.getStickyImage(128, 128, 30);
		
		icon = new TrayIcon(stickyImage, "NoteTaker9k");
		icon.setImageAutoSize(true);
		
		final PopupMenu menu = new PopupMenu();

	    final MenuItem newSticky = new MenuItem("New Sticky");
	    menu.add(newSticky);
	    final MenuItem menuItem  = new MenuItem("Quit");
	    menu.add(menuItem);
		
		ActionListener menuListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == menuItem)
				{
					System.exit(0);
				}
				else if (e.getSource() == newSticky)
				{
					program.addSticky();
				}
			}
		};
		
		menuItem.addActionListener(menuListener);
		newSticky.addActionListener(menuListener);
	    
	    icon.setPopupMenu(menu);
	    icon.addMouseListener(new MouseListener()
		{
			public void mouseReleased(MouseEvent e)
			{
//				menu.show(frame, e.getX(), e.getY());
			}
			
			public void mousePressed(MouseEvent e)
			{
				
			}
			
			public void mouseExited(MouseEvent e)
			{
				
			}
			
			public void mouseEntered(MouseEvent e)
			{
				
			}
			
			public void mouseClicked(MouseEvent e)
			{
				
			}
		});
		
		MouseAdapter mouseAdapter = new MouseAdapter()
		{
            public void mouseClicked(MouseEvent e)
            {
//                icon.displayMessage("Omt TrayIcon Demo",
//                        "This is an info message from TrayIcon omt demo",
//                        TrayIcon.MessageType.INFO);
            }
        };

        icon.addMouseListener(mouseAdapter);
		
		try
		{
			tray.add(icon);
		}
		catch (AWTException e)
		{
			e.printStackTrace();
		}
	}
}
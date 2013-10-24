package com.ehs.notetaker9k;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	private boolean			moving;
	
	private int				button;
	private int				oldX, oldY;
	private int				topPartHeight;
	
	private Point			initialClick;
	
	private BufferedImage	image;
	
	private Graphics2D		graphics;
	
	private PopupMenu		menu;
	
	private JPanel			contentPanel;
	
	private JFrame			frame;
	
	/**
	 * 
	 */
	public Sticky()
	{
		frame = new JFrame()
		{
//			public void paint(Graphics g)
//			{
//				super.paint(g);
//				
//				g.drawImage(image, 0, 0, null);
//			}
		};
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		//frame.setModalityType(JDialog.ModalityType.TOOLKIT_MODAL);
		//frame.setAlwaysOnTop(false);
		
		contentPanel = new JPanel()
		{
			public void paintComponent(Graphics g)
			{
	            g.clearRect(0, 0, getWidth(), getHeight());
	            
	            g.drawImage(image, 0, 0, null);
	        }
		};
		
		contentPanel.setSize(frame.getSize());
		
		frame.setContentPane(contentPanel);
		
		
		
		frame.setVisible(true);
//		frame.transferFocus();
//		frame.setFocusable(false);
//		frame.setFocusableWindowState(false);
//		frame.toBack();
		
		image         = getStickyImage(frame.getWidth(), frame.getHeight());
		
		topPartHeight = image.getHeight() / 10;
		
		graphics = image.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setStroke(new BasicStroke(2.0f));
		graphics.setColor(Color.BLACK);
		
		menu = new PopupMenu();
		final MenuItem item = new MenuItem("Quit");
		menu.add(item);
		
		frame.add(menu);
		
		ActionListener menuListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (e.getSource() == item)
				{
					frame.dispose();
				}
			}
		};
		
		item.addActionListener(menuListener);
		
		frame.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent e)
			{
				
			}
			
			public void mouseDragged(MouseEvent e)
			{
				if (button == 1)
				{
					if (moving)
					{
						//frame.setLocation(e.getXOnScreen() - e.getX() - oldX, e.getYOnScreen() - e.getY() - oldY);
						// get location of Window
			            int thisX = e.getXOnScreen() - e.getX();//frame.getLocation().x;
			            int thisY = e.getYOnScreen() - e.getY();//frame.getLocation().y;
			 
			            // Determine how much the mouse moved since the initial click
			            int xMoved = ( thisX + e.getX() ) - ( thisX + initialClick.x );
			            int yMoved = ( thisY + e.getY() ) - ( thisY + initialClick.y );
			 
			            // Move window to this position
			            int X = thisX + xMoved;
			            int Y = thisY + yMoved;
			            
			            frame.setLocation( X, Y );
					}
					else
					{
						graphics.drawLine(e.getX(), e.getY(), oldX, oldY);
						
						
						frame.repaint();
					}
					
					oldX = e.getX();
					oldY = e.getY();
				}
			}
		});
		
		frame.addMouseListener(new MouseListener()
		{
			
			public void mouseReleased(MouseEvent e)
			{
				moving = false;
			}
			
			public void mousePressed(MouseEvent e)
			{
				button = e.getButton();
				
				if (button == 1)
				{
					oldX = e.getX();
					oldY = e.getY();
					
					if (e.getY() <= topPartHeight)
					{
						initialClick = e.getPoint();
						frame.getComponentAt( initialClick );
						moving = true;
					}
					else
					{
						graphics.drawLine(e.getX(), e.getY(), oldX, oldY);
						
						frame.repaint();
					}
				}
				else if (button == 3)
				{
					
					menu.show(frame, e.getX(), e.getY());
				}
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
	}
	
	public Sticky(int x, int y)
	{
		this();
		
		frame.setLocation(x, y);
	}
	
	private static void drawStickyNote(Graphics2D g, int width, int height)
	{
		Color yellow = new Color(255, 255, 0);
		
		int topPartHeight = height / 10;
		
		g.setColor(yellow);
		g.fillRect(0, 0, width, height);
		
		Color topPart       = new Color(220, 220, 0);
		
		g.setColor(topPart);
		g.fillRect(0, 0, width, topPartHeight);
		
		Color topPartDivider = new Color(140, 140, 0);
		
		g.setColor(topPartDivider);
		g.fillRect(0, topPartHeight, width, 1);
	}
	
	public static BufferedImage getStickyImage(int width, int height)
	{
		BufferedImage stickyImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		
		Graphics2D graphics = stickyImage.createGraphics();
		drawStickyNote(graphics, width, height);
		
		return stickyImage;
	}
}
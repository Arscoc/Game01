package Graphic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameObject.Bullet;
import GameObject.Box.Verse;
import IgpeGame.WorldGame;



public class Menu_Panel extends JPanel
{
	WorldGame world;
//	Game_Panel game;
	Window_Frame window;
	JLabel label;
	
	ImageIcon ii = new ImageIcon(getClass().getResource("/assets/menu.gif"));
	public Menu_Panel()
	{
		try{
		setPreferredSize(new Dimension(640,414));		
		setBackground(Color.GRAY);
		setLayout(null);
		label=new JLabel();
		
        label.setIcon(ii);
//		JButton multiplayer = new JButton("MULTIPLAYER");
//		multiplayer.addActionListener(new ActionListener() 
//		{
//			Window_Frame window2=new Window_Frame();
//			
//		});
        label.setBounds(0, 0,640,416);
		JButton start = new JButton("START");
		JButton exit = new JButton("EXIT");
		start.setBounds(100, 250,80, 85);
		exit.setBounds(440, 250,80, 85);
		
		start.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
			if(window!=null)
			{
				window.switchto();
			}
			else
				System.out.println("WINDOWSNULL");
}	
		});	
		exit.addActionListener(e -> System.exit(0));
		this.add(start);
		this.add(exit);

//		this.add(multiplayer);
        add(label);
        label.setVisible(true);
		start.setVisible(true);
		exit.setVisible(true);
		setVisible(true);}
		catch (Exception exception) {
            exception.printStackTrace();
        }
	}
		
//	
//	@Override
//	protected void paintComponent(final Graphics g) 
//	{	
//		g.drawImage(ImageLoader.getMenu(), 0, 0, null);
//	}
//	
	public Window_Frame getWindow() 
	{
		return window;
	}
	public void setWindow(Window_Frame window) 
	{
		this.window = window;
	}


}

package Graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GameObject.Bullet;
import GameObject.Enemy;
import GameObject.Platform;
import GameObject.Box.Verse;
import IgpeGame.*;

public class Game_Panel extends JPanel
{
	WorldGame world; 
	Window_Frame window;
	Listener listener;
	boolean inpausa= false;
	public Integer bull=0;
	public JLabel info;
	public JLabel data;
	public JLabel position;
	public int before;
	public int after;
	public int diff;

	public Game_Panel()
	{
		setLayout(null);
		setPreferredSize(new Dimension(1280,720));		
		world= new WorldGame();
		listener= new Listener(world);
		addKeyListener(listener);
		setBackground(Color.BLACK);
		setVisible(true);
		info = new JLabel();
	    info.setBounds(1100, 0, 70, 140);
	    info.setForeground(Color.RED);
		add(info);
		data = new JLabel();
	    data.setBounds(1200, 0, 70, 140);
	    data.setForeground(Color.RED);
		add(data);
		before=world.c.x;


	}

	public void Start()
	{
		new Thread() {
			@Override
			public void run() {
			
				while (true) {
					
					gameInfo();
					if (!inpausa) {
						Game_Panel.this.world.Update();
					}
					repaint();
					
				}
			};
		}.start();
		
	}
	int center_val=580;
	int limit_val;
	@Override
	protected void paintComponent(final Graphics g) 
	{		
		after=world.c.x;
		diff=after-before;
		if (world.c.x<=620)limit_val=0;
		else limit_val=720;
		if (world.x==1280)limit_val=0;
		
		super.paintComponent(g);
		
		
		
		
		
		if (world.on_screen==0||world.on_screen==1)
			g.drawImage(ImageLoader.getWorld1(), 0, 0, null);
		if (world.on_screen==2 )
			g.drawImage(ImageLoader.getWorld2(), 0, 0, null);
		

		if (world.on_screen==3)
			g.drawImage(ImageLoader.getWorld3(), 0, 0, null);

//---------------------------------	SCREEN CENTER------------------------------------------------------------------------------------------------


	if (world.c.x>620 &&  world.c.x+world.c.w<world.x-620) {

		
		if (world.on_screen==2  && limit_val==0)
			g.drawImage(ImageLoader.getWorld2(), 0, 0, null);

			
	for (Platform p:world.platforms)				
			g.drawImage(ImageLoader.getGround(p.w, p.h), p.x-diff+center_val, p.y, null);
	if (world.c.verse==Verse.LEFT) 					
			g.drawImage(ImageLoader.getCharacterLeft(), 620, world.c.y, null);
	else if (world.c.verse==Verse.RIGHT) 			
			g.drawImage(ImageLoader.getCharacterRight(), 620, world.c.y, null);
	for (Bullet b:world.bullets)	
		if (b.boss)
			g.drawImage(ImageLoader.getBossBulletLeft(), b.x-diff+center_val, b.y, null);
		else
			g.drawImage(ImageLoader.getBullet(), b.x-diff+center_val, b.y, null);
	for (Enemy e:world.enemies)	{					
		if(e.on_screen==world.on_screen) {			
			if(e.verse==Verse.LEFT && e.boss==false)		
				g.drawImage(ImageLoader.getEnemy_left(), e.x-diff+center_val, e.y, null);	
			else if(e.verse==Verse.RIGHT && e.boss==false) 	
				g.drawImage(ImageLoader.getEnemy_right(), e.x-diff+center_val, e.y, null);
			else if(e.boss==true)							
				g.drawImage(ImageLoader.getBoss(), e.x, e.y, null);
				}
			}
		}
		
		
//---------------------------------	SCREEN LIMIT-------------------------------------------------------------------------------------------------
	
	else{
		


			
	for (Platform p:world.platforms)				
		g.drawImage(ImageLoader.getGround(p.w, p.h), p.x-limit_val, p.y, null);
	if (world.c.verse==Verse.LEFT) 					
		g.drawImage(ImageLoader.getCharacterLeft(), world.c.x-limit_val, world.c.y, null);
	else if (world.c.verse==Verse.RIGHT) 			
		g.drawImage(ImageLoader.getCharacterRight(), world.c.x-limit_val, world.c.y, null);
	for (Bullet b:world.bullets)	
		if (b.boss)
			g.drawImage(ImageLoader.getBossBulletLeft(), b.x-limit_val, b.y, null);
		else
		    g.drawImage(ImageLoader.getBullet(), b.x-limit_val, b.y, null);
	for (Enemy e:world.enemies)	{					
		if(e.on_screen==world.on_screen) {			
			if(e.verse==Verse.LEFT && e.boss==false)		
				g.drawImage(ImageLoader.getEnemy_left(), e.x-limit_val, e.y, null);	
			else if(e.verse==Verse.RIGHT && e.boss==false) 	
				g.drawImage(ImageLoader.getEnemy_right(), e.x-limit_val, e.y, null);
			else if(e.boss==true)							
				g.drawImage(ImageLoader.getBoss(), e.x, e.y, null);
				}
			}
		}
//------------------------------------------------------ H U D ------------------------------------------------------------			

	if (world.on_screen==3 && world.bosslife>0 ) {		
			g.drawImage(ImageLoader.getLife(67*world.bosslife,18),306,101, null);
			g.drawImage(ImageLoader.getBar(),304,100, null);
	}
	if (world.c.max_bullet>5)						
			g.drawImage(ImageLoader.getGunicon_notavaible(), 20, 100, null);
	else
			g.drawImage(ImageLoader.getGunicon_avaible(), 20, 100, null);	
	
	
	
	}
	
	
	
	
	
	public void infoSwitch()
	{
		if (world.infoOn==false) {
			info.setVisible(false);
			data.setVisible(false);
		}
		else{
			info.setVisible(true);
			data.setVisible(true);
		}
	}
	
	
	public void gameInfo()
	{
		
		infoSwitch();

		

		info.setText(
						"<html>bullets" + 
						"<br>enemies"	+
						"<br>screen"	+
						"<br>boss life" +
						"<br>character X"+
						"<br>character Y"+
						"<br>limite"+
						"<br>centro"
					);

		
		
	
		data.setText(
						"<html>"+world.bullets.size()+ 
						"<br>" + world.enemies.size()+
						"<br>" + world.on_screen	 +
						"<br>" + world.bosslife		 +
						"<br>" + world.c.x			 +
						"<br>" + world.c.y				+
						"<br>" + this.limit_val	+
						"<br>" + this.center_val
						
						);
		
	

	}
}

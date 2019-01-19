package IgpeGame;


import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

import Graphic.Game_Panel;
import Graphic.Window_Frame;

public class Listener implements KeyListener
{
	Window_Frame window;
	WorldGame world;
	public Listener(WorldGame world)
	{
		this.world=world;
	}
	public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode()==39) {	this.world.c.right=false;}
		
		if (e.getKeyCode()==37) {	 this.world.c.left=false;} 	
		
		if (e.getKeyCode()==32) {	 //if (world.character_bullet<5) 
			 this.world.c.shot(); 	}
	}

	public void keyTyped(KeyEvent e) 
	{
		
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{		
		
		if (e.getKeyCode()==39) 
		{	 
			world.c.right=true; 

		}
		
		if (e.getKeyCode()==37) 
		{	
			world.c.left=true;	 
						
		} 	
		
		
		if (e.getKeyCode()==38) {	 if ( this.world.c.jumping==false && this.world.c.falling==false) this.world.c.jumping=true;} 	

		
		if (e.getKeyCode()==73) 
		{	 
		if(this.world.infoOn==true)
			this.world.infoOn=false;
		else
			this.world.infoOn=true;
		}
				
		
}
	

	
	
	}
package GameObject;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import GameObject.Box.Type;
import GameObject.Bullet.Shooter;
import IgpeGame.WorldGame;

public class Character extends Box 
{
	
	public int max_height=0;
	public  boolean right=false,left=false,jumping=false,falling=false;
	public  boolean in_air=false;
	public int max_bullet=0;
	public int on_screen=0;
	WorldGame world;
	public Character(WorldGame world)
	{
		super( 40,650,Verse.RIGHT,  40 , 40);
		this.world=world;
		tipo=Type.CHARACTER;
	}	
	
	
	public boolean can_climb()
	{
		for (Platform p:world.platforms)
		{
			if ((p.x+p.w>=x+5) && 
				(p.x<=x+35) && 
				(y+h==p.y))
			{
				return true;
				
			}
		}return false;
	}
	
	public void shot()
	{
		if (max_bullet<6)
		{
		   Bullet b= new Bullet(world,0,0,verse);			
		   max_bullet++;
			switch (verse)
			{
				case RIGHT:		
				b.setxy(x+w,y+h/2); break;
				case LEFT:		
				b.setxy(x,y+h/2); break; 
			}
			b.shooter=Shooter.BYCHARACTER;
			world.bullets.add(b);
		}

		
	}

}


//
//public void move_left()
//{
//	verse=Verse.LEFT;//System.out.println(verse);
//	
//	for(Enemy e:WorldGame.enemies)
//	{
//		if (collide(e))
//		{
//			System.exit(1);			}
//	}
//	if (x<=5)  
//			{
//				x=0;
//				
//			}
//	else 
//			{	
//			x-=5;
//				
//			}			System.out.println(x+"  "+y);
//
//	if (x+35	<		WorldGame.platforms[on_plat].x)
//	{ 
//		fall();
//	}
//	
//	
//}	
//ublic  void move_right()
//{		
//	verse=Verse.RIGHT;// System.out.println(verse);
//	for(Enemy e:WorldGame.enemies)
//	{
//		if (collide(e))
//		{
//			System.out.println("Il tuo personaggio e morto, GAY!");
//			System.exit(1);			}
//	}
//	
//	if (x>=1240)  
//	{
//		x=1240;
//	}
//	else 
//		{	
//			x+=5;
//			
//		}			System.out.println(x+"  "+y);
//
//	if (x+5		>		WorldGame.platforms[on_plat].w+WorldGame.platforms[on_plat].x)
//	{
//		fall();
//	}
//
//  }public void jump()
//{
//
//	in_air=true;
//	while (count<=40)
//	{
//		WorldGame.lock.lock();
//		if (y==0)
//			{count=41;	in_air=false;}
//		else
//			y-=5;count++;WorldGame.lock.unlock();
//		System.out.println(x+"  "+y);
//																		try {
//			WorldGame.sleep(25);
//																		} catch (InterruptedException e) {
//																					e.printStackTrace();
//																		}	
//		
//		
//	}
//	
//	
//}
//
//
//public void fall()
//{
//
//	while (y<=600)
//	{
//		WorldGame.lock.lock();
//
//		for (int i=0; i<WorldGame.platforms.length; i++) 
//		{
//			
//					if (this.can_climb(WorldGame.platforms[i])==true)
//					{
//						on_plat=i; 
//						return;		
//					}	
//		}
//		y+=5;
//																try {
//			WorldGame.sleep(20);
//																} catch (InterruptedException e) {
//																	e.printStackTrace();
//																}
//		System.out.println(x+"  "+y);
//	}		
//}
//

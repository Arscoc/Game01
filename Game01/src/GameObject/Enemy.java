package GameObject;

import GameObject.Box;
import GameObject.Box.Type;
import GameObject.Box.Verse;
import GameObject.Bullet.*;
import IgpeGame.WorldGame;

import java.util.Timer;
import java.util.TimerTask;

public class Enemy extends Box
{
public int on_plat;
public boolean move=true;
public boolean aggressive=true;
public boolean boss=false;
public static long start;
public int on_screen;
public int life=1;
public  enum Action {UP,DOWN,NULL};
public Action action;
WorldGame world;

	public Enemy(WorldGame world, int x , int y, int s)
	{
		
		
		super( x,y, 40 , 40);
		this.world=world;
		Type tipo=Type.ENEMY;
		on_screen=s;
		Action action=Action.NULL;
		if (this.world.c.x<x)
		{
			verse=Verse.LEFT;
		}
		else verse=Verse.RIGHT;
		start=(long) (System.currentTimeMillis()-3000);
//		for (Platform p:world.platforms) 
//		{	
//			if ((this.world.p.x+this.world.p.w>=x+5) && (this.world.p.x<=x+5) && (y+90==this.world.p.y))
//			on_plat = i;
//		}

		
			
	}	
	public boolean OnPlatform(Platform p)
	{
		if (p.y==y+h && p.x<=x && p.x+p.w>=x+w && on_screen == world.on_screen)
			return true;
		return false;
	}
	
   public void shot()
	{
	 
		Bullet b= null; 
		switch (verse)
		{
			case RIGHT:		
			b= new Bullet(world,x+w,y+h/2,verse); break;
			case LEFT:		
			b= new Bullet(world,x,y+h/2,verse); break;
		}
		start=(long) System.currentTimeMillis();
		b.shooter=Shooter.BYENEMY;
		this.world.bullets.add(b);
		
	   }


	

	}


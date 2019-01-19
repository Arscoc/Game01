package GameObject;

import GameObject.Box.Type;
import IgpeGame.WorldGame;


public class BulletBoss extends Bullet
{

	
	public BulletBoss(WorldGame world,int x , int y,Verse v) 
	{
			super(world,x,y,v);	
			w=50;
			 h=30;
			 boss=true;
	}
	
	
	
}
	


					
					
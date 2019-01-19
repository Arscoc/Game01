package GameObject;

import GameObject.Box.Type;
import IgpeGame.WorldGame;


public class Bullet extends Box
{
	public boolean boss=false;
	public boolean deletable=false;
	public static enum Shooter {BYCHARACTER, BYENEMY;} 
	public  Shooter shooter;
	WorldGame world;

	public Bullet(WorldGame world, int x , int y,Verse v) //il proiettile prende il verso del personaggio appena spara
	{
			super(x,y,v,9,9);					
			this.world=world;
			
	}
	
	
	
}
	


					
					
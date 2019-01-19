package GameObject;

import GameObject.Box.Verse;
import GameObject.Bullet.Shooter;
import GameObject.Enemy.Action;
import IgpeGame.WorldGame;

public class Boss extends Enemy
{
	public boolean alternate=true;
	public Boss(WorldGame world, int x, int y, int s) 
	{
		super(world, x, y, s);
		life=10;
		w=387;
		h=323; 
		boss=true;
		verse=Verse.LEFT;
		action=Action.DOWN;
	}

	
	@Override
	public void shot()
	{
		if (alternate==true)
		{
			Bullet b1= null; 
			Bullet b2= null; 			
			b1= new BulletBoss(world,x,y+100,verse); 
			b2= new BulletBoss(world,x,y+200,verse); 	
			start=(long) System.currentTimeMillis();
			b1.shooter=Shooter.BYENEMY;
			b2.shooter=Shooter.BYENEMY;
			this.world.bullets.add(b1);
			this.world.bullets.add(b2);
			alternate=false;
		}
		else
		{
			Bullet b1= null; 
			b1= new BulletBoss(world,x,y+150,verse); 
			start=(long) System.currentTimeMillis();
			b1.shooter=Shooter.BYENEMY;
			this.world.bullets.add(b1);
			alternate=true;

		}

	}
}

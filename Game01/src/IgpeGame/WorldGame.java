package IgpeGame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Graphic.*;
import Graphic.ImageLoader;
import GameObject.*;
import GameObject.Box.Verse;
import GameObject.Bullet;
import GameObject.Bullet.Shooter;
import GameObject.Boss;
import GameObject.Box;
import GameObject.Character;
import GameObject.Enemy.Action;
import GameObject.Platform;

public class WorldGame
{
	public  int x= 1280;
	public final int y = 720;
	public  Character c;
	public  ArrayList <Platform> platforms=new ArrayList <Platform>();
	public  ArrayList <Bullet> bullets=new ArrayList <Bullet>();
	public  ArrayList <Enemy> enemies=new ArrayList <Enemy>();
	public  ArrayList <Integer> pressed=new ArrayList <Integer>();
	public  int max=0;
	public  boolean running=false;
	public int on_screen=0;
	public static boolean bosshit=false;
	public int key=0;
	public int bosslife;
	Game_Panel panel;
	public boolean infoOn=true;
	public ServerSocket server=null;
	public Socket socketClient=null;
	
	int porta =6666;
	 
	DataInputStream in;
	DataOutputStream out;
	
public WorldGame ()
	{	
		c= new Character(this);
		Screen2();
		EnemyGenerator();
	}	

public void Update()
	{
		Check_Collision();
		Character_Movement();
		Bullet_Movement();
		Enemy_Movement();// for(Enemy e:enemies){System.out.println(e.x+" ");}System.out.println(" ");


		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	Print();
	}
public void Enemy_Movement()		  	//AGGIORNA LA POSIZIONE DEI NEMICI
{	
	
	for(Enemy e:enemies)
	{
		if (e.boss) bosslife=e.life;

		if (e.boss==false) {
				if(e.x>c.x) e.verse=Verse.LEFT;
				else 		e.verse=Verse.RIGHT;}
		if (e.aggressive==true && System.currentTimeMillis()>(long)(e.start+3000)  )
		{
			if(e.boss==false && (e.y==c.y)) 
			{
				switch(e.verse)
				{
					case RIGHT:
						if (c.x<=e.x+200  && e.on_screen==on_screen && e.boss==false)
							e.shot();
					case LEFT:
						if ( c.x>=e.x-200  && e.on_screen==on_screen && e.boss==false)
							e.shot();
				}	
			}
			else
			{
				if (e.on_screen==on_screen && e.boss==true ) e.shot();
			}
		}
		
		if (e.move==true && e.boss==false)
		{
			for (Platform p:platforms)
			{
				if (e.OnPlatform(p))
				{
					if(e.verse==Verse.RIGHT  )
					{	
						
						if (p.x+p.w==e.x+e.w)
						{
							e.x+=0;
						}
						else e.x+=1;						
					}
					else if(e.verse==Verse.LEFT )
					{	
						if ( p.x==e.x )
						{
							e.x+=0;
						}
						else e.x-=1;
	
					}
				}	
			}
		} System.out.println();
		
		if (e.action==Action.DOWN && e.on_screen==on_screen)
		{
			e.y+=2; if (e.y>=300) e.action=Action.UP;
		}
		else if (e.action==Action.UP && e.on_screen==on_screen)
		{
			e.y-=2; if (e.y<=100) e.action=Action.DOWN;
		}
	}

}	

public void Bullet_Movement() 		//AGGIORNA LA POSIZIONE DEI PROIETTILI
{
	
	
	
	
	
	
	for (Bullet b:bullets)
		{
		switch(b.verse)
			{
					case RIGHT:
						b.x+=9; 
						break;
					case LEFT:
						b.x-=9;
						break;
			}
			
		}
	
}
public void Character_Movement()		//AGGIORNA IL MOVIMENTO DEL GIOCATORE
{

//	for (Platform p:platforms)
//	{
//		if(c.can_climb(p))c.falling=false;
//	}
//	
	if (c.can_climb()==false && c.jumping==false)
	{
		c.falling=true;
	}
		
	if (c.can_climb()==true && c.falling==true && c.jumping==false)
	{
		c.falling=false;
	}

	if (c.falling)
	{
		c.y+=5;
//		c.falling=true;
	}
	if (c.jumping==true)
	{
			if (max>=200)
			{
				c.jumping=false;
				c.falling=true;
				max=0;
			}
			else if (max<200)
			{
				c.y-=5;
				max+=5;
			}	
			if (c.y==0)
			{
				c.falling=true;
				c.jumping=false;
			}
			
	}
	
	if(c.left)
	{
		c.verse=Verse.LEFT;
		
		if(c.x<=1 && on_screen==1) 
		{
			c.x=1240; on_screen=0;  bullets.clear(); platforms.clear();
			Screen0(); 
		}
		if(c.x<=1 && on_screen==2 ) 
		{
			c.x=1240; on_screen=1;  bullets.clear(); platforms.clear();
			Screen1();
			
		}
		if(c.x<=1 && on_screen==3 ) 
		{
			c.x=1960; on_screen=2;  bullets.clear(); platforms.clear();
			Screen2();
			
		}
		else if (c.x<=1 && on_screen==0) 
		{
			c.x=0;
		}
		else	c.x-=3;
		
	}
	if(c.right)
	{
		c.verse=Verse.RIGHT;
		if(c.x>=1239 && on_screen==0) 
		{
			c.x=0; on_screen=1;bullets.clear(); platforms.clear();
			Screen1();
		}
		if(c.x>=1239 && on_screen==1 ) 
		{
			c.x=0; on_screen=2;bullets.clear(); platforms.clear();
			Screen2();
		}
		if(c.x>=1959 && on_screen==2 ) 
		{
			c.x=0; on_screen=3;bullets.clear(); platforms.clear();
			Screen3();
		}
		else if(c.x>=1239 && on_screen==1) 
		{		
			c.x=1240;
		}
		if(c.x>=1239 && on_screen==3)
		{
			c.x=1240;
		}
		else if
		(c.x+c.w>=x) 
		{
			c.x=x-c.w;
		}
		else	c.x+=3;
		
		
	}
	if (c.y>650)
	{
		c.falling=true;
	}

	if (c.y>750)
		System.exit(0);
}


public void Check_Collision() 		//CONTROLLA LE COLLISIONI E RIMUOVE GLI OGGETTI
	{
//===============================VERIFICA COLLISIONI PROIETTILI=============================================	
		
	
		
	
//		Iterator <Bullet> itbu=bullets.iterator();
//		while(itbu.hasNext())
	
		for (int i=0; i<bullets.size(); i++)
		{
//			Bullet b=itbu.next();
//===============================================================================================
		
			if (bullets.get(i).x>=x || bullets.get(i).x<=0)
			{
				
				System.out.println("		MURO COLPITO	");
				System.out.println();
//				itbu.remove();
				bullets.get(i).deletable=true;
				if (bullets.get(i).shooter==Shooter.BYCHARACTER)
					c.max_bullet--;
			}
			
//==========================================================================================================
			
				Iterator <Platform> itpl=platforms.iterator();
				while(itpl.hasNext())
				{
					Platform p=itpl.next();
					if  (bullets.get(i).collide(p) && bullets.get(i).boss==false)
					{
						System.out.println("		PIATTAFORMA COLPITA		");
						System.out.println();
						bullets.get(i).deletable=true;
						if (bullets.get(i).shooter==Shooter.BYCHARACTER)
							c.max_bullet--;
					}
				}
			
//==========================================================================================================
		
				if (bullets.get(i).shooter==Shooter.BYCHARACTER )
				{	
					Iterator <Enemy> iten=enemies.iterator();
					while(iten.hasNext())
					{
						Enemy e=iten.next();
						if( e.boss==false  && bullets.get(i).collide(e) && e.on_screen==on_screen )
						{
							
							iten.remove();
							System.out.println("      NEMICO UCCISO      ");
							System.out.println();
							bullets.get(i).deletable=true;
							if (bullets.get(i).shooter==Shooter.BYCHARACTER)
								c.max_bullet--;
							
						}
						if( e.boss==true  && bullets.get(i).collide(e) && e.on_screen==on_screen ) 
						{
							e.life-=1;
							if (e.life==0)
								{
									if (e.boss) bosslife=e.life;
									iten.remove(); System.out.println("HAI VINTO"); 
								}
							System.out.println("      BOSS COLPITO      ");
							bosshit=true;
							System.out.println();
							bullets.get(i).deletable=true;
							if (bullets.get(i).shooter==Shooter.BYCHARACTER)
								c.max_bullet--;
						}
						
					}			
				}
//==========================================================================================================					
			
				else if (bullets.get(i).shooter==Shooter.BYENEMY && bullets.get(i).collide(c) )
			{
				System.out.println("Il tuo personaggio e morto!");
				System.out.println();
				bullets.get(i).deletable=true;

			}					

			
		}
//================================VERIFICA COLLISIONI NEMICI=============================================	
	for(Enemy e:enemies) 
	{
		if (e.collide(c) && e.on_screen==on_screen)
		{
			System.out.println("Il tuo personaggio e morto!");
		}		
	}

	
	
	Iterator <Bullet> itbu=bullets.iterator();
	while(itbu.hasNext())
	{
		Bullet b=itbu.next();
		if (b.deletable)
		{
			itbu.remove();
		}
	}
}

public void Screen0()
{		
	on_screen=0; this.x=1280;
	platforms.add(new Platform(0, 690, 1280, 30));
	platforms.add(new Platform(200, 500, 300, 30));
	platforms.add(new Platform(370, 600, 200, 30));
//		Enemy e2=new Enemy(20,290);enemies.add(e2);
//		Enemy e3=new Enemy(80,420);enemies.add(e3);
//		Enemy e4=new Enemy(90,490);enemies.add(e4);
}
public void Screen1()
{		
	on_screen=1; this.x=1280;
	platforms.add(new Platform(0, 690, 1280, 30));
	platforms.add(new Platform(400, 500, 400, 30));
	platforms.add(new Platform(900, 500, 200, 30));

}
public void Screen2()
{	
	on_screen=2; this.x=2000;
	platforms.add(new Platform(0, 690, 2000, 30));


}
public void Screen3()
{	
	on_screen=3; this.x=1280;
	platforms.add(new Platform(0, 690, 1280, 30));
	platforms.add(new Platform(150, 500, 180, 30));
	platforms.add(new Platform(500, 500, 180, 30));
	platforms.add(new Platform(150, 250, 180, 30));
	platforms.add(new Platform(500, 250, 180, 30));
	platforms.add(new Platform(270, 375, 300, 30));
	
}


public void EnemyGenerator()
{
	enemies.add(new Enemy(this, 1240,650,0));
	enemies.add(new Enemy(this,380,460,0));
	enemies.add(new Enemy(this,420,460,1));
	enemies.add(new Boss(this,800,100,3));
	enemies.add(new Enemy(this,1200,650,2));

}




void Print()
{
	
	

	
//System.out.println("GIOCATORE		"+c.x +"-"+ c.y		);
//System.out.print  ("NEMICI    		");
//for(Enemy e:enemies)
//	System.out.println(e.x+"  "+e.y+"-------");
//System.out.println(e.on_screen+"   "+on_screen );
//System.out.println();
//System.out.print  ("PROIETTILI 		");
//for(Bullet b:bullets)
//{
//	System.out.println(b.x+"-"+b.y+" >"+"  "+b.boss+"   "+b.w+"-"+b.h);
//}


//for(Enemy e:enemies)	
//{
//if(e.boss==true)
//{
//	System.out.println(e.x + "  "+ e.y + "  ");
//}


}


}





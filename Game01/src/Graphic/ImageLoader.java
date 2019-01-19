package Graphic;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import IgpeGame.WorldGame;


public class ImageLoader 
{
		private static Image menu_background;
		private static Image world1;
		private static Image world2;
		private static Image world3;
		private static Image character_left;
		private static Image character_right;		
		private static Image gunicon_avaible;
		private static Image gunicon_notavaible;
		private static Image bullet;
		private static Image boss_bullet_right;
		private static Image boss_bullet_left;
		private static Image boss;
		private static Image bosshit;
		private static BufferedImage ground;
		private static Image enemy_right;
		private static Image enemy_left;
		private static Image boss_life;
		private static Image boss_bar;


		private ImageLoader() 
		{}
		static {
			try {
				world1 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("assets/world1.png"))
						.getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
				world2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("assets/world2.jpg"))
						.getScaledInstance(1600, 720, java.awt.Image.SCALE_SMOOTH);
				world3 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("assets/world3.png"))
						.getScaledInstance(1280, 720, java.awt.Image.SCALE_SMOOTH);
	
				
				
				
				character_right = ImageIO
						.read(Thread.currentThread().getContextClassLoader().getResource("assets/character_right.png"))
						.getScaledInstance(40, 40,java.awt.Image.SCALE_SMOOTH);
				character_left = ImageIO
						.read(Thread.currentThread().getContextClassLoader().getResource("assets/character_left.png"))
						.getScaledInstance(40, 40,java.awt.Image.SCALE_SMOOTH);
				ground = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("assets/ground.png"));
			
//				menu_background=ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/menu_background.png"))
//						.getScaledInstance(500, 500,java.awt.Image.SCALE_DEFAULT);
				
				bullet = ImageIO
						.read(Thread.currentThread().getContextClassLoader().getResource("assets/bullet.png"))
						.getScaledInstance(9, 9, java.awt.Image.SCALE_SMOOTH);
//				boss_bullet_right = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/boss_bullet_right.png"))
//						.getScaledInstance(50, 30, java.awt.Image.SCALE_SMOOTH);
				boss_bullet_left = ImageIO
						.read(Thread.currentThread().getContextClassLoader().getResource("assets/boss_bullet_left.png"))
						.getScaledInstance(50, 30, java.awt.Image.SCALE_SMOOTH);
				enemy_left = ImageIO
						.read(Thread.currentThread().getContextClassLoader().getResource("assets/enemy_left.png"))
						.getScaledInstance(40,40, java.awt.Image.SCALE_SMOOTH);
				enemy_right = ImageIO
						.read(Thread.currentThread().getContextClassLoader().getResource("assets/enemy_right.png"))
						.getScaledInstance(40,40, java.awt.Image.SCALE_SMOOTH);
				gunicon_avaible = ImageIO
						.read(Thread.currentThread().getContextClassLoader().getResource("assets/gunicon_avaible.png"))
						.getScaledInstance(45,27, java.awt.Image.SCALE_SMOOTH);
				gunicon_notavaible  = ImageIO
						.read(Thread.currentThread().getContextClassLoader().getResource("assets/gunicon_notavaible.png"))
						.getScaledInstance(45,27, java.awt.Image.SCALE_SMOOTH);
				boss  = ImageIO
						.read(Thread.currentThread().getContextClassLoader().getResource("assets/boss.png"))
						.getScaledInstance(387,373, java.awt.Image.SCALE_SMOOTH);
//				bosshit  = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/boss_hit.png"))
//						.getScaledInstance(387,373, java.awt.Image.SCALE_SMOOTH);
//===========================================================================================================================				
//				menu_background_1 = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/menu/menu_background_1.png"))
//						.getScaledInstance(96, 62, java.awt.Image.SCALE_SMOOTH);
//				menu_background_2 = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/menu/menu_background_2.png"))
//						.getScaledInstance(96, 62, java.awt.Image.SCALE_SMOOTH);
//				menu_background_3 = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/menu/menu_background_3.png"))
//						.getScaledInstance(96, 62, java.awt.Image.SCALE_SMOOTH);
//				menu_background_4 = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/menu/menu_background_4.png"))
//						.getScaledInstance(96, 62, java.awt.Image.SCALE_SMOOTH);
//				menu_background_5 = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/menu/menu_background_5.png"))
//						.getScaledInstance(96, 62, java.awt.Image.SCALE_SMOOTH);
//				menu_background_6 = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/menu/menu_background_6.png"))
//						.getScaledInstance(96, 62, java.awt.Image.SCALE_SMOOTH);
//				menu_background_7 = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/menu/menu_background_7.png"))
//						.getScaledInstance(96, 62, java.awt.Image.SCALE_SMOOTH);
//				menu_background_8 = ImageIO
//						.read(Thread.currentThread().getContextClassLoader().getResource("assets/menu/menu_background_8.png"))
//						.getScaledInstance(96, 62, java.awt.Image.SCALE_SMOOTH);
//				
//				
				boss_life = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("assets/bosslife.png"))
						.getScaledInstance(668, 18, java.awt.Image.SCALE_SMOOTH);
				boss_bar = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("assets/bossbar.png"))
						.getScaledInstance(672, 20, java.awt.Image.SCALE_SMOOTH);
				
				
			} 
			catch (final IOException e) 
			{

				e.printStackTrace();
			}
			
		}
		
		
		
		public static Image getWorld1()
		{	
			return world1;
		}	
		public static Image getWorld2()
		{	
			return world2;
		}
		public static Image getWorld3()
		{	
			return world3;
		}

		public static Image getEnemy_right()
		{	
			return enemy_right;
		}
		public static Image getEnemy_left()
		{	
			return enemy_left;
		}
		public static Image getCharacterRight() 
		{
			return character_right;
		}
		public static Image getCharacterLeft() 
		{
			return character_left;
		}

		public static Image getLife(int x , int y) 	
		{
			return boss_life.getScaledInstance(x, y, java.awt.Image.SCALE_DEFAULT);
		}	
		public static Image getBar() 
		{
			return boss_bar;
		}

		public static Image getBullet() 	
		{
			return bullet;
		}
		public static Image getGround(int x , int y) 	
		{
			return ground.getScaledInstance(x, y, java.awt.Image.SCALE_DEFAULT);
			 
		}
	
//		public static Image getBossBulletRight()
//		{
//			return boss_bullet_right;
//		}
		
		
		public static Image getBossBulletLeft()
		{
			return boss_bullet_left;
		}
		public static Image getBoss()
		{
			return boss;
		}
//		public static Image getBossHit()
//		{
//			return bosshit;
//		}
		
		public static Image getGunicon_avaible() 	
		{
			return gunicon_avaible;
		}
		public static Image getGunicon_notavaible() 	
		{
			return gunicon_notavaible;

		}

//		public static Image getMenu()
//		{
//			return menu_background;
//		}
//	

}
package GameObject;

import GameObject.Box.Verse;

public class Platform extends Box
{
	
	public Platform(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		tipo=Type.PLATFORM;
	}
	

}

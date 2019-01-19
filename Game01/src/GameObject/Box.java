package GameObject;

public class Box 
{
	public    int x;
	public    int y;
	public  int w;
	public  int h;
	public  enum Verse {RIGHT,LEFT,NULL};
	public Verse verse;
	public  enum Type {ENEMY,PLATFORM, CHARACTER};
	Type tipo;
	public  Box(int x,int y, Verse v,	int w,int h )
	{
		this.x=x;
		this.y=y;
		this.h=h;
		this.w=w;
		this.verse=v;
	}
	public  Box(int x,int y,	int w,int h )
	{
		this.x=x;
		this.y=y;
		this.h=h;
		this.w=w;
		this.verse=Verse.NULL;
	}
	public boolean collide(Box b)
	{
	return ((x+w >= b.x) && (y+h >= b.y) && (b.w+b.x >= x) && (b.y+b.h >= y));	

	}
	public void setxy(int x2, int y2) 
	{
		x=x2;y=y2;
		
	}

	
	
}

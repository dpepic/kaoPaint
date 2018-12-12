package geometrija;

import java.awt.Point;

public class Duz
{
	Point a;
	Point b;
	
	public Point vratiTackuA()
	{
		return this.a;
	}
	
	public Point vratiTackuB()
	{
		return this.b;
	}
	
	public Duz(Point prva, Point druga)
	{
		this.a = prva;
		this.b = druga;
	}
	
	public double vratiDuzinu()
	{
		return Math.sqrt((Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2)));  
	}
}

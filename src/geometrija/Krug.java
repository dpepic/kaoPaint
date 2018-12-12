package geometrija;

import java.awt.Point;

public class Krug 
{
	Point centar;
	Duz precnik;

	public Krug(Point c, Duz p)
	{
		this.centar = c;
		this.precnik = p;
	}
	
	public double povrsina()
	{
		return Math.PI * Math.pow(precnik.vratiDuzinu(), 2);
	}
	
	public double obim()
	{
		return Math.PI * precnik.vratiDuzinu() * 2;
	}
}

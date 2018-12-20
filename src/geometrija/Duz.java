package geometrija;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Duz extends Figura 
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
	
	public int vratiDuzinu()
	{
		return (int)Math.round(Math.sqrt((Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2))));  
	}

	@Override
	public void iscrtajSe(Graphics povrsinaZaCrtanje) 
	{
		povrsinaZaCrtanje.drawLine(this.a.x, this.a.y,
				                   this.b.x, this.b.y);
	}

	@Override
	public int vratiVisinu() 
	{
		return this.debljina;
	}
}

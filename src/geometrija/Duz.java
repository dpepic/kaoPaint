package geometrija;

import java.awt.Color;
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
		this.gornjaLeva = this.vratiGornjuLevu();
	}
	
	public int vratiDuzinu()
	{
		return (int)Math.abs(this.a.getX() - this.b.getX());  
	}

	@Override
	public void iscrtajSe(Graphics povrsinaZaCrtanje) 
	{
		super.iscrtajSe(povrsinaZaCrtanje);
		povrsinaZaCrtanje.drawLine(this.a.x, this.a.y,
				                   this.b.x, this.b.y);
	}

	@Override
	public int vratiVisinu() 
	{
		return (int)Math.abs(this.a.getY() - this.b.getY());
	}
	
	@Override
	public Point vratiGornjuLevu()
	{
		Point tacka;
		if (a.getX() <= b.getX() && a.getY() <= b.getY())
		{
			tacka = this.a;
		} else if (a.getX() <= b.getX() && a.getY() > b.getY())
		{
			tacka = new Point((int)a.getX(), (int)a.getY() - this.vratiVisinu());
		} else if (a.getX() > b.getX() && a.getY() > b.getY())
		{
			tacka = this.b;
		} else 
		{
			tacka = new Point((int)b.getX(), (int)b.getY() - this.vratiVisinu());
		}
		return tacka;
	}
}

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
		if (prva.x <= druga.x)
		{
			this.gornjaLeva = prva;
		} else
		{
			this.gornjaLeva = druga;
		}
		this.a = prva;
		this.b = druga;
		
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
		
		povrsinaZaCrtanje.setColor(Color.CYAN);
		povrsinaZaCrtanje.drawRect(this.gornjaLeva.x, this.gornjaLeva.y, 
									100, 100);
	}

	@Override
	public int vratiVisinu() 
	{
		return (int)Math.abs(this.a.getY() - this.b.getY());
	}
}

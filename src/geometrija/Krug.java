package geometrija;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Krug extends Figura  
{
	
	Point centar;
	Duz precnik;
	boolean pun = false;
	
	public Point getCentar()
	{
		return this.centar;
	}
	
	public Duz getPrecnik()
	{
		return this.precnik;
	}

	public Krug(Point c, Duz p, boolean pun)
	{
		this.centar = c;
		this.precnik = p;
		this.pun = pun;
	}
	
	public double povrsina()
	{
		return Math.PI * Math.pow(precnik.vratiDuzinu(), 2);
	}
	
	public double obim()
	{
		return Math.PI * precnik.vratiDuzinu() * 2;
	}

	@Override
	public void iscrtajSe(Graphics povrsinaZaCrtanje) 
	{
		if (this.pun)
		{
			povrsinaZaCrtanje.fillOval(this.centar.x, this.centar.y, (int)this.precnik.vratiDuzinu(), (int)this.precnik.vratiDuzinu());	
		} else
		{
			povrsinaZaCrtanje.drawOval(this.centar.x, this.centar.y, (int)this.precnik.vratiDuzinu(), (int)this.precnik.vratiDuzinu());	
		}
		
	}
}

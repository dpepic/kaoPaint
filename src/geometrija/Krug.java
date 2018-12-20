package geometrija;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Krug extends Figura  
{
	
	Point centar;
	int duzina;
	boolean pun = false;
	
	public Point getCentar()
	{
		return this.centar;
	}
	
	public int vratiDuzinu()
	{
		return this.duzina;
	}

	public Krug(Point c, int duzina, boolean pun)
	{
		this.centar = c;
		this.duzina = duzina;
		this.pun = pun;
	}
	
	public double povrsina()
	{
		return 0;
	}
	
	public double obim()
	{
		return 0;
	}

	@Override
	public void iscrtajSe(Graphics povrsinaZaCrtanje) 
	{
		if (this.pun)
		{
			povrsinaZaCrtanje.fillOval(this.centar.x, this.centar.y, this.duzina, this.duzina);	
		} else
		{
			povrsinaZaCrtanje.drawOval(this.centar.x, this.centar.y, this.duzina, this.duzina);	
		}
		
	}
}

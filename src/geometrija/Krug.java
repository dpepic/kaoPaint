package geometrija;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Krug extends Figura  
{
	int duzina;
	boolean pun = false;
	
	
	public int vratiDuzinu()
	{
		return this.duzina;
	}
	
	public int vratiVisinu()
	{
		return this.duzina;
	}

	public Krug(Point c, int duzina, boolean pun)
	{
		this.gornjaLeva = c;
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
			povrsinaZaCrtanje.fillOval(this.gornjaLeva.x, this.gornjaLeva.y, this.duzina, this.duzina);	
		} else
		{
			povrsinaZaCrtanje.drawOval(this.gornjaLeva.x, this.gornjaLeva.y, this.duzina, this.duzina);	
		}
		
	}
}

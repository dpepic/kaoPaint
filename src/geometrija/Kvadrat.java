package geometrija;

import java.awt.Graphics;
import java.awt.Point;

public class Kvadrat extends Figura
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
	
	public Kvadrat (Point start, int duzina, boolean pun)
	{
		this.gornjaLeva = start;
		this.duzina = duzina;
		this.pun = pun;
	}

	public double povrsina()
	{
		return Math.pow(this.duzina, 2);
	}

	public double obim()
	{
		return this.duzina*4;
	}

	@Override
	public void iscrtajSe(Graphics povrsinaZaCrtanje) 
	{
		if (this.pun)
		{
			povrsinaZaCrtanje.fillRect(this.gornjaLeva.x, 
					this.gornjaLeva.y, 
					this.duzina, this.duzina);
		} else
		{
			povrsinaZaCrtanje.drawRect(this.gornjaLeva.x, 
					this.gornjaLeva.y, 
					this.duzina, this.duzina);
		}
	}
}

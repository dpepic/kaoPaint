package geometrija;

import java.awt.Graphics;
import java.awt.Point;

public class Kvadrat extends Figura
{
	Point gornjaLevaTacka;
	int duzina;
	boolean pun = false;

	public Point vratiGornjuLevu()
	{
		return this.gornjaLevaTacka;
	}

	public int vratiDuzinu()
	{
		return this.duzina;
	}
	
	public Kvadrat (Point start, int duzina, boolean pun)
	{
		this.gornjaLevaTacka = start;
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
			povrsinaZaCrtanje.fillRect(this.gornjaLevaTacka.x, 
					this.gornjaLevaTacka.y, 
					this.duzina, this.duzina);
		} else
		{
			povrsinaZaCrtanje.drawRect(this.gornjaLevaTacka.x, 
					this.gornjaLevaTacka.y, 
					this.duzina, this.duzina);
		}
	}
}

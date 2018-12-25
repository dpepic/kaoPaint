package geometrija;

import java.awt.Graphics;
import java.awt.Point;

public class Kvadrat extends Figura
{
	int duzina;
	int visina;

	public int vratiDuzinu()
	{
		return this.duzina;
	}
	
	public int vratiVisinu()
	{
		return this.visina;
	}
	
	public Kvadrat (Point start, int duzina, int visina, boolean pun)
	{
		this.gornjaLeva = start;
		this.duzina = duzina;
		this.visina = visina;
		this.pun = pun;
	}

	public double povrsina()
	{
		return this.duzina * this.visina;
	}

	public double obim()
	{
		return this.duzina*2 + this.visina*2;
	}

	@Override
	public void iscrtajSe(Graphics povrsinaZaCrtanje) 
	{
		super.iscrtajSe(povrsinaZaCrtanje);
		if (this.pun)
		{
			povrsinaZaCrtanje.fillRect(this.gornjaLeva.x, 
					this.gornjaLeva.y, 
					this.duzina, this.visina);
		} else
		{
			povrsinaZaCrtanje.drawRect(this.gornjaLeva.x, 
					this.gornjaLeva.y, 
					this.duzina, this.visina);
		}
	}
}

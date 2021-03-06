package geometrija;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class Krug extends Figura  
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

	public Krug(Point c, int duzina, int visina, boolean pun)
	{
		this.gornjaLeva = c;
		this.duzina = duzina;
		this.visina = visina;
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
		super.iscrtajSe(povrsinaZaCrtanje);
		
		if (this.pun)
		{
			povrsinaZaCrtanje.fillOval(this.gornjaLeva.x, this.gornjaLeva.y, this.duzina, this.visina);	
		} else
		{
			povrsinaZaCrtanje.drawOval(this.gornjaLeva.x, this.gornjaLeva.y, this.duzina, this.visina);	
		}
	}
}

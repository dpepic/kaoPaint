package geometrija;

import java.awt.Graphics;
import java.awt.Point;

public class Pravougaonik extends Kvadrat 
{
	int visina;
	
	public int vratiVisinu()
	{
		return this.visina;
	}
	
	public Pravougaonik(Point start, int duzina, int visina, boolean pun) 
	{
		super(start, duzina, pun);
		this.visina = visina;
	}

	public double povrsina()
	{
		return 0;
	}
	
	@Override
	public void iscrtajSe(Graphics povrsinaZaCrtanje) 
	{
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

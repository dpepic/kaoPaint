package geometrija;

import java.awt.Graphics;
import java.awt.Point;

public class Elipsa extends Krug 
{
	int visina;
	
	@Override
	public int vratiVisinu()
	{
		return this.visina;
	}
	
	public Elipsa(Point c, int visina, int sirina, boolean pun)
	{
		super(c, sirina, pun);
		this.visina = visina;
	}
	
	@Override
	public void iscrtajSe(Graphics povrsinaZaCrtanje) 
	{
		if (this.pun)
		{
			povrsinaZaCrtanje.fillOval(this.gornjaLeva.x, this.gornjaLeva.y, this.duzina, this.visina);	
		} else
		{
			povrsinaZaCrtanje.drawOval(this.gornjaLeva.x, this.gornjaLeva.y, this.duzina, this.visina);	
		}
	}

}

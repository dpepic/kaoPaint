package geometrija;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

abstract public class Figura implements Serializable 
{
	public String boja = "crna";
	public int debljina = 1;
	Point gornjaLeva;
	public boolean selektovana = false;
	
	public Point vratiGornjuLevu()
	{
		return this.gornjaLeva;
	}
	
	private static final long serialVersionUID = 7077851300107758074L;

	public void iscrtajSe(Graphics povrsinaZaCrtanje)
	{
		if (this.selektovana)
		{
			povrsinaZaCrtanje.setColor(Color.PINK);
			
			Graphics2D g2d = (Graphics2D)povrsinaZaCrtanje;
			g2d.setStroke(new BasicStroke(3));
			
			povrsinaZaCrtanje.drawString("SELEKTOVANA!", this.gornjaLeva.x, this.gornjaLeva.y);
		}
	}
	abstract public int vratiDuzinu();
	abstract public int vratiVisinu();
}

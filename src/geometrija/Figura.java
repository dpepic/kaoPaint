package geometrija;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.Serializable;

abstract public class Figura implements Serializable 
{
	public Color boja = Color.BLACK;
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
			
			povrsinaZaCrtanje.fillRect(this.vratiGornjuLevu().x - 5, this.vratiGornjuLevu().y - 5, 
					                   10, 10);
			povrsinaZaCrtanje.fillRect(this.vratiGornjuLevu().x + this.vratiDuzinu() - 5, this.vratiGornjuLevu().y - 5, 
	                   10, 10);
			povrsinaZaCrtanje.fillRect(this.vratiGornjuLevu().x - 5, this.vratiGornjuLevu().y + this.vratiVisinu() - 5, 
	                   10, 10);
			povrsinaZaCrtanje.fillRect(this.vratiGornjuLevu().x + this.vratiDuzinu() - 5, this.vratiGornjuLevu().y + this.vratiVisinu() - 5, 
	                   10, 10);
		}
		povrsinaZaCrtanje.setColor(this.boja);
	}
	abstract public int vratiDuzinu();
	abstract public int vratiVisinu();
}

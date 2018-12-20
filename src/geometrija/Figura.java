package geometrija;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

abstract public class Figura implements Serializable 
{
	public String boja = "crna";
	public int debljina = 1;
	Point gornjaLeva;
	
	public Point vratiGornjuLevu()
	{
		return this.gornjaLeva;
	}
	
	private static final long serialVersionUID = 7077851300107758074L;

	abstract public void iscrtajSe(Graphics povrsinaZaCrtanje);
	abstract public int vratiDuzinu();
	abstract public int vratiVisinu();
}

package geometrija;

import java.awt.Graphics;
import java.awt.Point;

public class Kvadrat extends Figura
{
	Point gornjaLevaTacka;
	int duzina;
	
	public Point vratiGornjuLevu()
	{
		return this.gornjaLevaTacka;
	}
	
	public int vratiDuzinu()
	{
		return this.duzina;
	}
	
	public Kvadrat (Point start, int duzina)
	{
		this.gornjaLevaTacka = start;
		this.duzina = duzina;
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
		povrsinaZaCrtanje.drawRect(this.gornjaLevaTacka.x, 
				                   this.gornjaLevaTacka.y, 
				                   this.duzina, this.duzina);
	}
}

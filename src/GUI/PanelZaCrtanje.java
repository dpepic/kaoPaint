package GUI;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;
import java.util.*;
import geometrija.*;

public class PanelZaCrtanje extends JPanel
{
	public Vector<Figura> figure = new Vector<Figura>();
	
	Duz linijaZaIscrtavanje;
	Krug krugZaIscrtavanje;
	Kvadrat kvadZaIscrtavanje;
	Point pocetnaTacka = new Point();
	public boolean crtanjeUtoku = false;
	public String figuraZaIscrtavanje = "duz";
	
	public void iscrtavanje(int x, int y)
	{
		if (crtanjeUtoku)
		{
			switch (this.figuraZaIscrtavanje)
			{
				case "duz":
					linijaZaIscrtavanje = new Duz(pocetnaTacka, new Point(x, y));
					break;
				case "krug":
					Point centar = new Point();
					
					if (pocetnaTacka.x < x)
					{
						centar.x = pocetnaTacka.x;
					} else
					{
						centar.x = x;
					}

					if (pocetnaTacka.y < y)
					{
						centar.y = pocetnaTacka.y;
					} else
					{
						centar.y = y;
					}
						
					krugZaIscrtavanje = new Krug(centar, new Duz(pocetnaTacka, new Point(x, y)));	
					break;
				case "kvadrat":
					Point levaGornja = new Point();
					if (pocetnaTacka.x < x)
					{
						levaGornja.x = pocetnaTacka.x;
					} else
					{
						levaGornja.x = x;
					}
					
					if (pocetnaTacka.y < y)
					{
						levaGornja.y = pocetnaTacka.y;
					} else
					{
						levaGornja.y = y;
					}
					
					this.kvadZaIscrtavanje = new Kvadrat(levaGornja, (int)(new Duz(this.pocetnaTacka, new Point(x, y))).vratiDuzinu());
					break;
			}
			this.repaint();
		}
	}

	public String crtajKrug(int x, int y)
	{
		if (crtanjeUtoku)
		{
			Duz linija = new Duz(pocetnaTacka, new Point(x, y));

			Point centar = new Point();
			if (pocetnaTacka.x < x)
			{
				centar.x = pocetnaTacka.x;
			} else
			{
				centar.x = x;
			}
			if (pocetnaTacka.y < y)
			{
				centar.y = pocetnaTacka.y;
			} else
			{
				centar.y = y;
			}
			
			Krug nekiKrug = new Krug(centar, linija);
	
			figure.add(nekiKrug);
			crtanjeUtoku = false;
			this.repaint();
			return "Kruznica iscrtana!";
		} else
		{
			crtanjeUtoku = true;
			pocetnaTacka = new Point(x, y);
			return "Kliknite na precnik kruga";
		}
	}
	public String crtajDuz(int x, int y)
	{
		if (crtanjeUtoku)
		{
			Duz linija = new Duz(pocetnaTacka, new Point(x, y));
		
			figure.add(linija);
			crtanjeUtoku = false;
			this.repaint();
			return "Duz iscrtana";
		} else
		{
			crtanjeUtoku = true;
			pocetnaTacka = new Point(x, y);
			return "Kliknite na drugu tacku duzi";
		}
	}
	
	public String crtajKvad(int x, int y) 
	{
		if (this.crtanjeUtoku)
		{
			Point levaGornja = new Point();
			if (pocetnaTacka.x < x)
			{
				levaGornja.x = pocetnaTacka.x;
			} else
			{
				levaGornja.x = x;
			}
			
			if (pocetnaTacka.y < y)
			{
				levaGornja.y = pocetnaTacka.y;
			} else
			{
				levaGornja.y = y;
			}
			
			Kvadrat kvad = new Kvadrat(levaGornja, (int)(new Duz(this.pocetnaTacka, new Point(x, y))).vratiDuzinu());
			figure.add(kvad);
			this.crtanjeUtoku = false;
			this.repaint();
			return "Kvadrat nacrtan!";
		} else
		{
			pocetnaTacka = new Point(x, y);
			this.crtanjeUtoku = true;
			return "Odredite duzinu stranice kvadrata...";
		}
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (Figura neka: figure)
		{
			neka.iscrtajSe(g);
		}
		
		
		if (crtanjeUtoku)
		{
			switch(this.figuraZaIscrtavanje)
			{
				case "duz":
					g.drawLine(linijaZaIscrtavanje.vratiTackuA().x, linijaZaIscrtavanje.vratiTackuA().y,
							linijaZaIscrtavanje.vratiTackuB().x, linijaZaIscrtavanje.vratiTackuB().y);
					break;
				case "krug":
					g.drawOval(krugZaIscrtavanje.getCentar().x, krugZaIscrtavanje.getCentar().y, (int)krugZaIscrtavanje.getPrecnik().vratiDuzinu(), (int)krugZaIscrtavanje.getPrecnik().vratiDuzinu());
					break;
				case "kvadrat":
					g.drawRect(this.kvadZaIscrtavanje.vratiGornjuLevu().x,
							   this.kvadZaIscrtavanje.vratiGornjuLevu().y, 
							   this.kvadZaIscrtavanje.vratiDuzinu(), this.kvadZaIscrtavanje.vratiDuzinu());
					break;
			}
		}
	}
}

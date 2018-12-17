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
	Point pocetnaTacka = new Point();
	public boolean crtanjeUtoku = false;
	public boolean crtamoLiniju = true;
	
	public void iscrtavanje(int x, int y)
	{
		if (crtanjeUtoku)
		{
			if (this.crtamoLiniju)
			{
				linijaZaIscrtavanje = new Duz(pocetnaTacka, new Point(x, y));
			} else
			{
				Point centar = new Point();
				
				if (pocetnaTacka.x < x)
				{
					centar.x = pocetnaTacka.x;
				} else
				{
					centar.x = x;
				}
				centar.y = y;
				//if (pocetnaTacka.y < y)
				//{
				//	centar.y = pocetnaTacka.y;
				//} else
				//{
				//	centar.y = y;
				//}
					
				krugZaIscrtavanje = new Krug(centar, new Duz(pocetnaTacka, new Point(x, y)));	
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
			centar.y = y;
			//if (pocetnaTacka.y < y)
			//{
			//	centar.y = pocetnaTacka.y;
			//} else
			//{
			//	centar.y = y;
			//}
			
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
			if (this.crtamoLiniju)
			{
				g.drawLine(linijaZaIscrtavanje.vratiTackuA().x, linijaZaIscrtavanje.vratiTackuA().y,
						linijaZaIscrtavanje.vratiTackuB().x, linijaZaIscrtavanje.vratiTackuB().y);
			} else
			{
				g.drawOval(krugZaIscrtavanje.getCentar().x, krugZaIscrtavanje.getCentar().y, (int)krugZaIscrtavanje.getPrecnik().vratiDuzinu(), (int)krugZaIscrtavanje.getPrecnik().vratiDuzinu());
			}
		}
	}
}

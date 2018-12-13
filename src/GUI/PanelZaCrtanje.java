package GUI;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;
import java.util.*;
import geometrija.*;

public class PanelZaCrtanje extends JPanel
{
	public Vector<Duz> duzi = new Vector<Duz>();
	public Vector<Krug> krugovi = new  Vector<Krug>();
	Duz linijaZaIscrtavanje;
	Point pocetnaTacka = new Point();
	public boolean crtanjeUtoku = false;
	
	public void iscrtavanje(int x, int y)
	{
		if (crtanjeUtoku)
		{
			linijaZaIscrtavanje = new Duz(pocetnaTacka, new Point(x, y));
			this.repaint();
		}
	}

	public String crtajKrug(int x, int y)
	{
		if (crtanjeUtoku)
		{
			Duz linija = new Duz(pocetnaTacka, new Point(x, y));
			int sirina = (int) Math.abs(pocetnaTacka.getX() - x);
			int visina = (int) Math.abs(pocetnaTacka.getY() - y);

			int centarX = (int) (pocetnaTacka.getX() - 200/2);
			int centarY = (int) (pocetnaTacka.getY() - 200/2);
			System.out.println("Centar je: X: " + pocetnaTacka.getX() +
					           "Y:  " + pocetnaTacka.getY());
			
			System.out.println("Pravi centar je: X: " + centarX +
			           "Y:  " + centarY);
			Krug nekiKrug = new Krug(new Point(centarX, centarY), linija);
			krugovi.add(nekiKrug);
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
			duzi.add(linija);
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
		
		for (Krug kr: krugovi)
		{
			g.drawOval(kr.getCentar().x, kr.getCentar().y, 200, 200);
		}
		for (Duz linija: duzi)
		{
			g.drawLine(linija.vratiTackuA().x, linija.vratiTackuA().y,
					   linija.vratiTackuB().x, linija.vratiTackuB().y);
		}
		if (crtanjeUtoku)
		{
			g.drawLine(linijaZaIscrtavanje.vratiTackuA().x, linijaZaIscrtavanje.vratiTackuA().y,
				       linijaZaIscrtavanje.vratiTackuB().x, linijaZaIscrtavanje.vratiTackuB().y);
		}
	}
}

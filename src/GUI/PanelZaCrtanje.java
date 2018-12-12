package GUI;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;
import java.util.*;
import geometrija.*;

public class PanelZaCrtanje extends JPanel
{
	public Vector<Duz> duzi = new Vector<Duz>();
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

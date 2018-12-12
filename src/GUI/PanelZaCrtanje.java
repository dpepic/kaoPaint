package GUI;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;
import java.util.*;
import geometrija.*;

public class PanelZaCrtanje extends JPanel
{
	Vector<Duz> duzi = new Vector<Duz>();

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (Duz linija: duzi)
		{
			g.drawLine(linija.vratiTackuA().x, linija.vratiTackuA().y,
					   linija.vratiTackuB().x, linija.vratiTackuB().y);
		}
	}
}

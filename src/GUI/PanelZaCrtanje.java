package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	Pravougaonik pravougZaIscrtavanje;
	Elipsa elipsaZaIscrtavanje;
	Point pocetnaTacka = new Point();
	public boolean crtanjeUtoku = false;
	public String figuraZaIscrtavanje = "duz";
	public String bojaZaCrtanje = "crna";
	public int debljinaLinije = 1;
	public boolean pun = false;
	public boolean lock = true;

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
				Point gornjaLeva = new Point();

				if (pocetnaTacka.x < x)
				{
					gornjaLeva.x = pocetnaTacka.x;
				} else
				{
					gornjaLeva.x = x;
				}

				if (pocetnaTacka.y < y)
				{
					gornjaLeva.y = pocetnaTacka.y;
				} else
				{
					gornjaLeva.y = y;
				}

				if (this.lock)
				{
					int visina = Math.abs(pocetnaTacka.y - y);
					int duzina = Math.abs(pocetnaTacka.x - x);
					int duzinaKruga = 0;

					//pitanje       //ako je tacno      //ako nije tacno
					duzinaKruga =    (visina>duzina)      ?    visina           :          duzina;
					krugZaIscrtavanje = new Krug(gornjaLeva, duzinaKruga, false);	
				} else
				{
					int visina = Math.abs(pocetnaTacka.y - y);
					int duzina = Math.abs(pocetnaTacka.x - x);
					elipsaZaIscrtavanje = new Elipsa(gornjaLeva, visina, duzina, false);
				}
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
				int visina = Math.abs(pocetnaTacka.y - y);
				int duzina = Math.abs(pocetnaTacka.x - x);

				if (this.lock)
				{
					int duzinaKvad = 0;

					//pitanje       //ako je tacno      //ako nije tacno
					duzinaKvad =    (visina>duzina)      ?    visina           :          duzina;

					this.kvadZaIscrtavanje = new Kvadrat(levaGornja, duzinaKvad, this.pun);
				} else
				{
					pravougZaIscrtavanje = new Pravougaonik(levaGornja, duzina, visina, this.pun);
				}
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

			Point gornjaLeva = new Point();
			if (pocetnaTacka.x < x)
			{
				gornjaLeva.x = pocetnaTacka.x;
			} else
			{
				gornjaLeva.x = x;
			}
			if (pocetnaTacka.y < y)
			{
				gornjaLeva.y = pocetnaTacka.y;
			} else
			{
				gornjaLeva.y = y;
			}

			if (this.lock)
			{
				int visina = Math.abs(pocetnaTacka.y - y);
				int duzina = Math.abs(pocetnaTacka.x - x);
				int duzinaKruga = 0;

				//pitanje       //ako je tacno      //ako nije tacno
				duzinaKruga =    (visina>duzina)      ?    visina           :          duzina;	
			
				Krug nekiKrug = new Krug(gornjaLeva, duzinaKruga, false);
				nekiKrug.boja = this.bojaZaCrtanje;
				nekiKrug.debljina = this.debljinaLinije;
				figure.add(nekiKrug);
			} else
			{
				int visina = Math.abs(pocetnaTacka.y - y);
				int duzina = Math.abs(pocetnaTacka.x - x);
				
				Elipsa nekaElipsa = new Elipsa(gornjaLeva, visina, duzina, this.pun);
				figure.add(nekaElipsa);
			}
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
			linija.boja = this.bojaZaCrtanje;
			linija.debljina = this.debljinaLinije;
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

			int visina = Math.abs(pocetnaTacka.y - y);
			int duzina = Math.abs(pocetnaTacka.x - x);

			if (this.lock)
			{
				int duzinaKvad = 0;
				//pitanje           //ako je tacno           //ako nije tacno
				duzinaKvad =    (visina>duzina)      ?    visina           :          duzina;

				Kvadrat kvad = new Kvadrat(levaGornja, duzinaKvad, this.pun);

				kvad.boja = this.bojaZaCrtanje;
				kvad.debljina = this.debljinaLinije;
				figure.add(kvad);
			} else
			{
				Pravougaonik pravoUg = new Pravougaonik(levaGornja, duzina, visina, this.pun);
				pravoUg.boja = this.bojaZaCrtanje;
				pravoUg.debljina = this.debljinaLinije;
				figure.addElement(pravoUg);
			}

			this.crtanjeUtoku = false;
			this.repaint();
			return "Kvadrat nacrtan!";
		} else
		{
			pocetnaTacka = new Point(x, y);
			this.crtanjeUtoku = true;
			if (this.lock)
			{
				return "Odredite duzinu stranice kvadrata...";
			} else
			{
				return "Odredite duzinu stranice pravougaonika...";
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;

		for (Figura neka: figure)
		{
			g2d.setStroke(new BasicStroke(neka.debljina));
			switch (neka.boja)
			{
			case "crna":
				g.setColor(Color.BLACK);
				break;
			case "zelena":
				g.setColor(Color.GREEN);
				break;
			case "crvena":
				g.setColor(Color.RED);
				break;
			case "siva":
				g.setColor(Color.GRAY);
				break;
			case "zuta":
				g.setColor(Color.YELLOW);
				break;
			case "plava":
				g.setColor(Color.BLUE);
				break;
			}
			neka.iscrtajSe(g);
		}


		if (crtanjeUtoku)
		{
			g.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(1));
			switch(this.figuraZaIscrtavanje)
			{
			case "duz":
				g.drawLine(linijaZaIscrtavanje.vratiTackuA().x, linijaZaIscrtavanje.vratiTackuA().y,
						linijaZaIscrtavanje.vratiTackuB().x, linijaZaIscrtavanje.vratiTackuB().y);
				break;
			case "krug":
				if (this.lock)
				{
					g.drawOval(krugZaIscrtavanje.getCentar().x, krugZaIscrtavanje.getCentar().y, krugZaIscrtavanje.vratiDuzinu(), krugZaIscrtavanje.vratiDuzinu());
				} else
				{
					g.drawOval(elipsaZaIscrtavanje.getCentar().x, elipsaZaIscrtavanje.getCentar().y, elipsaZaIscrtavanje.vratiDuzinu(), elipsaZaIscrtavanje.vratiVisinu());
				}
				break;
			case "kvadrat":
				if (this.lock)
				{
					g.drawRect(this.kvadZaIscrtavanje.vratiGornjuLevu().x,
							this.kvadZaIscrtavanje.vratiGornjuLevu().y, 
							this.kvadZaIscrtavanje.vratiDuzinu(), this.kvadZaIscrtavanje.vratiDuzinu());
				} else
				{
					g.drawRect(this.pravougZaIscrtavanje.vratiGornjuLevu().x,
							this.pravougZaIscrtavanje.vratiGornjuLevu().y, 
							this.pravougZaIscrtavanje.vratiDuzinu(), this.pravougZaIscrtavanje.vratiVisinu());
				}
				break;
			}
		}
	}
}

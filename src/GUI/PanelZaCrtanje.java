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
	Figura selektovanaFig = null;
	Point pocetnaTacka = new Point();
	public boolean crtanjeUtoku = false;
	public String figuraZaIscrtavanje = "duz";
	public Color bojaZaCrtanje = Color.BLACK;
	public int debljinaLinije = 1;
	public boolean pun = false;
	public boolean lock = true;
	boolean postojiSelektovana = false;

	public void selektuj(int x, int y)
	{
		for (Figura fig: this.figure)
		{
			if ((fig.vratiGornjuLevu().x <= x) && 
			    (x <= fig.vratiGornjuLevu().x + fig.vratiDuzinu()) &&
			    (fig.vratiGornjuLevu().y <= y)  &&
			    (y <= fig.vratiGornjuLevu().y + fig.vratiVisinu()))
			{
				if (fig.selektovana)
				{
					continue;
				}
				
				for (Figura deselekt: this.figure)
				{
					deselekt.selektovana = false;
				}
				fig.selektovana = true;
				this.postojiSelektovana = true;
				this.repaint();
				return;
			}	
		}
		
		for (Figura fig: this.figure)
		{
			fig.selektovana = false;
			this.postojiSelektovana = false;
		}
		this.repaint();
	}
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

					                     //pitanje           //ako je tacno      //ako nije tacno
					duzinaKruga =    (visina>duzina)      ?    visina           :          duzina;
					krugZaIscrtavanje = new Krug(gornjaLeva, duzinaKruga, duzinaKruga, false);	
				} else
				{
					int visina = Math.abs(pocetnaTacka.y - y);
					int duzina = Math.abs(pocetnaTacka.x - x);
					krugZaIscrtavanje = new Krug(gornjaLeva, duzina, visina, false);
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

					this.kvadZaIscrtavanje = new Kvadrat(levaGornja, duzinaKvad, duzinaKvad, this.pun);
				} else
				{
					this.kvadZaIscrtavanje = new Kvadrat(levaGornja, duzina, visina, this.pun);
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
			
				Krug nekiKrug = new Krug(gornjaLeva, duzinaKruga, duzinaKruga, this.pun);
				nekiKrug.boja = this.bojaZaCrtanje;
				nekiKrug.debljina = this.debljinaLinije;
				figure.add(nekiKrug);
			} else
			{
				int visina = Math.abs(pocetnaTacka.y - y);
				int duzina = Math.abs(pocetnaTacka.x - x);
				
				Krug nekaElipsa = new Krug(gornjaLeva, duzina, visina, this.pun);
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

				Kvadrat kvad = new Kvadrat(levaGornja, duzinaKvad, duzinaKvad, this.pun);

				kvad.boja = this.bojaZaCrtanje;
				kvad.debljina = this.debljinaLinije;
				figure.add(kvad);
			} else
			{
				Kvadrat pravoUg = new Kvadrat(levaGornja, duzina, visina, this.pun);
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
		Figura selektovana = null;

		for (Figura neka: figure)
		{
			if (neka.selektovana)
			{
				selektovana = neka;
			}
			g2d.setStroke(new BasicStroke(neka.debljina));
			
			neka.iscrtajSe(g);
		}
		
		
		if (!(selektovana == null))
		{
			selektovana.iscrtajSe(g);
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
					g.drawOval(krugZaIscrtavanje.vratiGornjuLevu().x, krugZaIscrtavanje.vratiGornjuLevu().y, krugZaIscrtavanje.vratiDuzinu(), krugZaIscrtavanje.vratiVisinu());
				break;
			case "kvadrat":
				g.drawRect(this.kvadZaIscrtavanje.vratiGornjuLevu().x,
							this.kvadZaIscrtavanje.vratiGornjuLevu().y, 
							this.kvadZaIscrtavanje.vratiDuzinu(), this.kvadZaIscrtavanje.vratiVisinu());
				break;
			}
		}
	}
}

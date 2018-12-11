package geometrija;

public class Pravougaonik extends Kvadrat 
{
	public Pravougaonik (Duz duzina, Duz visina)
	{
		stranice = new Duz[4];
		
		for (int i = 1; i < 5; i++)
		{
			if (i%2 == 0)
			{
				stranice[i-1] = duzina;
			} else
			{
				stranice[i-1] = visina;
			}
		}
	}
	
	public double povrsina()
	{
		return stranice[0].vratiDuzinu() * stranice[1].vratiDuzinu();
	}
}

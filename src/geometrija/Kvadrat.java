package geometrija;

public class Kvadrat 
{
	Duz[] stranice;
	
	public Kvadrat ()
	{
		stranice = null;
	}
	
	public Kvadrat (Duz stranica)
	{
		this.stranice = new Duz[4];
		
		for (int i = 0; i < 4; i++)
		{
			this.stranice[i] = stranica;
		}
	}
	
	public double povrsina()
	{
		return Math.pow(stranice[0].vratiDuzinu(), 2);
	}
	
	public double obim()
	{
		double obim = 0;
		
		for (Duz stranica: stranice)
		{
			obim += stranica.vratiDuzinu();
		}
		return obim;
	}

}
